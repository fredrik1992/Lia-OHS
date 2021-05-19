package com.example.ohsapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnect {
    
    public static Connection getConnection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aob?",
                    "root", "lady2005");

        }catch (Exception e){
            System.out.print("SQLExepection" + e.getMessage());
        }
        return connection;
    }
}
