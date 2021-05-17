package com.example.ohsapp.controller;


import com.example.ohsapp.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@ControllerAdvice
public class LoginController {
    UserBean userBean;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/getLoginController",method = RequestMethod.POST)
    public RedirectView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userBean = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        boolean validation = validateUser(username,password);


        if(validation){
            System.out.print("validated");
            HttpSession session = request.getSession();
            session.setAttribute("user",userBean);
            RequestDispatcher rd = request.getRequestDispatcher("searchWindow.jsp");
            rd.forward(request, response);
        }
            System.out.print("not validated");
            return new RedirectView("http://localhost:8080/");

            //return to html


    }

    public boolean validateUser(String username,String password){
            System.out.print("in validate user");
        String sql = "SELECT * FROM users WHERE Username = ? AND Password = ? ";
        try{

            jdbcTemplate.query(
                    sql,new Object[]{username,password},
                    ((rs, rowNum) ->

                            userBean = new UserBean(rs.getString("Name"),
                                    rs.getString("EmploymentNumber"),
                                    rs.getString("IsAdmin")
                            ) )

            );
            userBean.initiateCheckAdmin(); // to give admin value from int
            return true;
        }catch (Exception e){

        }


        return false;
    }
}
