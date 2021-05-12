package com.example.ohsapp.beans;

import java.util.ArrayList;
import java.util.List;

public class ProduktListBean {
    List <ProduktBean> allOrders;

    public ProduktListBean() {
        allOrders = new ArrayList<>();
    }

    public List<ProduktBean> getAllOrders() {
        return allOrders;
    }

    public void addProduct(ProduktBean orderProduktBean) {

        allOrders.add(orderProduktBean);
    }
    public void nullList(){
        allOrders = new ArrayList<>();
    }
}
