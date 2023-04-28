<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="java" uri="http://www.springframework.org/tags" %>
<%-- if forEach loop not work and erorrs tells :  Cannot resolve symbol 'c:forEach' --%>
<%-- change prefix="c" to "java" in this case is worked --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- this line for using forEach loop --%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%-- when <c:url ...> than get result errors  --%>
    <%-- cheng to <java:url ...>  --%>
    <link href="<java:url value="/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<java:url value="/css/view-users-style.css" />" rel="stylesheet">
    <link href="<java:url value="image/logo.png" />" rel="icon">
    <title>View Users</title>
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

<div class="container mt-4" style="max-width: 960px">
    <div class="row">
        <table class="table table-striped">

            <thead>
            <tr>
                <th>ID</th>
                <th>Fullname</th>
                <th>Age</th>
                <th>Weight</th>
                <th>Height</th>
                <th>Email</th>
                <th class="text-center">Choose</th>
            </tr>
            </thead>

            <tbody class="" style="font-size: 24px;">
            <% int i = 1; %> <%-- set i start 1 --%>
                <c:forEach var="users" items="${users}">
                    <tr class="mt-2">
                        <td><%= i %></td> <%-- print i thru jsp (if need to show value put <%(=) variable %>  --%>
                        <td>${users.fullname}</td>
                        <td>${users.age}</td>
                        <td>${users.weight}</td>
                        <td>${users.height}</td>
                        <td>${users.email}</td>
                        <td class="text-center">
                            <a href="edite/${users.id}" class="btn btn-warning btn-xs"> Edit</a>
                            <a href="delete/${users.id}" class="btn btn-danger btn-xs"> Delete</a>
                        </td>
                    </tr>
                    <% i++; %> <%-- end loop increment 1 --%>
                </c:forEach >
            </tbody>
        </table>
    </div>
</div>

</body>
</html>