<!--below we add stuff to refer to header.jsp-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Here is the details information of the product</p>
        </div>

        <div class="container" data-ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>"
                         alt="image" style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p><strong>Manufacturer</strong> : ${product.productManufacturer}</p>
                    <p><strong>Category</strong> : ${product.productCategory}</p>
                    <p><strong>Condition</strong> : ${product.productCondition}</p>
                    <p><h4>${product.productPrice} USD</h4></p>

                    <br>

                    <!--We create this chunk of code set the role and the link to page, if the role
                    is admin then the page is changed to "/admin/productInventory"-->
                    <!--JSTL function to define a variable with an expression value-->

                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/product/productList"/>
                    <c:if test="${role = 'admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <!--We create this chunk of code set the role and the link to page, if the role
                    is admin then the page is changed to "/admin/productInventory"-->


                    <!--Whenever we click this button it goes back to {url}(/productList)
                    if the role is admin then when we click on back button we will
                    go back to /admin/productInventory-->
                    <p data-ng-controller ="cartCtrl">
                        <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>

                        <!--PAY attention here - you made a mistake here-->
                        <a href="#" class="btn btn-warning btn-large" data-ng-click="addToCart('${product.productId}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>

                        <a href="<spring:url value="/cart"/>" class="btn btn-default">
                            <span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>