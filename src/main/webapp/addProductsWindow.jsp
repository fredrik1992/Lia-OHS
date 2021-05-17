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

    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
        </symbol>
        <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
        </symbol>
        <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
        </symbol>
    </svg>

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
<header>
    <jsp:include page="dashBoard.jsp"></jsp:include>
</header>

<main class="container" id="addContainer">
    <%
        String addProductProcess = (String) request.getAttribute("addProductProcess");
        String alertClassName = "alert-danger";
        String alertMessage = "Något gick fel.";
        String alertIcon = "#exclamation-triangle-fill";

        if (addProductProcess != null) {
            if (addProductProcess.equals("1")) {
                alertClassName = "alert-success";
                alertMessage = "Produkten har lagts till.";
                alertIcon = "#check-circle-fill";
            } else if (addProductProcess.equals("0")) {
                alertMessage = "Det finns redan en produkt med detta EAN eller Artikel nummer.";
            }

            out.println("<div class=\"alert " + alertClassName + " d-flex align-items-center\" role = \"alert\">");
            out.println("<svg class=\"bi flex-shrink-0 me-2\" width = \"24\" height = \"24\" >");
            out.println("<use xlink:href=\"" + alertIcon + "\" />");
            out.println("</svg>");
            out.println("<div>");
            out.println(alertMessage);
            out.println("</div>");
            out.println("</div >");
        }
    %>
    Lägg till artikel:
    <form action="<%=request.getContextPath()%>/addProductController" method="POST">
        <div class="row align-items-start">
            <div class="col">
                <input type="text" name="ean" class="form-control" placeholder="EAN" required>
            </div>
            <div class="col">
                <input type="text" name="articlenumber" class="form-control" placeholder="Artikelnummer" required>
            </div>
            <div class="col">
                <input type="text" name="name" class="form-control" placeholder="Namn" required>
            </div>
            <div class="col">
                <input type="text" name="trademark" class="form-control" placeholder="Varumärke" required>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <input type="text" name="inprice" class="form-control" placeholder="Inpris" required>
            </div>
            <div class="col">
                <input type="text" name="outprice" class="form-control" placeholder="Utpris" required>
            </div>
            <div class="col">
                <input type="text" name="kfpsize" class="form-control" placeholder="KRP Storlek" required>
            </div>
            <div class="col">
                <input type="text" name="dfpsize" class="form-control" placeholder="DFP Storlek" required>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <input type="text" name="minstockbalance" class="form-control" placeholder="Min i lager" required>
            </div>
            <div class="col">
                <input type="text" name="maxstockbalance" class="form-control" placeholder="Max i lager" required>
            </div>
            <div class="col">
                <input type="text" name="stockbalance" class="form-control" placeholder="Antal i lager" required>
            </div>
            <div class="col">
                <input type="text" name="department" class="form-control" placeholder="Avdelning" required>
            </div>
        </div>
        <div class="row align-items-end">
            <div class="col">
                <input type="text" name="category" class="form-control" placeholder="Kategori" required>
            </div>
            <div class="col">
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="addProductAttributeDropdown"
                        data-bs-toggle="dropdown" aria-expanded="false">Attribut
                </button>
                <ul class="dropdown-menu">
                    <li><label class="form-check-label">18+ <input type="checkbox" class="form-check-input"
                                                                   name="18plus"></label></li>
                    <li><label class="form-check-label">Pant 1kr <input type="checkbox" class="form-check-input"
                                                                        name="pant1kr"></label></li>
                    <li><label class="form-check-label">Pant 2kr <input type="checkbox" class="form-check-input"
                                                                        name="pant2kr"></label></li>
                    <li><label class="form-check-label">Larmad <input type="checkbox" class="form-check-input"
                                                                      name="larmad"></label></li>
                </ul>
            </div>
            <div class="col">
                <div class="float-end">
                    Aktiv
                    <label class="switch">
                        <input type="hidden" name="activeproduct" value="0"><input type="checkbox"
                                                                                   onclick="this.previousSibling.value=1-this.previousSibling.value">
                        <span class="slider round"></span>
                    </label>
                </div>
            </div>
            <div class="col">
                <div class="float-end">
                    <input type="submit" value="Lägg till" class="btn btn-primary" id="addButton"/>
                </div>
            </div>
        </div>
    </form>
</main>

</body>
</html>