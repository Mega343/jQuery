<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" %>
<%@attribute name="center" fragment="true" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Arthur Segeda">
    <link rel="icon" href="/resources/images/icon.png">

    <title>${title}</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="/resources/carousel/carousel.css" rel="stylesheet">
</head>

<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/home">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            Search book <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Search book by name</a></li>
                            <li><a href="#">Search book by author</a></li>
                            <li><a href="#">Search book by genre</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">Rating</li>
                            <li><a href="#">Search by rate</a></li>
                            <li><a href="#">Search by readings</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Profile</a></li>
                    <li><a href="/logout">Log out</a></li>
                </ul>
            </div>
        </nav>

    </div>
</div>

<jsp:invoke fragment="center"/>

<!-- Marketing messaging and featurettes-->

<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 Segeda Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

</div><!-- /.container -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>