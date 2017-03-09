<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Orders Library">
    <jsp:attribute name="tableName">Orders</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="table">

        <thead>
        <tr>
            <th>Order ID</th>
            <th>Customer First Name</th>
            <th>Customer Last Name</th>
            <th>Customer E-mail</th>
            <th>Customer Phone number</th>
            <th>Librarian First Name</th>
            <th>Librarian Last Name</th>
            <th>Book Name</th>
            <th>Order Date</th>
            <th>Expected Return Date</th>
            <th>Actual Return Date</th>
            <th>Order Type</th>
            <th>Close Order</th>
        </tr>
        </thead>
                    <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td><c:out value="${order.orderID}"/></td>
                            <td><c:out value="${order.user.firstName}"/></td>
                            <td><c:out value="${order.user.lastName}"/></td>
                            <td><c:out value="${order.user.email}"/></td>
                            <td><c:out value="${order.user.phoneNumber}"/></td>
                            <td><c:out value="${order.librarian.firstName}"/></td>
                            <td><c:out value="${order.librarian.lastName}"/></td>
                            <td><c:out value="${order.book.bookName}"/></td>
                            <td><c:out value="${order.orderDate}"/></td>
                            <td><c:out value="${order.expectedReturnDate}"/></td>
                            <td><c:out value="${order.actualReturnDate}"/></td>
                            <td><c:out value="${order.orderType.orderType}"/></td>
                            <td>
                                <c:if test="${order.actualReturnDate == null}">
                                    <form action="close">
                                        <input type="hidden" name="order_id" value="${order.orderID}"/>
                                        <button type="submit" class="btn btn-xs btn-danger">Close order</button>
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
    </jsp:attribute>
    <jsp:attribute name="action">add_order</jsp:attribute>
    <jsp:attribute name="actionDescription">Add new Order</jsp:attribute>
</t:admin>

