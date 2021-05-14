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
<jsp:include page="dashBoard.jsp"></jsp:include>

<div class="container" id="addProductContainer">
    <div class="row">
        <div class="col">
            <ul class="list-group">
                <li class="list-group-item lists">Försäljning</li>
                <li class="list-group-item lists">Svinn</li>
            </ul>
        </div>
        <div class="col-md-8">
            <div class="card mb-3">

                <div class="card-body">
                    <img src="data:image/jpeg;base64,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" class="card-img-top" alt="...">
                    <hr class="solid">
                    <div class="row">
                        <div class="col">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                <label class="form-check-label" for="inlineRadio1">Dag</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option1">
                                <label class="form-check-label" for="inlineRadio2">Vecka</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option1">
                                <label class="form-check-label" for="inlineRadio3">Månad</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" value="option1">
                                <label class="form-check-label" for="inlineRadio4">År</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div>
    </div>
</div>


</body>
</html>