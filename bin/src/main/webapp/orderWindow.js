console.log("script loaded")


//function that  trys to take an argument from input field and check what to saerch for
function searchForProduct (ean,article,product){
let generatedProductList;
 if(ean.length !=0){//checks wich input has been filled

     generatedproductList = getProductContainersList(ean,"eanNumber")
    createProductsContainer(generatedProductList)// creates containers from a generated list

 }else if (article.length !=0){

     generatedproductList = getProductContainersList(article,"articleNumber")
     createProductsContainer(generatedProductList)

 }else if (product.length !=0){

     generatedProductList =  getProductContainersList(product,"productName")
     createProductsContainer(generatedProductList)

 }else(console.log("no input was given try again"))

}

function getProductContainersList(searchValue,typeValue){
    //var procutListToShow = []
    if(typeValue == "eanNumber"){
        /*for(i=0;i<allProducts.length;i++){
           if( allProducts[i].getEan == searchvalue){
            productListToShow.push(allProducts[i])
           }
           return productListToShow

        */
    }else if(typeValue == "articleNumber"){
        /*for(i=0;i<allProducts.length;i++){
          if( allProducts[i].getArticleNumber == searchvalue){
           productListToShow.push(allProducts[i])
          }

       */
    }else if (typeValue == "productName"){
        /*for(i=0;i<allProducts.length;i++){
         if( allProducts[i].getName == searchvalue){
          productListToShow.push(allProducts[i])
         }

      */
    }

}

function createProductsContainer(listOfProducts){

}


//eventlistener when page is loaded to see if any products have been loaded
//function to remove all containers and functions