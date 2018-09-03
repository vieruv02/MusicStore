<!--below we add stuff to refer to header.jsp-->
<%@include file="/WEB-INF/views/template/header.jsp"%>
<br>
<br>
    <div class="container">
        <br>
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">This is the administrator page</p>
        </div>

        <!--Welcoming the user-->
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>


<%@include file="/WEB-INF/views/template/footer.jsp"%>