<%-- 
    Document   : airlinedetails
    Created on : 27-10-2024, 18:29:16
    Author     : phuja
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Airline</title>
        <link rel="stylesheet" type="text/css" href="css/adminHomeStyle.css"> 
    </head>
    <body class="admin-body">

        <jsp:include page="../../adminMenu.jsp" flush="true" /> 
        <div class="admin-container">
            <h2>Management Airline</h2>
            <div class="form-container">
                <form action="CapyTravelController" method="POST" class="search-form">
                    <input name="keyword" class="search-input" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" type="text" placeholder="Search..." />
                    <button  class="search-button" name="action" type="submit" value="airlineAdminSearch">Search</button>
                </form>
                <form action="CapyTravelController" method="POST">
                    <button name="action" class="create-button" type="submit" value="airlineAdminInsert">Add Airline</button>
                </form>
            </div>

            <table class="flight-table">
                <thead>
                    <tr>
                        <th>Airline ID</th>
                        <th>Airline Name</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${requestScope.LIST_AIRLINE}">
                        <tr>
                            <td>${c.airlineID}</td>
                            <td>${c.airlineName}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${c.airlineStatus}">Available</c:when>
                                    <c:otherwise>Not Available</c:otherwise>
                                </c:choose>
                            </td>



                            <td style="display: flex; gap: 10px;">
                                <form class="actions" action="CapyTravelController" method="GET">
                                    <input name="airlineID" value="${c.airlineID}" type="hidden">
                                    <input name="airlineName" value="${c.airlineName}" type="hidden">
                                    <input name="airlineStatus" value="${c.airlineStatus}" type="hidden">
                                    <button class="detail-button" name="action" type="submit" value="airlineAdminEdit">Edit</button>
                                </form>

                                <form class="action-form" action="CapyTravelController" method="GET">
                                    <input name="airlineID" value="${c.airlineID}" type="hidden">
                                    <button class="delete-button" name="action" type="submit" value="airlineAdminDelete">Delete</button>
                                </form>

                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>    
    </body>
</html>
