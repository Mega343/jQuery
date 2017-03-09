<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<c:url value="/resources/js/jquery.js" var="jqueryJsUrl"/>
<script src="${jqueryJsUrl}"></script>
<c:url value="/resources/js/underscore.js" var="underscoreJsUrl"/>
<script src="${underscoreJsUrl}"></script>
<c:url value="/resources/js/backbone.js" var="backboneJsUrl"/>
<script src="${backboneJsUrl}"></script>

    <title>Users</title>


    <!-- Bootstrap core CSS -->
    <c:url value="/resources/css/bootstrap.min.css" var="bootstrapCssUrl"/>
    <link href="${bootstrapCssUrl}" rel="stylesheet">
    <!-- Custom styles for this template -->
    <c:url value="/resources/dashboard/dashboard.css" var="dashboardCssUrl"/>
    <link href="${dashboardCssUrl}" type="text/css" rel="stylesheet">

        <script type="text/template" id="users">
        <table class="table">
            <thead>
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-mail</th>
                <th>Phone number</th>
                <th>Karma</th>
                <th>Role</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>

            <@ _.each(users, function(user) { @>
            <tr>
                <td><@= user.userID @></td>
                <td><@= user.firstName @></td>
                <td><@= user.lastName @></td>
                <td><@= user.email @></td>
                <td><@= user.phoneNumber @></td>
                <td><@= user.role.userRole @></td>
                <td><@= user.karma @></td>

                <td>
                    <a href="#editUser/<@= user.userID @>">Edit</a>
                </td>

                <td>
                <a href="#deleteUser/<@= user.userID @>">Delete</a>
                </td>
            </tr>
            <@ }); @>
            </tbody>
        </table>
        </script>

    <script type="text/template" id="addUser">
        <div class="" data-example-id="basic-forms">
            <form>
                <div class="form-group">
                    <label for="firstName">First Name</label> <textarea class="form-control" rows="1" id="firstName"></textarea>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label> <textarea class="form-control" rows="1" id="lastName"></textarea>
                </div>
                <div class="form-group">
                    <label for="email">Email</label> <textarea class="form-control" rows="1" id="email"></textarea>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label> <textarea class="form-control" rows="1" id="phoneNumber"></textarea>
                </div>
                <div class="form-group">
                    <label for="password">Password</label> <textarea class="form-control" rows="1" id="password"></textarea>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm password</label> <textarea class="form-control" rows="1" id="confirmPassword"></textarea>
                </div>

                <button type="submit" id="addSbmt" class="btn btn-success">Add</button>
            </form>
        </div>
    </script>

    <script type="text/template" id="editUser">
        <div class="" data-example-id="basic-forms">
            <form>
                <input type="hidden" id="userID" value="<@= user.userID @>">
                <div class="form-group">
                    <label for="firstName">First name</label> <textarea class="form-control" rows="1" id="firstName"><@= user.firstName @></textarea>
                </div>
                <div class="form-group">
                    <label for="lastName">Last name</label> <textarea class="form-control" rows="1" id="lastName"><@= user.firstName @></textarea>
                </div>
                <div class="form-group">
                    <label for="email">Email</label> <textarea class="form-control" rows="1" id="email"><@= user.email @></textarea>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label> <textarea class="form-control" rows="1" id="phoneNumber"><@= user.phoneNumber @></textarea>
                </div>
                <div class="form-group">
                    <label for="password">password</label> <textarea class="form-control" rows="1" id="password"><@= user.password @></textarea>
                </div>
                <div class="form-group">
                    <label for="password">Confirm Password</label> <textarea class="form-control" rows="1" id="confirmPassword"><@= user.password @></textarea>
                </div>
                <div class="form-group">
                    <label for="cityName">City Name</label> <textarea class="form-control" rows="1" id="cityName"><@= user.cityName @></textarea>
                </div>
                <div class="form-group">
                    <label for="streetName">Street Name</label> <textarea class="form-control" rows="1" id="streetName"><@= user.streetName @></textarea>
                </div>
                <div class="form-group">
                    <label for="houseNumber">House Number</label> <textarea class="form-control" rows="1" id="houseNumber"><@= user.houseNumber @></textarea>
                </div>
                <div class="form-group">
                    <label for="flatNumber">Flat Number</label> <textarea class="form-control" rows="1" id="flatNumber"><@= user.flatNumber @></textarea>
                </div>
                <div class="form-group">
                    <label for="addressID">Address ID</label> <textarea readonly class="form-control" rows="1" id="addressID"><@= user.addressID @></textarea>
                </div>
                <div class="form-group">
                    <label for="documentID">Document ID</label> <textarea readonly class="form-control" rows="1" id="documentID"><@= user.documentID @></textarea>
                </div>
                <div class="form-group">
                    <label for="documentType">Document Type</label> <textarea class="form-control" rows="1" id="documentType"><@= user.documentType @></textarea>
                </div>
                <div class="form-group">
                    <label for="series">series</label> <textarea class="form-control" rows="1" id="series"><@= user.series @></textarea>
                </div>
                <div class="form-group">
                    <label for="number">Number</label> <textarea class="form-control" rows="1" id="number"><@= user.number @></textarea>
                </div>
                <div class="form-group">
                    <label for="issuedBy">issued By</label> <textarea class="form-control" rows="1" id="issuedBy"><@= user.issuedBy @></textarea>
                </div>
                <div class="form-group">
                    <label for="dateOfIssue">dateOfIssue</label> <textarea class="form-control" rows="1" id="dateOfIssue"><@= user.dateOfIssue @></textarea>
                </div>
                <div class="form-group">
                    <label for="karma">karma</label> <textarea class="form-control" rows="1" id="karma"><@= user.karma @></textarea>
                </div>
                <div class="form-group">
                    <label for="userRole">User role</label> <textarea class="form-control" rows="1" id="userRole"><@= user.userRole @></textarea>
                </div>

                <button type="submit" id="updateSbmt" class="btn btn-success">Update</button>
            </form>
        </div>
    </script>
    <c:url value="/resources/js/task.js" var="taskJsUrl"/>
    <script src="${taskJsUrl}"></script>
</head>

<body>

<br>
<div class="container">
    <div class="row">
        <div class="span2">
            <ul class="nav nav-pills nav-stacked">
                <li class="users"><a href="#users">Users</a></li>
                <li class="addUser"><a href="#addUser">Add user</a></li>
            </ul>
        </div>
        <div class="span8">
            <div class="content"></div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJsUrl"/>
<script src="${bootstrapJsUrl}"></script>
</body>
</html>