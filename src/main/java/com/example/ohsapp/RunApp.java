package com.example.ohsapp;

import java.util.Timer;

public class RunApp implements Runnable{

    @Override
    public void run() {
        boolean isRunning = true;
        System.out.print("thread called");



        while (isRunning){
            try {
                SendOrderTask sendOrderTask = new SendOrderTask();
                sendOrderTask.run();
                Thread.sleep(1000);  // add 1800000 for every 30 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
