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
            <a class="nav-link" href="apis">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="views">Views users</a>
        </li>
    </ul>
</div>

<div class="container mt-4" style="max-width: 600px;">
    <form class="form-control" action="edite-user" method="post" >
        <%-- when need to begin path just add "/<path for method>"--%>
        <div class="container mt-4 ">
            <p class="text-center mt-4 p-3 rounded" style="font-size: 30px;">${message}</p>
        </div>
        <div class="row">

            <div class="col">
                <label class="form-label">fullname</label>
                <input class="form-control" type="text" value="${user.fullname}" name="fullname" maxlength="25" required>
            </div>

            <div class="col">
                <label class="form-label">age</label>
                <input class="form-control" type="number" value="${user.age}" name="age" min="0" max="60" maxlength="2" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">weight</label>
                <input class="form-control" type="number" value="${user.weight}" name="weight" step="any" min="0" maxlength="3" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">height</label>
                <input class="form-control" type="number" value="${user.height}" name="height" step="any" min="0" maxlength="3" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">email</label>
                <input class="form-control" type="email" value="${user.email}" name="email" maxlength="35" required>
                <input class="form-control" type="number" hidden="hidden" value="${user.id}" name="id">
            </div>


            <div class="container text-center">
                <button class="btn btn-success mt-3 mb-3" type="submit" id="send">send</button>
            </div>

        </div>
    </form>
</div>

</body>
</html>