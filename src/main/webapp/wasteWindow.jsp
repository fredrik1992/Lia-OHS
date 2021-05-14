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

    <title>Svinn</title>
</head>
<body>
<jsp:include page="dashBoard.jsp"></jsp:include>

<div class="container" id="addProductContainer">
    Svinna vara:
    <form action="<%=request.getContextPath()%>/wasteController" method="GET">
        <div class="row align-items-start">
            <div class="col">
                <input type="text" name="ean" class="form-control" placeholder="EAN">
            </div>
            <div class="col">
                <input type="text" name="antal" class="form-control" placeholder="Antal">
            </div>
            <div class="col">
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="addProductAttributeDropdown"
                        data-bs-toggle="dropdown" aria-expanded="false">Orsak
                </button>
                <ul class="dropdown-menu">
                    <li><label class="checkbox">Trasig förpackning <input type="checkbox" name="trasigFPK"></label></li>
                    <li><label class="checkbox">Vac-släpp <input type="checkbox" name="vacSläpp"></label></li>
                    <li><label class="checkbox">Stöld <input type="checkbox" name="stöld"></label></li>
                </ul>
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