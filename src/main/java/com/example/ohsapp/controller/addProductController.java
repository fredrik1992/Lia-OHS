package com.example.ohsapp.controller;

import com.example.ohsapp.beans.ProduktBean;
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
public class addProductController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/addProductController", method = RequestMethod.POST)
    public void addProductHandler(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(name = "ean") String ean,
                                  @RequestParam(name = "articlenumber") String articleNumber,
                                  @RequestParam(name = "trademark") String trademark,
                                  @RequestParam(name = "name") String name,
                                  @RequestParam(name = "inprice") String inPrice,
                                  @RequestParam(name = "outprice") String outPrice,
                                  @RequestParam(name = "kfpsize") String kfpSize,
                                  @RequestParam(name = "dfpsize") String dfpSize,
                                  @RequestParam(name = "minstockbalance") String minStockBalance,
                                  @RequestParam(name = "maxstockbalance") String maxStockBalance,
                                  @RequestParam(name = "stockbalance") String stockBalance,
                                  @RequestParam(name = "department") String department,
                                  @RequestParam(name = "category") String category,
                                  @RequestParam(required = false, name = "18plus") String eighteenPlus,
                                  @RequestParam(required = false, name = "pant1kr") String pant1Kr,
                                  @RequestParam(required = false, name = "pant2kr") String pant2Kr,
                                  @RequestParam(required = false, name = "larmad") String alarmed,
                                  @RequestParam(required = false, name = "activeproduct") String activeProduct) throws ServletException, IOException {


        request.setAttribute("addProductProcess", "1");

        if (checkIfProductExists("ArticleNumber", articleNumber) || checkIfProductExists("EANNumber", ean)) {
            request.setAttribute("addProductProcess", "0");
        } else {
            try {
                if (addProductInDatabase(ean, articleNumber, trademark, name, inPrice, outPrice, kfpSize, dfpSize, minStockBalance,
                        maxStockBalance, stockBalance, department, category, activeProduct) > 0) {

                    // Only inserts attribute if the product were successfully inserted.
                    addAttributeToProduct(articleNumber, eighteenPlus, pant1Kr, pant2Kr, alarmed);
                    System.out.println("A new row has been inserted.");

                } else {
                    request.setAttribute("addProductProcess", "2");      // Something went wrong
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        redirect(request, response, "addProductsWindow.jsp");
    }


    private boolean checkIfProductExists(String column, String value) {
        String sqlCheckIfArticleNumberExists = "SELECT " + column + " FROM `products` WHERE " + column + " = '" + value + "'";
        Map checkIfArticleNumberExists = DataAccessUtils.singleResult(jdbcTemplate.queryForList(sqlCheckIfArticleNumberExists));
        if (checkIfArticleNumberExists == null) {
            return false;
        }
        return true;
    }


    private int addProductInDatabase(String ean, String articleNumber, String trademark, String name, String inPrice, String outPrice, String kfpSize,
                                     String dfpSize, String minStockBalance, String maxStockBalance, String stockBalance, String department, String category, String activeProduct) {

        ProduktBean produktBean = new ProduktBean(ean, articleNumber, trademark, Double.parseDouble(inPrice), Double.parseDouble(outPrice),
                Integer.parseInt(stockBalance), Integer.parseInt(maxStockBalance), Integer.parseInt(minStockBalance), Integer.parseInt(kfpSize),
                Integer.parseInt(dfpSize), department, category, Integer.parseInt(activeProduct), name, 1);

        String sql = "INSERT INTO `products` (ArticleNumber, EANNumber, TradeMark, InPrice, OutPrice, StockBalance, MaxStockBalance, MinStockBalance, " +
                "KfpSize, DfpSize, Department, Category, ActiveProduct, Name, SupplierID) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, produktBean.getArticleNumber(), produktBean.getEanNumber(), produktBean.getTradeMark(), produktBean.getInPrice(),
                produktBean.getOutPrice(), produktBean.getStockBalance(), produktBean.getMaxStockBalance(), produktBean.getMinStockBalance(),
                produktBean.getKfpSize(), produktBean.getDfpSize(), produktBean.getDepartment(), produktBean.getCategory(), produktBean.getActiveProduct(), name, "1");
    }


    private void addAttributeToProduct(String articleNumber, String eighteenPlus, String pant1Kr, String pant2Kr, String alarmed) {
        String attributeSql = "INSERT INTO `attributeproducts` (ArticleNumber, AttributeId) VALUES (?,?)";
        
        if (eighteenPlus != null) {
            jdbcTemplate.update(attributeSql, articleNumber, "1");
        }
        if (pant1Kr != null) {
            jdbcTemplate.update(attributeSql, articleNumber, "2");
        }
        if (pant2Kr != null) {
            jdbcTemplate.update(attributeSql, articleNumber, "3");
        }
        if (alarmed != null) {
            jdbcTemplate.update(attributeSql, articleNumber, "4");
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}