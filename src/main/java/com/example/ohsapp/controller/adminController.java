package com.example.ohsapp.controller;

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
public class adminController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/adminAddUser", method = RequestMethod.POST)
    public void addUserHandler(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(name = "employmentnumber") String employmentNumber,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "mail") String mail,
                               @RequestParam(name = "phonenumber") String phoneNumber,
                               @RequestParam(name = "username") String username,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "isadmin") String isAdmin) throws ServletException, IOException {

        HttpSession session = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("adminWindow.jsp");
        request.setAttribute("addUserProcess", "1");
        String sql = "INSERT INTO `users` (EmploymentNumber, Username, Password, Name, Mail, PhoneNumber, IsAdmin) Values(?, ?, ?, ?, ?, ?, ?)";

        String sqlCheckIfEmploymentNumberExists = "SELECT EmploymentNumber FROM `users` WHERE EmploymentNumber = '" + employmentNumber + "'";
        Map checkIfEmploymentNumberExists = (DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfEmploymentNumberExists)));

        String sqlCheckIfUsernameExists = "SELECT Username FROM `users` WHERE Username = '" + username + "'";
        Map checkIfUsernameExists = (DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfUsernameExists)));

        if (checkIfEmploymentNumberExists != null || checkIfUsernameExists != null) {
            request.setAttribute("addUserProcess", "0");
        } else {
            try {
                System.out.println(employmentNumber);
                int result = jdbcTemplate.update(sql, employmentNumber, username, password, name, mail, phoneNumber, isAdmin);

                if (result > 0) {
                    System.out.println("A new row has been inserted.");
                } else {
                    request.setAttribute("addUserProcess", "2");      // Something went wrong
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        rd.forward(request, response);
    }






    ///////////////////////////// WORKING ON THIS BELOW /////////////////////////////





    @RequestMapping(path = "/adminAddUser", method = RequestMethod.POST)
    public void deleteUserHandler(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(required = false, name = "employmentnumber") String employmentNumber,
                                  @RequestParam(required = false, name = "name") String name,
                                  @RequestParam(required = false, name = "mail") String mail,
                                  @RequestParam(required = false, name = "phonenumber") String phoneNumber) throws ServletException, IOException {

        HttpSession session = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("adminWindow.jsp");
        request.setAttribute("addUserProcess", "1");
        String sql = "INSERT INTO `users` (EmploymentNumber, Username, Password, Name, Mail, PhoneNumber, IsAdmin) Values(?, ?, ?, ?, ?, ?, ?)";

        String sqlCheckIfEmploymentNumberExists = "SELECT EmploymentNumber FROM `users` WHERE EmploymentNumber = '" + employmentNumber + "'";
        Map checkIfEmploymentNumberExists = (DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfEmploymentNumberExists)));

        String sqlCheckIfUsernameExists = "SELECT Username FROM `users` WHERE Username = '" + username + "'";
        Map checkIfUsernameExists = (DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfUsernameExists)));

        if (checkIfEmploymentNumberExists != null || checkIfUsernameExists != null) {
            request.setAttribute("addUserProcess", "0");
        } else {
            try {
                System.out.println(employmentNumber);
                int result = jdbcTemplate.update(sql, employmentNumber, username, password, name, mail, phoneNumber, isAdmin);

                if (result > 0) {
                    System.out.println("A new row has been inserted.");
                } else {
                    request.setAttribute("addUserProcess", "2");      // Something went wrong
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        rd.forward(request, response);
    }
}