<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="Arthur Segeda">
    <link rel="icon" href="/resources/images/icon.png">

    <title>Library</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/signin/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form class="form-signin" action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="j_email" id="inputEmail" class="form-control" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
    <form class="form-signin" action="add_user" method="get">
        <button class="btn btn-lg btn-success btn-block" type="submit">Registration</button>
    </form>
</div>

<div class="text-center">
    <c:if test="${not empty error}">
    <div class="error" style="color: red">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg" style="color: #496bff">${msg}</div>
    </c:if>
    <p>Admin: ivanov@mail.ru / qwerty</p>
    <p>User: sidorov@mail.ru / qwerty12345</p>
</div>

<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
