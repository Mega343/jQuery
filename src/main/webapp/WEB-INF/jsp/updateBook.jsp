<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Book Update">
    <jsp:attribute name="error">${error}</jsp:attribute>
<jsp:attribute name="table">
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="update_book" method="post">
        <p style="color: red">${error}</p>
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book ID</label>
                    <input class="form-control input-md" type="text" name="bookID" value="${book.bookID}"
                           id="bookID" readonly>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book Name</label>
                    <input class="form-control input-md" type="text" name="bookName" value="${book.bookName}"
                           id="bookName">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-8 col-sm-8 col-md-8">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Author</label>
                    <input class="form-control input-md" type="text" name="firstName"
                           value="${book.firstName} ${book.lastName} ${book.patronymic}"
                           id="firstName">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Publishing House</label>
                    <input class="form-control input-md" type="text" name="publishingHouseName"
                           value="${book.publishingHouseName}"
                           id="publishingHouseName">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Genre</label>
                    <input class="form-control input-md" type="text" name="genre" value="${book.genre}"
                           id="genre">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Year of Issue</label>
                    <input class="form-control input-md" type="text" name="yearOfIssue" value="${book.yearOfIssue}"
                           id="yearOfIssue">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Language</label>
                    <input class="form-control input-md" type="text" name="language"
                           value="${book.language}" id="language">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book quantity</label>
                    <input class="form-control input-md" type="text" name="bookQuantity" value="${book.bookQuantity}"
                           id="bookQuantity">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book in Warehouse</label>
                    <input class="form-control input-md" type="text" name="bookInWarehouse"
                           value="${book.bookInWarehouse}" id="bookInWarehouse">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Shelf</label>
                    <input class="form-control input-md" type="text" name="shelfNumber"
                           value="${book.shelfNumber}"
                           id="shelfNumber">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book Description</label>
                    <input class="form-control input-md" type="text" name="bookDescription"
                           value="${book.bookDescription}" id="bookDescription">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book Rate</label>
                    <input class="form-control input-md" type="text" name="bookRate"
                           value="${book.bookRate}" id="bookRate">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Number of Readings</label>
                    <input class="form-control input-md" type="text" name="numberOfReadings"
                           value="${book.numberOfReadings}" id="numberOfReadings">
                </div>
            </div>
        </div>


        <div class="form-group row">
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">Update
            </button>
        </div>
    </form>
</div>
</jsp:attribute>
    <jsp:attribute name="action">books</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>