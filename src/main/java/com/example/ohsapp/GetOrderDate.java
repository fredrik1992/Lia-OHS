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
        conn = SqlConnect.getConnection();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
               date = rs.getDate("Date");
            }
            conn.close();


        }catch (Exception e){
            System.out.print("wrong in statment date");
        }

        return date;
    }




}
