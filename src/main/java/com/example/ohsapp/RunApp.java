package com.example.ohsapp;

import java.util.Timer;

public class RunApp implements Runnable{
   public  void runThread (){
       (new Thread(new RunApp())).start();
   }
    @Override
    public void run() {
        boolean isRunning = true;

        new Timer().schedule(new sendOrderTask(), 0, 1000);

        while (isRunning){
            try {
                Thread.sleep(1000);  // add 1800000 for every 30 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
