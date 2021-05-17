<%@ page import="com.example.ohsapp.beans.ProduktListBean" %>
<%@ page import="com.example.ohsapp.beans.ProduktBean" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="Css/orderWindow.css ">
    <link rel="stylesheet" href="Css/myCSS.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>

</head>
<body>

<jsp:include page="dashBoard.jsp"></jsp:include>

<main class="container">

        <%
            // New location to be redirected
            if(session.getAttribute("user") ==null){
                String site = new String("index.html");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            }

        %>
    <div class="headContainer" >
        <p>sök på artikel</p>
        <form action="<%=request.getContextPath()%>/getProductsController" class = "searchProductContainer">
            <div class="form-group inputField">

                <input type="text" class="form-control" id="eanSearch" name="ean" aria-describedby="emailHelp" placeholder="Ean">

            </div>
            <div class="form-group inputField">

                <input type="text" class="form-control" name="article" id="articleSearch" aria-describedby="emailHelp" placeholder="AtrikelNummer">

            </div>
            <div class="form-group inputField">

                <input type="text" class="form-control" name="productName" id="productSearch" aria-describedby="emailHelp" placeholder="ProduktNamn">

            </div>
            <div class="col">
                <div class="float-end">

                    <button type="submit" class="btn btn-outline-primary  submitButton">sök</button>
                </div>
            </div>




        </form>
    </div>



        <div id="productsContainer">

            <%

                    ProduktListBean test = (ProduktListBean) session.getAttribute("test");
                    if(test != null){
                        for (ProduktBean p : test.getAllOrders()){
                            out.print("<div class=\"productsWindow\" >" +
                                    "<div class=\"productContainer\">" +
                                    "<div class=\"containerItemName\">" +
                                    "<form class=\"inputForm\">"+
                                    "<input name = \"articleNum\" type = \"hidden\" value = \""+p.getArticleNumber()+"\">"+
                                    "<input name = \"ean\" type = \"hidden\" value = \""+p.getEanNumber()+"\">"+
                                    "<input name = \"department\" type = \"hidden\" value = \""+p.getDepartment()+"\">"+
                                    "<input name = \"name\" type = \"hidden\" value = \""+p.getName()+"\">"+
                                    "<input name = \"category\" type = \"hidden\" value = \""+p.getCategory()+"\">"+
                                    "<input name = \"tradeMark\" type = \"hidden\" value = \""+p.getTradeMark()+"\">"+
                                    "<input name = \"inPrice\" type = \"hidden\" value = \""+p.getInPrice()+"\">"+
                                    "<input name = \"outPrice\" type = \"hidden\" value = \""+p.getOutPrice()+"\">"+
                                    "<input name = \"activeProduct\" type = \"hidden\" value = \""+p.getActiveProduct()+"\">"+
                                    "<input name = \"balance\" type = \"hidden\" value = \""+p.getStockBalance()+"\">"+
                                    "<input name = \"supplier\" type = \"hidden\" value = \""+p.getSupplierId()+"\">"+
                                    "<input name = \"maxStock\" type = \"hidden\" value = \""+p.getMaxStockBalance()+"\">"+
                                    "<input name = \"minStock\" type = \"hidden\" value = \""+p.getMinStockBalance()+"\">"+
                                    "<button  class=\"list-group btn itemNameButton\" onClick = \"showAttributes(this.form)\">"+ p.getName() +"</button>" +
                                    "</form>"+
                                    "</div>" +
                                    "<form class=\"inputForm\">" +
                                    "<input  type=\"hidden\" name=\"hiddenProductName\" value=\""+p.getName()+"\">" +
                                    " <input type=\"hidden\" name=\"hiddenArticleNum\" value=\""+p.getArticleNumber()+"\">" +
                                    " <div class=\"form-group inputFormItemContainer\">" +
                                    " <h2 class=\"packageSizeName\" >DFP(128)</h2>" +
                                    "<input type=\"text\" class=\"form-control inputFormItem\" name=\"DFP\" id=\"bigPack\" >" +
                                    "</div>" +
                                    "<div class=\"form-group inputFormItemContainer\">" +
                                    "<h2 class=\"packageSizeName\">KFP(12)</h2>" +
                                    "<input type=\"text\" class=\"form-control inputFormItem\" name=\"KFP\" id=\"smallPack\" aria-describedby=\"emailHelp\" >" +
                                    "</div>" +
                                    "<h2 class=\"containerItemLager\">Lager:10</h2>" +
                                    "<button class=\"btn btn-outline-primary  submitButton\" onclick=\"addToShoopingCart(this.form)\">Add</button>"+
                                    "</form>" +
                                    "</div>" +
                                    "</div>");

                        }
                    }
                %>
            </div>
        <jsp:include page="orderWindowModal.jsp"></jsp:include>
        <jsp:include page="orderWindowShoopingcartModal.jsp"></jsp:include>



        <button class="btn btn-outline-primary  submitButton" onclick="createProductContainersInShoopingcart()">KundKorg</button>











</main>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script type="text/javascript" src="orderWindow.js"></script>
</body>

</html>