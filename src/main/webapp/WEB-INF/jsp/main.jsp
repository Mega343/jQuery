<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main title="Gratest Library">
<jsp:attribute name="center">
<!-- Carousel\n" +
"    ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide" src="/resources/carousel/library.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Greatest Library.</h1>
                    <p>More than 10,000 books. Join us.</p>
                    <p><a class="btn btn-lg btn-primary" href="/add_user" role="button">Sign up today</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide" src="/resources/carousel/readarea.jpeg" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>The best place in the world.</h1>
                    <p>More than 500 reading places with great lighting. As well as 50 computers for Internet
                        access.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="/resources/carousel/books2.jpg" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>You will find everything you are looking for.</h1>
                    <p>All books. All genres. All authors. All publishing houses. All in Greatest Library.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->
</jsp:attribute>
</t:main>