package com.example.ohsapp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimerTask;

public class sendOrderTask extends TimerTask {

    LocalDate currentDate = LocalDate.now();
    @Override
    public void run() {
       Date lastOrderDate;
       LocalDate convertedLastOrderDate = null;
       GetOrderDate getOrderDate = new GetOrderDate();
       lastOrderDate = getOrderDate.getDate();
       LocalDate test = LocalDate.now();

        sendCSV sendcsv = new sendCSV();
        sendcsv.orderToCSVFile();
            if(currentDate.isAfter(test)	|| currentDate.equals(test) ){

                if (sendcsv.orderToCSVFile()) {
                    System.out.print("order needs to be sent");
                    // GetOrders getOrders = new GetOrders();
                    //getOrders.sendOrder();
                }
            }



       System.out.print(lastOrderDate);
        //GetOrderDate getOrderDate = new GetOrderDate();
        //getOrderDate.getDate();
        //make a check against orders and see if the last on is the same as current date ? incase program crashes or somthing

        //get the last order createds date and after that send the order then at the last place create a new deate for the 2 following weeks






    }
}
