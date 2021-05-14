<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="Css/myCSS.css">
    <link href="Css/style.css" rel="stylesheet">

    <title>Lägg till vara</title>
</head>
<body>
<%
    // New location to be redirected
    if(session.getAttribute("user") ==null){
        String site = new String("index.html");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }

%>
<jsp:include page="dashBoard.jsp"></jsp:include>

<div class="container" id="addProductContainer">
    Lägg till artikel:
    <form action="<%=request.getContextPath()%>/addProductController" method="GET">
        <div class="row align-items-start">
            <div class="col">
                <input type="text" name="ean" class="form-control" placeholder="EAN">
            </div>
            <div class="col">
                <input type="text" name="articlenumber" class="form-control" placeholder="Artikelnummer">
            </div>
            <div class="col">
                <input type="text" name="name" class="form-control" placeholder="Namn">
            </div>
            <div class="col">
                <input type="text" name="trademark" class="form-control" placeholder="Varumärke">
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <input type="text" name="inprice" class="form-control" placeholder="Inpris">
            </div>
            <div class="col">
                <input type="text" name="outprice" class="form-control" placeholder="Utpris">
            </div>
            <div class="col">
                <input type="text" name="kfpsize" class="form-control" placeholder="KRP Storlek">
            </div>
            <div class="col">
                <input type="text" name="dfpsize" class="form-control" placeholder="DFP Storlek">
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <input type="text" name="minstockbalance" class="form-control" placeholder="Min i lager">
            </div>
            <div class="col">
                <input type="text" name="maxstockbalance" class="form-control" placeholder="Max i lager">
            </div>
            <div class="col">
                <input type="text" name="stockbalance" class="form-control" placeholder="Antal i lager">
            </div>
            <div class="col">
                <input type="text" name="department" class="form-control" placeholder="Avdelning">
            </div>
        </div>
        <div class="row align-items-end">
            <div class="col">
                <input type="text" name="category" class="form-control" placeholder="Kategori">
            </div>
            <div class="col">
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="addProductAttributeDropdown"
                        data-bs-toggle="dropdown" aria-expanded="false">Attribut
                </button>
                <ul class="dropdown-menu">
                    <li><label class="checkbox">18+ <input type="checkbox" name="18plus"></label></li>
                    <li><label class="checkbox">Pant 1kr <input type="checkbox" name="pant1kr"></label></li>
                    <li><label class="checkbox">Pant 2kr <input type="checkbox" name="pant2kr"></label></li>
                    <li><label class="checkbox">Larmad <input type="checkbox" name="larmad"></label></li>
                </ul>
            </div>
            <div class="col">
                <div class="float-end">
                    Aktiv
                    <label class="switch">
                        <input type="checkbox" name="activeproduct">
                        <span class="slider round"></span>
                    </label>
                </div>
            </div>
            <div class="col">
                <div class="float-end">
                    <input type="submit" value="Lägg till" class="btn btn-primary" id="addProductButton"/>
                </div>
            </div>
        </div>
    </form>
</div>


</body>
</html>