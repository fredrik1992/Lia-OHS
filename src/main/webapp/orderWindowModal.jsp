<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>




<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header dash">
                <h5 class="modal-title" id="staticBackdropLabel">Artikel</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(0)">Artikelnummer:
                        <h5 id="attributeModalArticle"></h5>
                    </li>

                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(2)">EAN:
                        <h5 id="attributeModalEan"></h5>
                    </li>
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(3)">Avdelning:
                        <h5 id="attributeModalDepartment"></h5>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(4)">Namn:
                        <h5 id="attributeModalNamn"></h5>
                    </li>
                    <li class="list-group-item w-50 lists attributeModalItem"onclick="showInputs(5)">Produktkategori:
                        <h5 id="attributeModalCategory"></h5>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(6)">Inpris:
                        <h5 id="attributeModalInPrice"></h5>
                    </li>
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(7)">Varumärke:
                        <h5 id="attributeModalBrand"></h5>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(8)">Utpris:
                        <h5 id="attributeModalOutPrice"></h5>
                    </li>
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(9)">Aktiv:
                        <h5 id="attributeModalActive"></h5>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(10)">Lagersaldo:
                        <h5 id="attributeModalBalance"></h5>
                    </li>
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(11)">Leverantör:
                        <h5 id="attributeModalSupplier"></h5>
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem"onclick="showInputs(12)">Max i lager:
                        <h5 id="attributeModalMaxStock"></h5>
                    </li>
                    <li class="list-group-item w-50"></li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists attributeModalItem" onclick="showInputs(13)">Min i lager:
                        <h5 id="attributeModalMinStock"></h5>
                    </li>
                    <li class="list-group-item w-50"><button type="button" class="btn btn-primary btn-sm" >Ta bort vara</button></li>
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

    function showInputs (number){
        let input = document.getElementById(number)
        if (input.getAttribute("class") === "input"){
            input.setAttribute("class", "displayInput")
            console.log(number)
        } else{input.setAttribute("class", "input")}
    }



</script>