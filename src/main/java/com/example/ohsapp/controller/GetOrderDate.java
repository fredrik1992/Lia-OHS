package com.example.ohsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetOrderDate {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void getDate(){
        String sql = "SELECT Date FROM `orders` WHERE `OrderId` =(SELECT MAX(OrderId)FROM orders)";
        String result  =jdbcTemplate.queryForObject(sql,String.class);
        System.out.print("before result");
        System.out.print(result);
    }
}
