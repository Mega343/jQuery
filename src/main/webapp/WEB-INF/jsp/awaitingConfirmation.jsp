<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Admin Library">
    <jsp:attribute name="tableName">Users awaiting confirmation</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="table">

        <thead>
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Phone number</th>
            <th>Karma</th>
            <th>Role</th>
            <th>Document</th>
            <th>Address</th>
            <th>Confirm</th>
        </tr>
        </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td><c:out value="${user.userID}"/></td>
                            <td><c:out value="${user.firstName}"/></td>
                            <td><c:out value="${user.lastName}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.phoneNumber}"/></td>
                            <td><c:out value="${user.karma}"/></td>
                            <td><c:out value="${user.role.userRole}"/></td>
                            <td>
                                <form action="document">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-info">Document</button>
                                </form>
                            </td>
                            <td>
                                <form action="address">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-info">Address</button>
                                </form>
                            </td>
                            <td>
                                <form action="awaiting_confirmation" method="post">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-warning">Confirm</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
    </jsp:attribute>
    <jsp:attribute name="action">admin</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>
