<!--below we add stuff to refer to header.jsp-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container" style="margin-top: 20px;">
        <div class="page-header">
            <h1>Register Customer</h1>
            <p class="lead">Please fill in your information below:</p>
        </div>

        <!--spring form action (enctype="multipart/form-data" is for image upload)-->
        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer">

        <h3>Basic Info</h3>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="name">Name</label>
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="email">Email</label>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="phone">Phone number:</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="username">Username</label>
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="password">Password</label>
            <form:password path="password" id="password" class="form-Control"/>
        </div>




        <h3>Billing Address</h3>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="billingStreet">Street Name:</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="billingApartmentNumber">Apartment Number:</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="billingCity">City:</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="billingState">State:</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="billingCountry">Country:</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="billingZipCode">Zip Code:</label>
            <form:input path="billingAddress.zipCode" id="billingZipCode" class="form-Control"/>
        </div>



        <h3>Shipping Section</h3>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="shippingStreet">Street Name:</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="shippingApartmentNumber">Apartment Number:</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="shippingCity">City:</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="shippingState">State:</label>
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="shippingCountry">Country:</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="shippingZipCode">Zip Code:</label>
            <form:input path="shippingAddress.zipCode" id="shippingZipCode" class="form-Control"/>
        </div>


        <br />
        <br />
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>

        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>