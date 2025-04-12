<%-- 
    Document   : editbooking
    Created on : 27-10-2024, 18:31:46
    Author     : phuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Flight/flightForm.css">
        <title>Booking Page</title>

    </head>
    <body>

        <jsp:include page="../../adminMenu.jsp" flush="true" /> 

        <% String title = (String) request.getAttribute("pagetitle"); %>
        <% if (title != null) { %>
        <h1>Booking ${requestScope.pagetitle} </h1>
        <%}%>

      

        <form action="CapyTravelController" method="POST">

            <table>

                <c:if test="${requestScope.bookingdetail.bookingID != null}">
                    <tr>
                        <td>Booking ID</td>
                        <td><input name="id" value="${requestScope.bookingdetail.bookingID}" readonly /></td>
                    </tr>
                </c:if>

                <tr><td>User ID</td><td><input name="userid" value="${requestScope.bookingdetail.userID}" required></td></tr>
                <tr><td>Departure Flight</td><td><input name="departureFlight" value="${requestScope.bookingdetail.departureFlight}" required></td></tr>
                <tr><td>Return Flight</td><td><input name="returnFlight" value="${requestScope.bookingdetail.returnFlight}" ></td></tr>
                <tr><td>Booking Date</td><td><input type=date name="bookingDate" value="${requestScope.bookingdetail.bookingDate}" required></td></tr>
                <tr><td>Total Amount</td><td><input name="totalAmount" value="${requestScope.bookingdetail.totalAmount}" required></td></tr>
                <tr>
                    <td>Payment Method</td>
                    <td>
                        <select name="paymentMethod">
                            <option value="Vietcombank" ${requestScope.bookingdetail.paymentMethod == 'Vietcombank' ? 'selected' : ''}>Vietcombank</option>
                            <option value="MoMo" ${requestScope.bookingdetail.paymentMethod == 'MoMo' ? 'selected' : ''}>MoMo</option>
                            <option value="ShopeePay" ${requestScope.bookingdetail.paymentMethod == 'ShopeePay' ? 'selected' : ''}>ShopeePay</option>
                            <option value="ZaloPay" ${requestScope.bookingdetail.paymentMethod == 'ZaloPay' ? 'selected' : ''}>ZaloPay</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        <input name="action" value="${requestScope.bookingaction}" type="hidden">
                        <button type=submit value=Save class="create-button">Save</button>
                    </td>
                </tr>

            </table>

        </form>

    </body> 
</html>
