<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="User Update">
    <jsp:attribute name="error">${error}</jsp:attribute>
<jsp:attribute name="table">
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="update" method="post">

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">User ID</label>
                    <input class="form-control input-md" type="text" name="userID" value="${user.userID}"
                           id="userID" readonly>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label>User Role</label>
                        <select class="form-control" name="userRole" id="userRole">
                            <option ${user.userRole.equals("Guest")?"selected":""}>Guest</option>
                            <option ${user.userRole.equals("Reader")?"selected":""}>Reader</option>
                            <option ${user.userRole.equals("Librarian")?"selected":""}>Librarian</option>
                            <option ${user.userRole.equals("Admin")?"selected":""}>Admin</option>
                        </select>
                    </fieldset>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">First Name</label>
                    <input class="form-control input-md" type="text" name="firstName" value="${user.firstName}"
                           id="firstName">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Last Name</label>
                    <input class="form-control input-md" type="text" name="lastName" value="${user.lastName}"
                           id="lastName">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Email</label>
                    <input class="form-control input-md" type="email" name="email" value="${user.email}"
                           id="email">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Phone</label>
                    <input class="form-control input-md" type="text" name="phoneNumber"
                           value="${user.phoneNumber}" id="phoneNumber">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Password</label>
                    <input class="form-control input-md" type="password" name="password" value="${user.password}"
                           id="password">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Confirm Password</label>
                    <input class="form-control input-md" type="password" name="confirmPassword"
                           value="${user.password}" id="confirmPassword">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">City</label>
                    <input class="form-control input-md" type="text" name="cityName" value="${user.cityName}"
                           id="cityName">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Street</label>
                    <input class="form-control input-md" type="text" name="streetName"
                           value="${user.streetName}" id="streetName">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">House Number</label>
                    <input class="form-control input-md" type="text" name="houseNumber"
                           value="${user.houseNumber}" id="houseNumber">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Flat Number</label>
                    <input class="form-control input-md" type="text" name="flatNumber"
                           value="${user.flatNumber}" id="flatNumber">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <input type="hidden" class="form-control input-md" name="addressID"
                           value="${user.addressID}" id="addressID">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <input class="form-control input-md" type="hidden" name="documentID"
                           value="${user.documentID}" id="documentID">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label>Document Type</label>
                        <select class="form-control" name="documentType" id="documentType">
                            <option ${user.documentType.equals("Passport")?"selected":""}>Passport</option>
                            <option ${user.documentType.equals("Driving licence")?"selected":""}>Driving licence</option>
                        </select>
                    </fieldset>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Series</label>
                    <input class="form-control input-md" type="text" name="series" value="${user.series}"
                           id="series">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Number</label>
                    <input class="form-control input-md" type="text" name="number" value="${user.number}"
                           id="number">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Issued By</label>
                    <input class="form-control input-md" type="text" name="issuedBy" value="${user.issuedBy}"
                           id="issuedBy">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Data Of Issue</label>
                    <input class="form-control input-md" type="text" name="dateOfIssue"
                           value="${user.dateOfIssue}" id="dateOfIssue">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">User Karma</label>
                    <input class="form-control input-md" type="text" name="karma" value="${user.karma}" id="karma">
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
    <jsp:attribute name="action">admin</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>