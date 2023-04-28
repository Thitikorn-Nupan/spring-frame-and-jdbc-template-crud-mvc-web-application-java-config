<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="java" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--    <link href="<c:url value="/css/style-home.css" />" rel="stylesheet">--%>
    <link href="<java:url value="/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<java:url value="/css/form-user-style.css" />" rel="stylesheet">
    <link href="<java:url value="/image/logo.png" />" rel="icon">
    <title>User Form</title>
</head>

<body>

<div class="container">
    <ul class="nav nav-tabs" id="">
        <li class="nav-item">
            <a class="nav-link" href="apis">Home</a> <%-- (not nescessory "/") apis request to class controll -> /apis--%>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="views">Views users</a>
        </li>
    </ul>
</div>

<div class="container mt-4" style="max-width: 600px;">
    <form class="form-control" action="create-user" method="post" >
        <div class="container mt-4 ">
            <p class="text-center mt-4 p-3 rounded" style="font-size: 30px;">${message}</p>
        </div>
        <div class="row">

            <div class="col">
                <label class="form-label">fullname</label>
                <input class="form-control" type="text" placeholder="your fullname..." name="fullname" maxlength="25" required>
            </div>

            <div class="col">
                <label class="form-label">age</label>
                <input class="form-control" type="number" placeholder="your age..." name="age" min="0" max="60" maxlength="2" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">weight</label>
                <input class="form-control" type="number" placeholder="your weight (kg) ..." name="weight" step="any" min="0" maxlength="3" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">height</label>
                <input class="form-control" type="number" placeholder="your height (cm) ..." name="height" step="any" min="0" maxlength="3" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">email</label>
                <input class="form-control" type="email" placeholder="your email... " name="email" maxlength="35" required>
            </div>


            <div class="container text-center">
                <button class="btn btn-success mt-3 mb-3" type="submit" id="send">send</button>
                <button class="btn btn-warning mt-3 mb-3" type="reset" id="reset">reset</button>
            </div>

        </div>
    </form>
</div>

</body>
</html>