package com.example.ohsapp.beans;

public class ProduktBean {



    private String articleNumber;
    private String eanNumber;
    private String tradeMark;
    private double inPrice;
    private double outPrice;
    private int stockBalance;
    private int maxStockBalance;
    private  int minStockBalance;
    private int kfpSize;
    private int dfpSize;
    private String department;
    private String category;



    private String attribute;
    private int activeProduct;
    private String name;
    private int supplierId;

    public ProduktBean(){

    }
    public ProduktBean(String articleNumber, String eanNumber, String tradeMark,
                       double inPrice, double outPrice, int stockBalance,
                       int maxStockBalance, int minStockBalance, int kfpSize,
                       int dfpSize, String department, String category, int activeProduct, String name,
                       int supplierId) {
        this.articleNumber = articleNumber;
        this.eanNumber = eanNumber;
        this.tradeMark = tradeMark;
        this.inPrice = inPrice;
        this.outPrice = outPrice;
        this.stockBalance = stockBalance;
        this.maxStockBalance = maxStockBalance;
        this.minStockBalance = minStockBalance;
        this.kfpSize = kfpSize;
        this.dfpSize = dfpSize;
        this.department = department;
        this.category = category;
        this.activeProduct = activeProduct;
        this.name = name;
        this.supplierId = supplierId;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
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

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    public int getMaxStockBalance() {
        return maxStockBalance;
    }

    public void setMaxStockBalance(int maxStockBalance) {
        this.maxStockBalance = maxStockBalance;
    }

    public int getMinStockBalance() {
        return minStockBalance;
    }

    public void setMinStockBalance(int minStockBalance) {
        this.minStockBalance = minStockBalance;
    }

    public int getKfpSize() {
        return kfpSize;
    }

    public void setKfpSize(int kfpSize) {
        this.kfpSize = kfpSize;
    }

    public int getDfpSize() {
        return dfpSize;
    }

    public void setDfpSize(int dfpSize) {
        this.dfpSize = dfpSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getActiveProduct() {
        return activeProduct;
    }

    public void setActiveProduct(int activeProduct) {
        this.activeProduct = activeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public String getAttribute() {
        return attribute;
    }

}