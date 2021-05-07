<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>




<!-- Modal -->
<div class="modal fade " id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header dash">
                <h5 class="modal-title" id="staticBackdropLabel">Korg</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="shoppingCartBody">

            </div>
        </div>
        <button onclick="callTest()">Slutför Köp</button> <!-- need to call a function that sens the cart list to server-->
    </div>

</div>
<button onclick="callTest()">Slutför Köp</button>
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