console.log("script loaded")
let shoppingCart = [];


//function that  trys to take an argument from input field and check what to saerch for


function showAttributes(form) {
    event.preventDefault();
    console.log("staticBackdrop")
    $('#staticBackdrop').modal("show")

    let articleNum = form.articleNum.value;
    let ean = form.ean.value;
    let department = form.department.value;
    let name = form.name.value;
    let category = form.category.value;
    let inPrice = form.inPrice.value;
    let tradeMark = form.tradeMark.value;
    let outPrice = form.outPrice.value;
    let activeProduct = form.activeProduct.value;
    let balance = form.balance.value;
    let supplier = form.supplier.value;
    let maxStock = form.maxStock.value;
    let minStock = form.minStock.value;
    document.getElementById("attributeModalArticle").innerText = articleNum;
    document.getElementById("attributeModalEan").innerText = ean;
    document.getElementById("attributeModalDepartment").innerText = department;
    document.getElementById("attributeModalNamn").innerText = name;
    document.getElementById("attributeModalCategory").innerText = category;
    document.getElementById("attributeModalInPrice").innerText = inPrice;
    document.getElementById("attributeModalBrand").innerText = tradeMark;
    document.getElementById("attributeModalOutPrice").innerText = outPrice;
    document.getElementById("attributeModalActive").innerText = activeProduct;
    document.getElementById("attributeModalBalance").innerText = balance;
    document.getElementById("attributeModalSupplier").innerText = supplier;
    document.getElementById("attributeModalMaxStock").innerText = maxStock;
    document.getElementById("attributeModalMinStock").innerText = minStock;


}


function addToShoopingCart(form) {
    event.preventDefault();
    let productName = form.hiddenProductName.value;
    let articleNum = form.hiddenArticleNum.value;
    let dfpValue = form.DFP.value;
    let kfp = form.KFP.value;
    if (dfpValue == "" && kfp == "") {// if no orders have been put don't save
        return
    }
    if (dfpValue == "") {// default value if one order input is empty
        dfpValue = "0";
    }
    if (kfp == "") {
        kfp = "0";
    }


    let produktObject = {
        name: productName,
        ean: articleNum,
        dfp: dfpValue,
        kfp: kfp
    }

    shoppingCart.push(produktObject);


}

function createProductContainersInShoopingcart() {
    $('#testModal').modal("show")
    var elements = document.querySelectorAll('.cartItemBox');
    for (var element of elements) {
        element.remove();

    }//removes all elements before adding again

    let targetModal = document.getElementById("modal-body-cart");
    for (i = 0; i < shoppingCart.length; i++) {
        let container = document.createElement("div");
        container.classList.add("cartItemBox")

        let productNameBox = document.createElement("div")
        productNameBox.classList.add("cartItem")


        let productName = document.createElement("h2")
        productName.innerText = shoppingCart[i].name;
        productNameBox.appendChild(productName)

        let productDFPBox = document.createElement("div")
        productDFPBox.classList.add("cartItem")

        let productDFP = document.createElement("h2")
        productDFP.innerText = "DFP:" + shoppingCart[i].dfp;
        productDFPBox.appendChild(productDFP)

        let productKFPBox = document.createElement("div")
        productKFPBox.classList.add("cartItem")

        let productKFP = document.createElement("h2")
        productKFP.innerText = "KFP:" + shoppingCart[i].kfp;
        productKFPBox.appendChild(productKFP)


        container.appendChild(productNameBox);
        container.appendChild(productDFPBox);
        container.appendChild(productKFPBox);
        targetModal.appendChild(container)
    }

}


function saveOrder() {

    let arrayOfOrders = [];

    for (let i = 0; i < shoppingCart.length; i++) {
        let name = shoppingCart[i].name;
        let ean = shoppingCart[i].ean;
        let dfp = shoppingCart[i].dfp;
        let kfp = shoppingCart[i].kfp;
        arrayOfOrders.push(
            name, ean, dfp, kfp, "$"
        )
    }
    console.log(arrayOfOrders)
    let allOrders = JSON.stringify(arrayOfOrders);
    console.log(allOrders);
    document.getElementById("123").value = allOrders;


}