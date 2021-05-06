package com.example.ohsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TestConnectionApp implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TestConnectionApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO suppliers (Name, Mail, PhoneNumber) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(sql, "ICA", "ica@mail.com", "1234567890");

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }

    }

}