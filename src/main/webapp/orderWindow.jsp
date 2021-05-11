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
    <link rel="stylesheet" type="text/css" href="orderWindow.css ">
    <link rel="stylesheet" href="myCSS.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>

</head>
<body>

<jsp:include page="dashBoard.jsp"></jsp:include>

<main>
    <%--  add so that a servelet is called that gets all the orders and add them to orderlistbean then get them here
 so that you cant use javascript to create dynamic windows ina a nice list--%>

    <div class="headContainer" >
        <h1>sök på artikel</h1>
        <%-- make a serch trough javascript that gets it from the listbean  --%>


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
            <%-- skicka till controllerec2-user@ec2-3-250-53-125.eu-west-1.compute.amazonaws.com --%>
            <button type="submit" class="btn btn-primary submitButton">sök</button>



        </form>
    </div>
        <jsp:include page="orderWindowModal.jsp"></jsp:include>


        <div id="productsContainer">
        <div class="productsWindow" >



            <div class="productContainer">
                <div class="containerItemName">
                    <form >
                        <input type="hidden" name="hiddenEan" value="7854">
                        <button type="submit"class="list-group btn itemNameButton" data-bs-toggle="modal" data-bs-target="#staticBackdrop" >Ketchup 1000g</button>
                    </form>


                    <%--maby hidden element that contains the ean code here --%>
                </div>

                <form class="inputForm">
                    <input type="hidden" name="hiddenProductName" value="Ketchup 1000g">
                    <input type="hidden" name="hiddenEanCode" value="7854">

                    <div class="form-group inputFormItemContainer">
                        <h2 class="packageSizeName" >DFP(128)</h2>
                        <input type="text" class="form-control inputFormItem" name="DFP" id="bigPack" >

                    </div>

                    <div class="form-group inputFormItemContainer">
                        <h2 class="packageSizeName">KFP(12)</h2>
                        <input type="text" class="form-control inputFormItem" name="KFP" id="smallPack" aria-describedby="emailHelp" >

                    </div>
                    <h2 class="containerItemLager">Lager:10</h2>
                    <button class="articleFormSubmit" onclick="addToShoopingCart(this.form)"></button>




                </form>



            </div>

            <div class="productsWindow" id="productsWindow">



                <div class="productContainer">
                    <div class="containerItemName">
                        <button type="button"class="list-group btn itemNameButton" data-bs-toggle="modal" data-bs-target="#staticBackdrop" >Ketchup felix 1000g</button>
                        <%--maby hidden element that contains the ean code here --%>
                    </div>

                    <form class="inputForm">
                        <input type="hidden" name="hiddenProductName" value="Ketchup felix 1000g">
                        <input type="hidden" name="hiddenEanCode" value="1234567">
                        <div class="form-group inputFormItemContainer">
                            <h2 class="packageSizeName" >DFP(128)</h2>
                            <input type="email" class="form-control inputFormItem" id="bigPack" aria-describedby="emailHelp" >

                        </div>

                        <div class="form-group inputFormItemContainer">
                            <h2 class="packageSizeName">KFP(12)</h2>
                            <input type="email" class="form-control inputFormItem" id="smallPack" aria-describedby="emailHelp" >

                        </div>
                        <h2 class="containerItemLager">Lager:10</h2>
                        <button class="articleFormSubmit" onclick="addToShoopingCart(this.form)"></button>




                    </form>



                </div>
            </div>
                <jsp:include page="orderWindowShoopingcartModal.jsp"></jsp:include>
                <button type="submit"class="list-group btn itemNameButton" data-bs-toggle="modal" data-bs-target="#staticBackdrop2" onclick="createProductContainersInShoopingcart()" >Ketchup 1000g</button>

<div id="testy">


    <h1>Welcome to <%

        ProduktListBean test = (ProduktListBean) session.getAttribute("test");
        if(test != null){
            for (ProduktBean p : test.getAllOrders()){
                out.print(p.getName());
            }
        }
         %> </h1>


</div>

<script>
    let myModal = document.getElementById('myModal')
let myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus()
}) </script>

</main>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script type="text/javascript" src="orderWindow.js"></script>
</body>

</html>