console.log("script loaded")
let shoppingCart = [];


//function that  trys to take an argument from input field and check what to saerch for




function createProductsContainer(listOfProducts){

}


function addToShoopingCart(form){
    event.preventDefault();
    let productName = form.hiddenProductName.value;
    let eanCode = form.hiddenEanCode.value;
    let dfpValue = form.DFP.value;
    let kfp = form.KFP.value;


    let produktObject = {
        name:productName ,
        ean:eanCode,
        dfp:dfpValue,
        kfp:kfp
    }

    shoppingCart.push(produktObject); //devider between values





}
function createProductContainersInShoopingcart(){
    var elements = document.querySelectorAll('.cartItemBox');
    for (var element of elements) {
        element.remove();

    }//removes all elements before adding again

    let targetModal = document.getElementById("shoppingCartBody");
    for (i=0;i<shoppingCart.length;i++){
        let container = document.createElement("div");
        container.classList.add("cartItemBox")

        let productNameBox =document.createElement("div")
        productNameBox.classList.add("cartItem")


        let productName =document.createElement("h2")
        productName.innerText = shoppingCart[i].name;
        productNameBox.appendChild(productName)

        let productDFPBox =document.createElement("div")
        productDFPBox.classList.add("cartItem")

        let productDFP =document.createElement("h2")
        productDFP.innerText = "DFP:" + shoppingCart[i].dfp;
        productDFPBox.appendChild(productDFP)

        let productKFPBox =document.createElement("div")
        productKFPBox.classList.add("cartItem")

        let productKFP =document.createElement("h2")
        productKFP.innerText = "KFP:" + shoppingCart[i].kfp;
        productKFPBox.appendChild(productKFP)




        container.appendChild(productNameBox);
        container.appendChild(productDFPBox);
        container.appendChild(productKFPBox);
        targetModal.appendChild(container)
    }

}

function callTest(){
    alert("in test")
    console.log("test")
    $.post("/testa");
}



//eventlistener when page is loaded to see if any products have been loaded
//function to remove all containers and functions