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


        if (checkIfRowExistsInDatabase("EmploymentNumber", "users", employmentNumber) || checkIfRowExistsInDatabase("Username", "users", username)) {
            request.setAttribute("userProcess", "0");
        } else {
            try {
                if (addUserInDatabase(employmentNumber, name, mail, phoneNumber, username, password, isAdmin) > 0) {
                    request.setAttribute("userProcess", "1");
                    System.out.println("A new row has been inserted.");
                } else {
                    request.setAttribute("userProcess", "2");      // Something went wrong
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        redirect(request, response, "adminWindow.jsp");
    }


    @RequestMapping(path = "/adminDeleteUser", method = RequestMethod.POST)
    public void deleteUserHandler(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(name = "employmentnumber") String employmentNumber) throws ServletException, IOException {


        if (!checkIfRowExistsInDatabase("EmploymentNumber", "users", employmentNumber)) {
            request.setAttribute("userProcess", "3");
        } else {
            try {
                String sqlDeleteUser = "DELETE FROM `users` WHERE EmploymentNumber =?";
                int result = jdbcTemplate.update(sqlDeleteUser, employmentNumber);

                if (result > 0) {
                    request.setAttribute("userProcess", "4");
                    System.out.println("A row has been deleted.");
                } else {
                    request.setAttribute("userProcess", "2");      // Something went wrong
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        redirect(request, response, "adminWindow.jsp");
    }


    private int addUserInDatabase(String employmentNumber, String name, String mail, String phoneNumber, String username, String password, String isAdmin) {
        UserBean userBean = new UserBean(employmentNumber, name, mail, phoneNumber, username, password, isAdmin);
        String sqlAddUser = "INSERT INTO `users` (EmploymentNumber, Username, Password, Name, Mail, PhoneNumber, IsAdmin) Values(?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sqlAddUser, employmentNumber, username, password, name, mail, phoneNumber, isAdmin);
        return result;
    }


    private boolean checkIfRowExistsInDatabase(String column, String table, String value) {
        String sqlCheckIfEmploymentNumberExists = "SELECT " + column + " FROM `" + table + "` WHERE " + column + " = '" + value + "'";
        Map checkIfEmploymentNumberExists = (DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfEmploymentNumberExists)));
        if (checkIfEmploymentNumberExists == null) {
            return false;
        }
        return true;
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}