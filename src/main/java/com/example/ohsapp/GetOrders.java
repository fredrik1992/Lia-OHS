package com.example.ohsapp;

import com.example.ohsapp.beans.OrderProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
public  class GetOrders {
   private Connection conn;
    private PreparedStatement stmt = null;
    private ResultSet rs;
    private ArrayList<OrderProductBean> tempArray = new ArrayList<>();
    int orderId= getOrderId();



    public  ArrayList<OrderProductBean> getOrder() {

        getmanualOrders();
        getAutomaticOrders();
        System.out.print(tempArray.size());
        return tempArray;
    }
private void getmanualOrders (){
    try {
        createConnection();
        String sql = "SELECT products.Name,orderproducts.ArticleNumber,orderproducts.DfpQuantity,orderproducts.KfpQuantity FROM `orderproducts` INNER JOIN products ON orderproducts.ArticleNumber = products.ArticleNumber WHERE orderproducts.OrderId = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, orderId);
        rs = stmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("Name");
            String articleNumber = rs.getString("ArticleNumber");
            String dfp = Integer.toString(rs.getInt("DfpQuantity"));
            String kfp = Integer.toString(rs.getInt("KfpQuantity"));

            OrderProductBean orderProductBean = new OrderProductBean(name, articleNumber, dfp, kfp);


            tempArray.add(orderProductBean);


        }
        rs.close();
    } catch (Exception e) {
        System.out.print("wrong in statment get order");
    }


        }

    private void getAutomaticOrders(){
        String sql = "SELECT ArticleNumber,StockBalance,MaxStockBalance,MinStockBalance,KfpSize,Name FROM `products` WHERE StockBalance<MinStockBalance";
        createConnection();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                String name = rs.getString("Name");
                String articleNumber = rs.getString("ArticleNumber");
                String dfp = Integer.toString(0); // is 0 because dfp is only ordered manually
                String kfp = Integer.toString(rs.getInt("MinStockBalance") - rs.getInt("StockBalance")/rs.getInt("KfpSize"));
               // makes sure that the balance gets even

                OrderProductBean orderProductBean = new OrderProductBean(name,articleNumber,dfp,kfp);
                tempArray.add(orderProductBean);
            }
            rs.close();
        }catch (Exception e){

        }
    }





    private int getOrderId (){
        String sql = "SELECT OrderId FROM `orders` WHERE `OrderId` =(SELECT MAX(OrderId)FROM orders)";
        createConnection();
        int orderId = 0;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                orderId = rs.getInt("OrderId");
            }
            rs.close();
        }catch (Exception e){
            System.out.print("cant connect to database");
        }
        return orderId;

    }

    private void  createConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aob?",
                    "root", "");

        }catch (Exception e){
            System.out.print("SQLExepection" + e.getMessage());
        }






}

}

