package com.example.ohsapp;

import com.example.ohsapp.beans.OrderProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class GetOrderDate {
    private Connection conn;
    private PreparedStatement stmt = null;
    private ResultSet rs;



    public Date getDate(){

        Date date = null;
        String sql = "SELECT Date FROM `orders` WHERE `OrderId` =(SELECT MAX(OrderId)FROM orders)";

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
               date = rs.getDate("Date");
            }


        }catch (Exception e){
            System.out.print("wrong in statment date");
        }
        return date;
    }
}
