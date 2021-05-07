package com.example.ohsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class getProductsController {

    @GetMapping
    public String test(@RequestParam(name = "ean") String ean,
                       @RequestParam(name = "artikelNr") String artickelNr,
                       @RequestParam(name="namn") String namn){

        if (ean!=null && artickelNr.isEmpty() && namn.isEmpty()){
            return ean;
        }
        else if (artickelNr!=null && ean.isEmpty() && namn.isEmpty()){
            return artickelNr;
        }
        else if (namn!=null && ean.isEmpty() && artickelNr.isEmpty()){
            return namn;
        }

        else{return null;}

    }
}

