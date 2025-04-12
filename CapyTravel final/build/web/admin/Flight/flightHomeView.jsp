<%-- 
    Document   : flightList
    Created on : Oct 29, 2024, 3:00:12 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/adminHomeStyle.css"> 
        <title>Flight List Page</title>
    </head>
    <body>
        <!-- Navigation Bar -->
        <jsp:include page="../../adminMenu.jsp" flush="true" /> 

        <!-- Flight Management Section -->
        <div class="container">
            <h2>Flight Management</h2>

            <div class="form-container">
                <form action="CapyTravelController"method="GET" class="search-form">
                    <input type="text" name="keyword" value="<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" 
                           class="search-input">
                    <input type="submit" name="action" value="Search" class="search-button">
                </form>
                <form action="CapyTravelController" method="POST">

                    <input type="submit" name="action" value="Create" class="create-button" >
                </form> 
            </div>


            <table class="flight-table">
                <thead>
                    <tr>
                        <th>Flight ID</th>
                        <th>Flight Code</th>
                        <th>Departure Date</th>
                        <th>Active</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="list" items="${requestScope.flightlist}">
                        <tr>
                            <td>${list.flightID}</td>
                            <td>${list.flightCode}</td>
                            <td>${list.departureDate}</td>


                            <td>  
                                <c:choose>
                                    <c:when test="${list.active == 1}">Available</c:when>
                                    <c:otherwise>Not Available</c:otherwise>
                                </c:choose>
                            </td>
                            <td style="display: flex; gap: 10px;">
                                <form action="CapyTravelController" method="POST" class="action-form">
                                    <input type="hidden" name="id" value="${list.flightID}">
                                    <input type="submit" name="action" value="Detail" class="detail-button">
                                </form>

                                <form action="CapyTravelController" method="POST" class="action-form">
                                    <input type="hidden" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>">
                                    <input type="hidden" name="id" value="${list.flightID}"/>
                                    <input type="submit" name="action" value="Delete" class="delete-button">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>

        </div>   

    </body>
</html>
