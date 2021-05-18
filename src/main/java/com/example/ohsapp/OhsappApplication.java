package com.example.ohsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;

@SpringBootApplication
public class OhsappApplication{

    public static void main(String[] args) {
        RunApp runApp = new RunApp();
        runApp.runThread();
        System.out.print("in main");
        SpringApplication.run(OhsappApplication.class, args);

    }





}
