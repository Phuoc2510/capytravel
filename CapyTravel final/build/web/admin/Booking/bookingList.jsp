<%-- 
    Document   : bookingmanagement
    Created on : 27-10-2024, 18:38:07
    Author     : phuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Booking/bookingList.css">
        <title>Booking Page</title>

    </head>
    <body>

        <jsp:include page="../../adminMenu.jsp" flush="true" /> 
        <div class="container">
            <h2 style="font-size: 50px; text-align: center;">Booking Management</h2>
            <div class="form-container">
                <form action="CapyTravelController"method="GET" class="search-form">
                    <input type="text" name="keyword" value="<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" 
                           class="search-input">
                    <button type="submit" value="bookingAdminSearch" name="action" class="search-button">Search</button>
                </form>

<!--                <form action="CapyTravelController" method="POST">
                    <button type="submit" value="bookingAdminCreate" name="action" class="create-button">Create</button>
                </form> -->
            </div>

            <table class="booking-table">
                <thead>
                    <tr>
                        <th>Booking ID</th>
                        <th>Full Name</th>
                        <th>Departure Flight</th>
                        <th>Return Flight</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="list" items="${requestScope.bookinglist}">
                        <tr>
                            <td>${list.bookingID}</td>
                            <td>${list.fullName}</td>
                            <td>${list.departureFlight}</td>
                            <td>${list.returnFlight}</td>
                            <td>
                                <form action="CapyTravelController" method="POST" class="action-form">
                                    <input type="hidden" name="id" value="${list.bookingID}">
                                    <button type="submit" name="action" value="bookingAdminDetail" class="detail-button">Detail</button>
                                </form>

                                <form action="CapyTravelController" method="POST" class="action-form">
                                    <input type="hidden" name="id" value="${list.bookingID}">
                                    <!--                                    <button type="submit" name="action" value="bookingAdminDelete" class="delete-button">Delete</button>-->
                                </form>

                            </td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>

        </div>  

    </body>
</html>
