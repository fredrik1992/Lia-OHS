package com.example.ohsapp.beans;

public class ProduktBean {

    private String articleNumber;
    private String name;
    private String eanNumber;
    private String tradeMark;
    private int inPrice;
    private int outPrice;



    public ProduktBean(){

    }
    public ProduktBean(String articleNumber, String name,
                       String eanNumber, String tradeMark,
                       int inPrice, int outPrice) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.eanNumber = eanNumber;
        this.tradeMark = tradeMark;
        this.inPrice = inPrice;
        this.outPrice = outPrice;
    }


    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEanNumber() {
        return eanNumber;
    }

    public void setEanNumber(String eanNumber) {
        this.eanNumber = eanNumber;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public int getInPrice() {
        return inPrice;
    }

    public void setInPrice(int inPrice) {
        this.inPrice = inPrice;
    }

    public int getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(int outPrice) {
        this.outPrice = outPrice;
    }










}
