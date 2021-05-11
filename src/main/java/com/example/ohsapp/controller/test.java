package com.example.ohsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class test {



    @RequestMapping(value="/someURL", method= RequestMethod.GET)
    public String yourMethod(HttpServletRequest request)
    {
        request.setAttribute("fa", "test");
        return "redirect:/addProductsWindow.jsp";
    }
}