package com.example.ohsapp;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class OhsappApplication implements Runnable{

    public static void main(String[] args) {

        (new Thread(new OhsappApplication())).start();
        System.out.print("in main");
        SpringApplication.run(OhsappApplication.class, args);

    }
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
