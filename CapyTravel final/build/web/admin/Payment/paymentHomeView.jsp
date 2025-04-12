<%-- 
    Document   : paymentHomeView
    Created on : 01-11-2024
    Author     : phuja
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/Payment/paymentDetail.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Management</title>
        <!-- Link to the shared CSS file -->
        <link rel="stylesheet" type="text/css" href="css/adminHomeStyle.css"> 
    </head>
    <body>
        <jsp:include page="../../adminMenu.jsp" flush="true" />

        ${requestScope.bookingdetail.userID}
        <div class="admin-container">
            <h2>Payment Management</h2>
            <form action="CapyTravelController">
                <div class="search-bar">
                    <input type="text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" class="search-input"/>
                    <button type="submit" value="paymentAdminSearch" name="action" class="search-button">Search</button>
<!--                    <button type="submit" value="paymentAdminAdd" name="action" class="create-button">Add Payment</button>-->
                </div>
            </form>

            <table class="flight-table">
                <thead>
                    <tr>
                        <th>Payment ID</th>
                        <th>Booking ID</th>
                        <th>Payment Date</th>
                        <th>Amount</th>
                        <th>Payment Method</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${requestScope.PAYMENT}">
                        <tr>
                            <td>${c.paymentID}</td>
                            <td>${c.bookingID}</td>
                            <td>${c.paymentDate}</td>
                            <td>${c.amount}</td>
                            <td>${c.paymentMethod}</td>
                            <td>
                                <a class="detail-button" href="CapyTravelController?action=paymentAdminEdit&id=${c.bookingID}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
</html>
