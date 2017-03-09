<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Admin Library">
    <jsp:attribute name="tableName">Books</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="table">

        <thead>
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Author Name</th>
            <th>Publishing House</th>
            <th>Genre</th>
            <th>Year of Issue</th>
            <th>Language</th>
            <th>Book Quantity</th>
            <th>Book in Ware house</th>
            <th>Shelf</th>
            <th>Book Rate</th>
            <th>Number of Readings</th>
            <th>Book Description</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
                    <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td><c:out value="${book.bookID}"/></td>
                            <td><c:out value="${book.bookName}"/></td>
                            <td><c:out
                                    value="${book.author.firstName} ${book.author.lastName} ${book.author.patronymic}"/></td>
                            <td><c:out value="${book.ph.publishingHouseName}"/></td>
                            <td><c:out value="${book.genre.genre}"/></td>
                            <td><c:out value="${book.yearOfIssue}"/></td>
                            <td><c:out value="${book.language.language}"/></td>
                            <td><c:out value="${book.bookQuantity}"/></td>
                            <td><c:out value="${book.bookInWarehouse}"/></td>
                            <td><c:out value="${book.shelf.shelfNumber}"/></td>
                            <td><c:out value="${book.bookRate}"/></td>
                            <td><c:out value="${book.numberOfReadings}"/></td>
                            <td>
                                <form action="book_description" method="post">
                                    <input type="hidden" name="book_description" value="${book.bookDescription}"/>
                                    <button type="submit" class="btn btn-xs btn-info">Book Descript</button>
                                </form>
                            </td>
                            <td>
                                <form action="update_book">
                                    <input type="hidden" name="book_id" value="${book.bookID}"/>
                                    <button type="submit" class="btn btn-xs btn-warning">Update</button>
                                </form>
                            </td>
                            <td>
                                <form action="book_delete">
                                    <input type="hidden" name="book_id" value="${book.bookID}"/>
                                    <button type="submit" class="btn btn-xs btn-danger">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
    </jsp:attribute>
    <jsp:attribute name="action">add_book</jsp:attribute>
    <jsp:attribute name="actionDescription">Add new Book</jsp:attribute>
</t:admin>