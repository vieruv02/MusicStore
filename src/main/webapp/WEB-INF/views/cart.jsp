<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <!--ng-app means wiring with angularJs module-->
        <section class="container" data-ng-app="cartApp">
            <!--initializing a cart-->
            <div data-ng-controller="cartCtrl" data-ng-init="initCartId('${cartId}')">

                <div>
                    <!--it will be pulled to the left of screen-->
                    <a class="btn btn-danger pull-left" data-ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <!--refering to Cart class that contains a list of cartItems-->
                    <!--here we are looping through each item in Cart-->
                    <tr data-ng-repeat = "item in cart.cartItems">
                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productPrice}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="label label-danger" data-ng-click="removeFromCart(item.product.productId)">
                            <span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>

                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>