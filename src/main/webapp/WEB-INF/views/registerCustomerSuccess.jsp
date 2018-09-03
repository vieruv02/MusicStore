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
                    <h1>Customer registered successfully</h1>
                </div>
            </div>
        </section>

        <!--ng-app means wiring with angularJs module-->
        <section class="container">
            <p>
                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
            </p>
        </section>
    </div>
</div>
f
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>