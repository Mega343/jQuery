<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" %>
<%@attribute name="tableName" %>
<%@attribute name="error" %>
<%@attribute name="action" %>
<%@attribute name="actionDescription" %>
<%@attribute name="table" fragment="true" %>
<c:url value="/resources/dashboard/dashboard.css" var="cssUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="Arthur Segeda" content="">
    <link rel="icon" href="/resources/images/icon.png">
    <script src="/resources/js/jquery.js"></script>
    <script src="/resources/js/underscore.js"></script>
    <script src="/resources/js/backbone.js"></script>

    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${cssUrl}" type="text/css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">

            <a class="navbar-brand" href="home">Library</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin">Dashboard</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="/logout">Log out</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="admin">Users <span class="sr-only">(current)</span></a></li>
                <li><a href="awaiting_confirmation">Users awaiting confirmation</a></li>
                <li><a href="orders">Orders</a></li>
                <li><a href="books">Books</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">${tableName}</h1>
            <div class="text-center">
                <c:if test="${not empty error}">
                <div class="error" style="color: red">${error}</div>
                </c:if>
            </div>
            <div class="table-responsive">
                    <jsp:invoke fragment="table"/>
            </div>
        </div>
    </div>
</div>

<form class="form-signin" action="${action}" method="get">
    <button class="btn btn-lg btn-success btn-block center-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">
        ${actionDescription}
    </button>
</form>

<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>