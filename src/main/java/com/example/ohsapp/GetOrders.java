package com.example.ohsapp;

import com.example.ohsapp.beans.OrderProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public  class GetOrders {
    @Autowired
    private JdbcTemplate jdbcTemplate;
   // @Autowired
    //private OrderProductRepository repository;

    public  ArrayList<OrderProductBean> getOrder(){
        ArrayList <OrderProductBean> orderProductBeans = null;
     System.out.print(getProductFromDatabase(orderProductBeans).size());
    // System.out.print(repository.findAllByArticleNumEquals("123").size());

       return orderProductBeans;




    }

   private  ArrayList<OrderProductBean> getProductFromDatabase(ArrayList orderProducts){

        String sqlQuerry = "SELECT * FROM `orderproducts` WHERE 1 ";
       jdbcTemplate.query(
               sqlQuerry, new Object[]{},
               (rs, rowNum) -> new OrderProductBean(rs.getString("ArticleNumber"),
                       rs.getString("ArticleNumber"),rs.getString("DfpQuantity"),
                       rs.getString("KfpQuantity "))
       ).forEach(product ->
               orderProducts.add(product)
       );
       return orderProducts;
   }





}

