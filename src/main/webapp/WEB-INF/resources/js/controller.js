var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    //function to refresh the cart
    $scope.refreshCart = function(){
        //wire with get function in "CartController" class - we get cart data in JSON format, if success it will be stored in "data"
        $http.get('/EMusicStore/rest/cart/' + $scope.cartId).success(function (data){
            $scope.cart=data;
        });
    };

    //delete function
    $scope.clearCart = function(){
        $http.delete('/EMusicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };


    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
        $http.put('/EMusicStore/rest/cart/add/' + productId).success(function (){
            alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function(productId){
        $http.put('/EMusicStore/rest/cart/remove/' + productId).success(function (data){
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
      var grandTotal=0;

      for(var i=0; i<$scope.cart.cartItems.length; i++){
          grandTotal+=$scope.cart.cartItems[i].totalPrice;
      }
        return grandTotal;
    };
});