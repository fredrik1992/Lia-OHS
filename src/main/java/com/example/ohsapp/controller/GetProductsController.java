package com.example.ohsapp.controller;

import com.example.ohsapp.beans.ProduktListBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class GetProductsController {
    private String inputDataToUse;


    @RequestMapping(path = "/getProductsController")
    public String multibleInputHandler(@RequestParam(name = "ean") String ean,
                          @RequestParam(name = "article") String article,
                          @RequestParam(name = "productName") String productName){

        String searchQueryTarget = findRelevantInput(ean,article,productName);

        if(searchQueryTarget != null){
            ProduktListBean produktListBean = new ProduktListBean();
            addProducts(produktListBean,inputDataToUse,searchQueryTarget);
            //send it back to site
            return "orderWindow";
        }
        return "no input";
        //go back to site


    }
    @RequestMapping(path = "/getProductFromEan")
    public String singleEanHandler(@RequestParam(name = "hiddenEan") String hiddenEan){
        // takes care of finding a matching ean number in database and returns it
        //using existing methods
        ProduktListBean produktListBean = new ProduktListBean();
        if(hiddenEan.isEmpty()){
            return "empty";
        }else {
            //needs to return the list of products to the page
            addProducts(produktListBean,hiddenEan,"EAN-Number");
            return "not empty";
        }
    }

    private String findRelevantInput (String ean,String article, String productName){
        //checks wich of the three inputs to use and the target column in database
        if(ean.length() !=0){//checks wich input has been filled
            inputDataToUse =ean;
            return "EAN-Number"; // this is the column name we will be using

        }else if (article.length() !=0){
            inputDataToUse =article;
            return "ArticleNumber";


        }else if (article.length() !=0){
            inputDataToUse =productName;
            return "Name";


        }else{
            return null;
        }
    }
    private void addProducts(ProduktListBean produktListBean,
                             String inputData,String searchTarget){



    }

}
