package com.example.ohsapp.controller;

import com.example.ohsapp.beans.ProduktBean;
import com.example.ohsapp.beans.ProduktListBean;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@ControllerAdvice

public class GetProductsController {
    private String inputDataToUse;
    ProduktListBean produktListBean = new ProduktListBean();
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/getProductsController", method = RequestMethod.GET)
    public void multibleInputHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "ean") String ean,
                                     @RequestParam(name = "article") String article,
                                     @RequestParam(name = "productName") String productName,
                                    @RequestParam(name = "page") String page) throws ServletException, IOException {
        produktListBean.nullList();
        String searchQuery = findRelevantQuery(ean, article, productName);

        if (searchQuery != null) {

            addProductsCall(produktListBean, inputDataToUse, searchQuery);


        }

        HttpSession session = request.getSession();
        session.setAttribute("test", produktListBean);

        if(page.equals("searchWindow")){
            RequestDispatcher rd = request.getRequestDispatcher("searchWindow.jsp");
            rd.forward(request, response);
        }
        else{RequestDispatcher rd = request.getRequestDispatcher("orderWindow.jsp");
        rd.forward(request, response);}


    }


    private String findRelevantQuery(String ean, String article, String productName) {
        //checks wich Querry to use
        if (ean.length() != 0) {//checks wich input has been filled
            inputDataToUse = ean;
            String sqlQuerry = "SELECT * FROM products WHERE EANNumber = ?";
            return sqlQuerry; // this is the column name we will be using

        } else if (article.length() != 0) {
            inputDataToUse = article;
            String sqlQuerry = "SELECT * FROM products WHERE ArticleNumber = ?";
            return sqlQuerry;


        } else if (productName.length() != 0) {
            inputDataToUse = productName;
            String sqlQuerry = "SELECT * FROM products WHERE Name = ?";
            System.out.print(productName);
            System.out.print(sqlQuerry);
            return sqlQuerry;


        } else {
            return null;
        }
    }

    private void addProductsCall(ProduktListBean produktListBean,
                                 String inputData, String sqlQuerry) {


        jdbcTemplate.query(
                sqlQuerry, new Object[]{inputData},
                (rs, rowNum) -> new ProduktBean(rs.getString("ArticleNumber"),rs.getString("EANNumber"),
                        rs.getString("Trademark"),rs.getDouble("InPrice"),rs.getDouble("OutPrice"),
                        rs.getInt("StockBalance"),rs.getInt("MaxStockBalance"),rs.getInt("MinStockBalance"),
                        rs.getInt("KfpSize"),rs.getInt("DfpSize"),rs.getString("Department"),
                        rs.getString("Category"),rs.getInt("ActiveProduct"),
                        rs.getString("Name"),rs.getInt("SupplierId"))
        ).forEach(product ->
                produktListBean.addProduct(product)
        );

    }
}




















