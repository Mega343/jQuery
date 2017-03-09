<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Website CSS style -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Website Font style -->
    <link rel="icon" href="/resources/images/icon.png">
    <link rel="stylesheet" href="/resources/signin/signin.css">
    <title>Registration</title>
</head>
<body>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Sign up. All fields are required.</h3>
                    <c:if test="${not empty error}">
                        <div class="error" style="color: red">${error}</div>
                    </c:if>
                </div>
                <div class="panel-body">
                    <form role="form" action="registration" method="post">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="firstName" id="firstName" class="form-control input-sm"
                                           placeholder="First Name">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="lastName" id="lastName" class="form-control input-sm"
                                           placeholder="Last Name">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm"
                                   placeholder="Email Address">
                        </div>
                        <div class="form-group">
                            <input type="phone_number" name="phoneNumber" id="phoneNumber"
                                   class="form-control input-sm" placeholder="Phone number">
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm"
                                           placeholder="Password">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="confirmPassword" id="confirmPassword"
                                           class="form-control input-sm" placeholder="Confirm Password">
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="Register" class="btn btn-info btn-block">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>