package com.example.ohsapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addOrderFromBasketController {

    @RequestMapping("/testa")
    public String test (){
        return "test";
    }
}
