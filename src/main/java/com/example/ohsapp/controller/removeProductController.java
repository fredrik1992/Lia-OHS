package com.example.ohsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class removeProductController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/alterProductController")
    public RedirectView alterHandler (@RequestParam(name = "ean") String ean,
                           @RequestParam(name = "articlenumber") String articleNumber,
                           @RequestParam(name = "trademark") String trademark,
                           @RequestParam(name = "inprice") String inPrice,
                           @RequestParam(name = "outprice") String outPrice,
                           @RequestParam(name = "minstockbalance") String minStockBalance,
                           @RequestParam(name = "maxstockbalance") String maxStockBalance,
                           @RequestParam(name = "stockbalance") String stockBalance,
                           @RequestParam(name = "category") String category,
                                      @RequestParam(name = "hiddenEan") String hiddenEan) {
        ArrayList<String> validatedInput;
       validatedInput = validateInput(ean,articleNumber,trademark,inPrice,outPrice, minStockBalance,maxStockBalance,stockBalance,category);

       updateToDB(hiddenEan, validatedInput);
        System.out.println(validatedInput);

        RedirectView rv = new RedirectView();
        rv.setUrl("searchWindow.jsp");
        return rv;
    }

    private void updateToDB(String hiddenEan, ArrayList<String> validatedInput) {
        for (int i=0; i<validatedInput.size();i+=2){

            String sqlQuery = "UPDATE `products` SET " +validatedInput.get(i) + "=" + validatedInput.get(i+1) + " WHERE EANNumber ="+hiddenEan;
            jdbcTemplate.update(sqlQuery);
        }

    }

    public ArrayList<String> validateInput(String ean,
                               String articleNumber,
                               String trademark,
                               String inPrice,
                               String outPrice,
                               String minStockBalance,
                               String maxStockBalance,
                               String stockBalance,
                               String category) {
        ArrayList<String> l = new ArrayList<>();
            if (ean.length()>1){

                l.add("EANNumber");
                l.add(ean);
        }
         if (articleNumber.length()>1){
            l.add("ArtcleNumber");
            l.add(articleNumber);
        }
         if (trademark.length()>1){
            l.add("Trademark");
            trademark = "`" + trademark+"`";
            l.add(trademark);
        }
        if (inPrice.length()>1){
            l.add("InPrice");
            l.add(inPrice);
        }
        if (outPrice.length()>1){
            l.add("OutPrice");
            l.add(outPrice);
        }
        if (minStockBalance.length()>1){
            l.add("MinStockBalance");
            l.add(minStockBalance);
        }
         if (maxStockBalance.length()>1){
            l.add("MaxStockBalance");
            l.add(maxStockBalance);
        }
         if (stockBalance.length()>1){
            l.add("StockBalance");
            l.add(stockBalance);
        }
        if (category.length()>1){
            l.add("`Category`");
            l.add("\""+category+"\"");
        }
        return l;
    }


    @GetMapping(value = "/removeProductController")
    public RedirectView removeHandler(@RequestParam(name = "hiddenEan") String hiddenEan){
        deleteInDB(hiddenEan);
        RedirectView rv = new RedirectView();
        rv.setUrl("searchWindow.jsp");
        return rv;
    }

    private void deleteInDB(String hiddenEan) {
        String sqlQuery = "DELETE FROM `products` WHERE `EANNumber` ="+hiddenEan;
        jdbcTemplate.update(sqlQuery);
    }

}
