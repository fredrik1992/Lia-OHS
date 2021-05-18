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





    public  ArrayList<OrderProductBean> getOrder(){
        ArrayList<OrderProductBean> tempArray = new ArrayList<OrderProductBean>();
        String sql = "SELECT products.Name,orderproducts.ArticleNumber,orderproducts.DfpQuantity,orderproducts.KfpQuantity FROM `orderproducts` INNER JOIN products ON orderproducts.ArticleNumber = products.ArticleNumber";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aob?",
                    "root", "");

        }catch (Exception e){
            System.out.print("SQLExepection" + e.getMessage());
        }
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()){
                String name = rs.getString("Name");
                String articleNumber = rs.getString("ArticleNumber");
                String dfp = Integer.toString(rs.getInt("DfpQuantity")) ;
                String kfp = Integer.toString(rs.getInt("KfpQuantity")) ;

                OrderProductBean orderProductBean = new OrderProductBean(name,articleNumber,dfp,kfp);


                tempArray.add(orderProductBean);
            }
        }catch (Exception e){
            System.out.print("wrong in statment");
        }





    return tempArray;

    }






}

