<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Admin Library">
    <jsp:attribute name="tableName">Users</jsp:attribute>
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
            <th>Update</th>
            <th>Delete</th>
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
                                <form action="document" method="get">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-info">Document</button>
                                </form>
                            </td>
                            <td>
                                <form action="address" method="get">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-info">Address</button>
                                </form>
                            </td>
                            <td>
                                <form action="update_user" method="get">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-warning">Update</button>
                                </form>
                            </td>
                            <td>
                                <form action="delete" method="get">
                                    <input type="hidden" name="user_id" value="${user.userID}"/>
                                    <button type="submit" class="btn btn-xs btn-danger">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
    </jsp:attribute>
    <jsp:attribute name="action">add_user</jsp:attribute>
    <jsp:attribute name="actionDescription">Add new User</jsp:attribute>
</t:admin>

