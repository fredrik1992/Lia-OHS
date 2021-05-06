package com.example.ohsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/addProductController")
public class addProductController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String test(@RequestParam(name = "ean") String ean,
                       @RequestParam(name = "articlenumber") String articleMumber,
                       @RequestParam(name = "trademark") String trademark,
                       @RequestParam(name = "inprice") String inPrice,
                       @RequestParam(name = "outprice") String outPrice,
                       @RequestParam(name = "kfpsize") String kfpSize,
                       @RequestParam(name = "dfpsize") String dfpSize,
                       @RequestParam(name = "minstockbalance") String minStockBalance,
                       @RequestParam(name = "maxstockbalance") String maxStockBalance,
                       @RequestParam(name = "stockbalance") String stockBalance,
                       @RequestParam(name = "category") String category,
                       @RequestParam(name = "18plus") String eighteenPlus,
                       @RequestParam(name = "pant1kr") String pant1Kr,
                       @RequestParam(name = "pant2kr") String pant2Kr,
                       @RequestParam(name = "larmad") String alarmed,
                       @RequestParam(name = "activeproduct") String activeproduct) {


        String sql = "INSERT INTO suppliers (Name, Mail, PhoneNumber) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(sql, "ICA", "ica@mail.com", "1234567890");

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }

        String sqlQuery = "INSERT INTO `products` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        return ean;
    }
}