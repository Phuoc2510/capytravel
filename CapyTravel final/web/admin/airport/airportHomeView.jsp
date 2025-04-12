<%-- 
    Document   : editairport
    Created on : 27-10-2024, 18:29:16
    Author     : phuja
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Airport</title>
        <!-- Link to the shared CSS file -->
        <link rel="stylesheet" type="text/css" href="css/adminHomeStyle.css"> 
    </head>
    <body>
        <jsp:include page="../../adminMenu.jsp" flush="true" />

        <div class="admin-container">
            <h2>Management Airport</h2>
            <form action="CapyTravelController">
                <div class="search-bar">
                    <input type="text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" class="search-input"/>
                    <button type="submit" value="airportAdminSearch" name="action" class="search-button">Search</button>
                    <button type="submit" value="airportAdminAdd" name="action" class="create-button">Add Airport</button>
                </div>
            </form>

            <table class="flight-table">
                <thead>
                    <tr>
                        <th>Airport ID</th>
                        <th>Airport Name</th>
                        <th>Location</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${requestScope.AIRPORT}">
                        <tr>
                            <td>${c.airportID}</td>
                            <td>${c.airportName}</td>
                            <td>${c.location}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${c.status == 1}">Available</c:when>
                                    <c:otherwise>Not Available</c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a class="detail-button" href="CapyTravelController?action=airportAdminEdit&id=${c.airportID}">Edit</a>
                                <a class="delete-button" href="CapyTravelController?action=airportAdminDelete&keyword=<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>&id=${c.airportID}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
