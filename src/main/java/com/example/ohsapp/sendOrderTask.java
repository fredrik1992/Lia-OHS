package com.example.ohsapp;

import com.example.ohsapp.controller.GetOrderDate;

import java.time.LocalDate;
import java.util.TimerTask;

public class sendOrderTask extends TimerTask {
    LocalDate lastOrderDate;
    LocalDate currentDate = LocalDate.now();
    @Override
    public void run() {
        if(lastOrderDate == null){
            lastOrderDate = LocalDate.now();
            System.out.print(lastOrderDate);
        }
        GetOrderDate getOrderDate = new GetOrderDate();
        getOrderDate.getDate();
        //make a check against orders and see if the last on is the same as current date ? incase program crashes or somthing

        //get the last order createds date and after that send the order then at the last place create a new deate for the 2 following weeks
        if(currentDate.isAfter(lastOrderDate)	|| currentDate.equals(lastOrderDate) ){

            System.out.print("order needs to be sent");
            GetOrders getOrders = new GetOrders();
            getOrders.getOrder();
            lastOrderDate = lastOrderDate.plusDays(2);
        }





    }
}
