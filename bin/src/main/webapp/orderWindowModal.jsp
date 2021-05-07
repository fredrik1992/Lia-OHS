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
                    <li class="list-group-item w-50 lists" onclick="showInputs(0)">Artikelnummer:
                        <input class="input" id="0">
                    </li>
                    <li class="list-group-item w-50 lists" onclick="showInputs(1)">Attribut:
                        <input class="input" id="1">
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" onclick="showInputs(2)">EAN:
                        <input class="input" id="2">
                    </li>
                    <li class="list-group-item w-50 lists" onclick="showInputs(3)">Avdelning:
                        <input class="input" id="3">
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" onclick="showInputs(4)">Namn:
                        <input class="input" id="4">
                    </li>
                    <li class="list-group-item w-50 lists"onclick="showInputs(5)">Produktkategori:
                        <input class="input" id="5">
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" onclick="showInputs(6)">Inpris:
                        <input class="input" id="6">
                    </li>
                    <li class="list-group-item w-50 lists" onclick="showInputs(7)">Varumärke:
                        <input class="input" id="7">
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" onclick="showInputs(8)">Utpris:
                        <input class="input" id="8">
                    </li>
                    <li class="list-group-item w-50 lists" onclick="showInputs(9)">Aktiv:
                        <input class="input" id="9">
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" onclick="showInputs(10)">Lagersaldo:
                        <input class="input" id="10">
                    </li>
                    <li class="list-group-item w-50 lists" onclick="showInputs(11)">Leverantör:
                        <input class="input" id="11">
                    </li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists"onclick="showInputs(12)">Max i lager:
                        <input class="input" id="12">
                    </li>
                    <li class="list-group-item w-50"></li>
                </ul>
                <ul class="list-group list-group-horizontal">
                    <li class="list-group-item w-50 lists" onclick="showInputs(13)">Min i lager:
                        <input class="input" id="13">
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