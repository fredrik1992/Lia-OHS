package com.example.ohsapp;

import com.example.ohsapp.GetOrders;
import com.example.ohsapp.beans.OrderProductBean;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class sendCSV {

    GetOrders getOrders = new GetOrders();
    private ArrayList<OrderProductBean> orderlist;





    public boolean  orderToCSVFile() {
        orderlist = getOrders.getOrder();

        if (orderlist!=null){
            String SAMPLE_CSV_FILE = "./sample.csv";
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
                 CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                         .withHeader("ProductName", "ArticleNumber", "DFP", "KFP"));){

                for (OrderProductBean order : orderlist){
                    csvPrinter.printRecord(order.getName(), order.getArticleNum(), order.getDfp(), order.getKfp());
                }
                return true;
            }
            catch (Exception e){

            }
        }
        return false;
    }

}
