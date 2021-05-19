package com.example.ohsapp.controller;

import com.example.ohsapp.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class logoutController {


    @RequestMapping(path = "/Logout", method = RequestMethod.POST)
    public void addUserHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Check if there is an user in session.
        if (request.getSession().getAttribute("user") != null) {

            // Get the session
            HttpSession session = request.getSession();

            // get the user data
            UserBean userBean = (UserBean) session.getAttribute("user");
            // remove the user
            session.removeAttribute("User");
            // turn off the session
            session.invalidate();
            // goto index
            response.sendRedirect("index.html");

        }else {
            // this should only happen if you try to goto "/Logout" manually
            response.sendRedirect("index.html");
        }

    }
}