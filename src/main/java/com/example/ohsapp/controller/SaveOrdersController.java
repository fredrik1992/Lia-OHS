package com.example.ohsapp.controller;

import com.example.ohsapp.beans.OrderProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

@Controller
@ControllerAdvice

public class SaveOrdersController {

    private static final String SAMPLE_CSV_FILE = "./sample.csv";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/SaveOrdersController", method = RequestMethod.POST)
    public void sendOrderToTable(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(name = "allOrders")String allOrders) throws ServletException, IOException {
        ArrayList<OrderProductBean> orderProductBeans;
        allOrders = cleanUpString(allOrders);
        orderProductBeans = addOrdersToList(allOrders);
        addToOrderTable(orderProductBeans);
        orderToCSVFile();
        RequestDispatcher rd = request.getRequestDispatcher("orderWindow.jsp");
        rd.forward(request, response);



    }

    private String cleanUpString(String orderString){

        orderString = orderString.replaceAll("\"", "");
        orderString = orderString.replace("[", "");
        orderString = orderString.replace("]", "");
        return orderString;
    }

    private void addToOrderTable (ArrayList<OrderProductBean> orderProductBeans){

        String latestOrderId = jdbcTemplate.queryForObject("SELECT MAX(`OrderId`) FROM `orders`", String.class);

        for (int i =0;i<orderProductBeans.size();i++){
            String sql = "INSERT INTO `orderproducts`(`OrderProductsId`, `OrderId`, `ArticleNumber`," +
                    " `KfpQuantity`, `DfpQuantity`) VALUES (?,?,?,?,?)";

            int result = jdbcTemplate.update(sql,null , latestOrderId,orderProductBeans.get(i).getArticleNum(),
                    orderProductBeans.get(i).getKfp(),orderProductBeans.get(i).getDfp());
            if(result>0){
                System.out.print("added row");
            }
        }




    }
    private ArrayList<OrderProductBean> addOrdersToList(String allOrders){

        ArrayList<OrderProductBean> tempArray = new ArrayList<>();
        String [] ordersArray = allOrders.split(",");

        int count = 0;
        String name ="";
        String articleNumber = "";
        String dfp = "";
        String kfp = "";

        for (int i = 0;i<ordersArray.length;i++){
            if (count ==0){ name = ordersArray[i]; }
            if (count ==1){articleNumber = ordersArray[i]; }
            if (count ==2){dfp = ordersArray[i]; }
            if (count ==3){kfp = ordersArray[i];}
            if(ordersArray[i].equals("$")){//new object
                OrderProductBean orderProductBean = new OrderProductBean(name,articleNumber,dfp,kfp);
                tempArray.add(orderProductBean);

                count =0;
                continue;

            }
            count++;

        }

        return tempArray;
    }

    public void orderToCSVFile() throws IOException{
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("OrderId", "ArticleNumber", "Quantity"));){
            csvPrinter.printRecord("2", "23233", "12");
        }
    }


}

