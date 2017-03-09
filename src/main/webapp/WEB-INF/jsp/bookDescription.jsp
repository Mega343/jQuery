<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Admin Library">
    <jsp:attribute name="tableName">Book Description</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="table">
        <div class="text-center">
            <p readonly="">${book_description}</p>
        </div>
            </jsp:attribute>
    <jsp:attribute name="action">books</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>