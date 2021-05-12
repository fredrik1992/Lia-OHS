package com.example.ohsapp.controller;


import com.example.ohsapp.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ControllerAdvice
public class LoginController {

    @RequestMapping(value = "/getLoginController",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean userBean = new UserBean(username,password);
        if(validateUser(userBean)){

        }

    }

    public boolean validateUser(UserBean userBean){
        String sql = "SELECT * FROM `users` WHERE Username = \"?\" AND Password = \"?\" ";

        return false;
    }
}
