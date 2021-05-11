package com.example.ohsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping(path = "/addProductController")
public class addProductController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public RedirectView addProductHandler(@RequestParam(name = "ean") String ean,
                                          @RequestParam(name = "articlenumber") String articleMumber,
                                          @RequestParam(name = "trademark") String trademark,
                                          @RequestParam(name = "name") String name,
                                          @RequestParam(name = "inprice") String inPrice,
                                          @RequestParam(name = "outprice") String outPrice,
                                          @RequestParam(name = "kfpsize") String kfpSize,
                                          @RequestParam(name = "dfpsize") String dfpSize,
                                          @RequestParam(name = "minstockbalance") String minStockBalance,
                                          @RequestParam(name = "maxstockbalance") String maxStockBalance,
                                          @RequestParam(name = "stockbalance") String stockBalance,
                                          @RequestParam(name = "department") String department,
                                          @RequestParam(name = "category") String category,
                                          @RequestParam(required = false, name = "18plus") String eighteenPlus,
                                          @RequestParam(required = false, name = "pant1kr") String pant1Kr,
                                          @RequestParam(required = false, name = "pant2kr") String pant2Kr,
                                          @RequestParam(required = false, name = "larmad") String alarmed,
                                          @RequestParam(required = false, name = "activeproduct") String activeProduct) {

        RedirectView rv = new RedirectView();
        rv.setUrl("addProductsWindow.jsp");


        String sql = "INSERT INTO `products` (ArticleNumber, EANNumber, TradeMark, InPrice, OutPrice, StockBalance, MaxStockBalance, MinStockBalance, " +
                "KfpSize, DfpSize, Department, Category, ActiveProduct, Name, SupplierID) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String attributeSql = "INSERT INTO `attributeproducts` (ArticleNumber, AttributeId) VALUES (?,?)";

        String sqlCheckIfPEanExists = "SELECT EANNUMBER FROM `products` WHERE EANNUMBER = '" + ean + "'";
        Map checkIfEanExists=(DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfPEanExists)));

        String sqlCheckIfPArticleNumberExists = "SELECT ArticleNumber FROM `products` WHERE ArticleNumber = '" + articleMumber + "'";
        Map checkIfArticleNumberExists=(DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfPArticleNumberExists)));

        if (checkIfEanExists != null || checkIfArticleNumberExists != null) {
            System.out.println("Det finns en produkt med det ean eller artikelnummer");
            return rv;  // A product already exists with that ean or articlenumber
        } else {
            try {
                System.out.println(activeProduct);
                if (activeProduct.equals("off") || activeProduct.length() < 0) {
                    activeProduct = "0";
                } else {
                    activeProduct = "1";
                }
                int result = jdbcTemplate.update(sql, articleMumber, ean, trademark, inPrice, outPrice, stockBalance, maxStockBalance, minStockBalance,
                        kfpSize, dfpSize, department, category, activeProduct, name, "1");

                if (result > 0) {

                    // Only inserts attribute if the product were successfully inserted.
                    if (eighteenPlus != null) {
                        jdbcTemplate.update(attributeSql, articleMumber, "1");
                        System.out.println("18 är inte empty");
                    }
                    if (pant1Kr != null) {
                        jdbcTemplate.update(attributeSql, articleMumber, "2");
                        System.out.println("1 är inte empty");
                    }
                    if (pant2Kr != null) {
                        jdbcTemplate.update(attributeSql, articleMumber, "3");
                        System.out.println("2 är inte empty");
                    }
                    if (alarmed != null) {
                        jdbcTemplate.update(attributeSql, articleMumber, "4");
                        System.out.println("alarm är inte empty");
                    }

                    System.out.println("A new row has been inserted.");

                } else {
                    return rv;      // Something went wrong
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rv;  // Product added
    }
}