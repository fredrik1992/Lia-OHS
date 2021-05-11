console.log("script loaded")
let shoppingCart = [];



//function that  trys to take an argument from input field and check what to saerch for




function createProductsContainer(listOfProducts){ // called when page is loaded
    let productsFromDatabase =[];

    for(i = 0;i<productsFromDatabase.length;i++){
        let productsWindow = document.createElement("div");
        productsWindow.classList.add("productsWindow")

        //product Container
        let productContainer = document.createElement("div");
        productContainer.classList.add("productContainer")
        productsWindow.append(productContainer)

        let itemNameContainer = document.createElement("div");
        itemNameContainer.classList.add("containerItemName");
        productContainer.append(itemNameContainer);

        let getProductDataForm = document.createElement("form");
        itemNameContainer.append(getProductDataForm);

        let hiddenEanInput = document.createElement("input");
        hiddenEanInput.type = "hidden";
        hiddenEanInput.name = "hiddenEan";
        hiddenEanInput.value = productsFromDatabase[i].ean;
        getProductDataForm.append(hiddenEanInput);

        let submitButton = document.createElement("button");
        submitButton.type = "submit";
        submitButton.classList.add("list-group btn itemNameButton");
        // have to check this submitButton.data-bs-toggle ="modal";
        submitButton.value = productsFromDatabase[i].name;
        itemNameContainer.append(submitButton);


        //product container end

        //inputForm
        let inputForm = document.createElement("form");
        inputForm.classList.add("inputForm");
        productsWindow.append(inputForm)

        let inputProductName = document.createElement("input");
        inputProductName.type ="hidden";
        inputProductName.name ="hiddenProductName";
        inputProductName.value = productsFromDatabase[i].name;
        inputForm.append(inputProductName);

        let inputEanCode = document.createElement("input");
        inputProductName.type ="hidden";
        inputProductName.name ="hiddenEanCode";
        inputProductName.value = productsFromDatabase[i].ean;
        inputForm.append(inputEanCode);

        //dfp
        let dfpContainer = document.createElement("div");
        dfpContainer.classList.add("form-group inputFormItemContainer");
        inputForm.append(dfpContainer);

        let dfpName = document.createElement("h2")
        dfpName.classList.add("packageSizeName");
        dfpName.innerText = "DFP(128)";
        dfpContainer.append(dfpName);

        let inputDfp = document.createElement("input");
        inputDfp.type = "text";
        inputDfp.classList.add("form-control inputFormItem");
        inputDfp.name = "DFP";
        inputDfp.id = "bigPack";
        dfpContainer.append(inputDfp)
        //dfp

        //kfp

        let kfpContainer = document.createElement("div");
        kfpContainer.classList.add("form-group inputFormItemContainer");
        inputForm.append(kfpContainer);

        let kfpName = document.createElement("h2")
        kfpName.classList.add("packageSizeName");
        kfpName.innerText = "KFP(128)";
        kfpContainer.append(kfpName);

        let inputKfp = document.createElement("input");
        inputKfp.type = "text";
        inputDfp.classList.add("form-control inputFormItem");
        inputDfp.name = "DFP";
        inputDfp.id = "bigPack";
        dfpContainer.append(inputDfp)


    }



}


function addToShoopingCart(form){
    event.preventDefault();
    let productName = form.hiddenProductName.value;
    let eanCode = form.hiddenEanCode.value;
    let dfpValue = form.DFP.value;
    let kfp = form.KFP.value;
    if(dfpValue == "" && kfp == ""){// if no orders have been put don't save
        return
    }
    if (dfpValue == ""){// default value if one order input is empty
        dfpValue = "0";
    }
    if(kfp == ""){
        kfp = "0";
    }



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

function callTest(){// ta bort ?
    alert("in test")
    console.log("test")
    $.post("/testa");
}

function getProduktDataFromSession(form){
    //gewt the ean here and pupulate modal with the data  from sessiosn that matches ean
}

//eventlistener when page is loaded to see if any products have been loaded
//function to remove all containers and functions