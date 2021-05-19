package com.example.ohsapp.beans;

public class OrderProductBean {

  private   String name;
  private   String articleNum;
  private String dfp;
  private String kfp;

    public OrderProductBean(String name, String articleNum, String dfp, String kfp) {
        this.name = name;
        this.articleNum = articleNum;
        this.dfp = dfp;
        this.kfp = kfp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(String articleNum) {
        this.articleNum = articleNum;
    }

    public String getDfp() {
        return dfp;
    }

    public void setDfp(String dfp) {
        this.dfp = dfp;
    }

    public String getKfp() {
        return kfp;
    }

    public void setKfp(String kfp) {
        this.kfp = kfp;
    }


}
