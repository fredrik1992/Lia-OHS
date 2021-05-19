package com.example.ohsapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class SendOrderTask extends TimerTask {
    private Connection conn;
    private PreparedStatement stmt = null;
    private ResultSet rs;
    Date lastOrderDate;


    @Override
    public void run() {
        LocalDate currentDate = LocalDate.now();


       GetOrderDate getOrderDate = new GetOrderDate();
       lastOrderDate = getOrderDate.getDate();

       LocalDate lastOrderLocalDate = ((java.sql.Date) lastOrderDate).toLocalDate();

            if(currentDate.isAfter(lastOrderLocalDate)	|| currentDate.equals(lastOrderLocalDate) ){

                System.out.print("time to make an order");
                sendCSV sendCSV = new sendCSV();
                if(sendCSV.orderToCSVFile()){
                    createNewOrderId();
                }

            }




        //GetOrderDate getOrderDate = new GetOrderDate();
        //getOrderDate.getDate();
        //make a check against orders and see if the last on is the same as current date ? incase program crashes or somthing

        //get the last order createds date and after that send the order then at the last place create a new deate for the 2 following weeks






    }
    public void createNewOrderId(){
        String sql = "INSERT INTO `orders` (`OrderId`, `OrdererName`, `OrdererMail`, `OrdererPhoneNumber`, `Date`) VALUES (NULL, 'ica', 'ica@.se', '07045', ?)";
        conn = SqlConnect.getConnection();
        String lastOrderDateToString = lastOrderDate.toString();
        lastOrderDateToString = addDays(lastOrderDateToString); // adds 2 days


        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,lastOrderDateToString);
            stmt.executeUpdate();

            stmt.close();

        }catch (Exception e){
            System.out.print("creating new order id failed");
        }

    }

    public String addDays(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try{
            //Setting the date to the given date
            c.setTime(sdf.parse(date));
        }catch(ParseException e){
            e.printStackTrace();
        }

        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, 2);
        //Date after adding the days to the given date
        String newDate = sdf.format(c.getTime());
        //Displaying the new Date after addition of Days

        return newDate;
    }
}
