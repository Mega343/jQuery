<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:admin title="Admin Library">
    <jsp:attribute name="tableName">User address</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="table">
        <thead>
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>City Name</th>
            <th>Street Name</th>
            <th>House Number</th>
            <th>Flat Number</th>
        </tr>
        </thead>
                    <tbody>
                    <tr>
                        <td>${user.userID}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${address.cityName}</td>
                        <td>${address.streetName}</td>
                        <td>${address.houseNumber}</td>
                        <td>${address.flatNumber}</td>
                    </tr>
                    </tbody>
  </jsp:attribute>
    <jsp:attribute name="action">admin</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>
