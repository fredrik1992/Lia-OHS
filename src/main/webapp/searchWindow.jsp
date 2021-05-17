<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ohsapp.beans.ProduktBean" %>
<%@ page import="com.example.ohsapp.beans.ProduktListBean" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ohs app</title>
    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="myCSS.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body class="body">
<jsp:include page="dashBoard.jsp"></jsp:include>

<div class="container" id="addProductContainer">
    Sök artikel:
    <form action="<%=request.getContextPath()%>/getProductsController" method="GET">
        <div class="row align-items-start">
            <div class="col">
                <input type="text" class="form-control" placeholder="EAN" name="ean">
            </div>
            <div class="col">
                <input type="text" class="form-control" placeholder="ArtickelNr" name="article">
            </div>
            <div class="col">
                <input type="text" class="form-control" placeholder="Namn" name="productName">
            </div>
            <div class="col">
                <div class="float-end">
                    <input type="hidden" name="page" value="searchWindow">
                    <input type="submit" value="Sök" class="btn btn-primary" id="addProductButton"/>
                </div>
            </div>
        </div>
    </form>



<%
    ProduktListBean test = (ProduktListBean) session.getAttribute("test");
    try {
        for (ProduktBean p : test.getAllOrders()) {
            String name = p.getName().replaceAll("\\s","");
            out.print("<ul type=\"button\"class=\"list-group btn itemNameButton\" data-bs-toggle=\"modal\" data-bs-target=\"#staticBackdrop\" " +
                     "onclick=showValues(\""+p.getArticleNumber()+"\",\""+p.getAttribute()+"\",\""
                    +p.getEanNumber()+"\",\""+p.getDepartment()+"\",\""+name
                    +"\",\""+p.getCategory()+"\",\""+p.getInPrice()+"\",\""+p.getTradeMark()
                    +"\",\""+p.getOutPrice()+"\",\""+p.getActiveProduct()+"\",\""+p.getStockBalance()+
                    "\",\""+p.getSupplierId()+"\",\""+p.getMaxStockBalance()+"\",\""+p.getMinStockBalance()+"\")>"
                    + "<li class=\"list-group-item d-flex justify-content-between align-items-center lists\">"
                    + p.getEanNumber() + "        " + p.getName()
                    + "<span class=\"badge bg-primary rounded-pill\">></span>"
                    + "</li>"
                    + "</ul>");
        }
    }catch (Exception e){ return;}
%>
</div>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header dash">
                <h5 class="modal-title" id="staticBackdropLabel">Artikel</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form action="<%=request.getContextPath()%>/alterProductController" method="GET">
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" >Artikelnummer:
                        <input class="input" id="0" name="articlenumber">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenArtNr" value="ArticleNumber   ">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(0)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50 lists">Attribut:
                        <input class="input" id="1">
                        <input type="hidden" name="hiddenAttribute" value="Attribute">
                        <p class="value d-inline"></p>
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(1)">Ändra</button>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists">EAN:
                        <input class="input" id="2" name="ean" >
                        <input class="hiddenean" type="hidden" name="hiddenEan">
                        <p class="value d-inline"></p>
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(2)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50 lists">Avdelning:
                        <input class="input" id="3" name="">
                        <p class="value d-inline"></p>
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(3)">Ändra</button>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists">Namn:
                        <input class="input" id="4" name="name">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="attribute" value="1">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(4)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50 lists">Produktkategori:
                        <input class="input" id="5" name="category">
                        <p class="value d-inline"></p>
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(5)">Ändra</button>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" >Inpris:
                        <input class="input" id="6" name="inprice">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenInPrice" value="InPrice">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(6)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50 lists" >Varumärke:
                        <input class="input" id="7" name="trademark">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenTrademark" value="Trademark">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(7)">Ändra</button>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" >Utpris:
                        <input class="input" id="8" name="outprice">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenOutPrice" value="OutPrice">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(8)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50 lists" >Aktiv:
                        <input class="input" id="9" name="activeProduct">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenActive" value="ActiveProduct">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(9)">Ändra</button>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" >Lagersaldo:
                        <input class="input" id="10" name="stockbalance">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenStockBalance" value="StockBalance">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(10)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50 lists" >Leverantör:
                        <input class="input" id="11" >
                        <p class="value d-inline"></p>
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(11)">Ändra</button>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists">Max i lager:
                        <input class="input" id="12" name="maxstockbalance">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenMax" value="MaxStockBalance">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(12)">Ändra</button>
                    </li>
                    <li class="list-group-item w-50"></li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" >Min i lager:
                        <input class="input" id="13" name="minstockbalance">
                        <p class="value d-inline"></p>
                        <input type="hidden" name="hiddenMin" value="MinStockBalance">
                        <button type="button" class="btn btn-primary btn-sm py-0" onclick="showInputs(13)">Ändra</button>

                    </li>
                    <li class="list-group-item w-50">
                        <button type="submit" class="btn btn-primary btn-sm" >Spara</button></form>
                        <form action="<%=request.getContextPath()%>/removeProductController" method="GET">
                            <input class="hiddenean" type="hidden" name="hiddenEan">
                            <button type="submit" class="btn btn-primary btn-sm" onclick="return confirm('Är du säker?')" >Ta bort vara</button>
                        </form>
                    </li>
                </ul>

            </div>
        </div>
    </div>
</div>

<script>
    let myModal = document.getElementById('myModal')
    let myInput = document.getElementById('myInput')

    myModal.addEventListener('shown.bs.modal', function () {
        myInput.focus()
    })


    function showInputs (name){
        let input = document.getElementById(name)



       if (input.getAttribute("class") === "input"){
        input.setAttribute("class", "displayInput")
        console.log(name)
       } else{input.setAttribute("class", "input")}
    }

    function showValues (articleNr, attribute, ean, department, name, category,
                         inprice, trademark, outprice, active, stockbalance,
                        supplier, maxbalance, minbalance){
        let vlist = [minbalance,maxbalance,supplier,stockbalance,active,outprice,trademark,inprice,category,name,department,ean,attribute,articleNr]
        let v = document.getElementsByClassName("value")
        let hiddenean = document.getElementsByClassName("hiddenean")
        hiddenean.item(0).setAttribute("value", ean)
        hiddenean.item(1).setAttribute("value", ean)
        console.log(vlist)
        for (let i = 0; i<v.length; i++){
            let val = v.item(i)
            val.innerText = vlist.pop()
        }
    }


</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>