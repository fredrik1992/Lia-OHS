package com.example.ohsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class sendEmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(path = "/sendEmail", method = RequestMethod.GET)
    public void sendMailHandler(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("Sending Email...");
        try {

            //sendEmailWithoutAttachment();
            sendEmailWithAttachment();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }



    void sendEmailWithoutAttachment() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("javaganget@gmail.com");

        msg.setSubject("Testing sending an email");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }


    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("javaganget@gmail.com");

        helper.setSubject("Here is our order. File it attached in the mail");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("sample.csv", new ClassPathResource("sample.csv"));

        javaMailSender.send(msg);

    }
}