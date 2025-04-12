<%-- 
    Document   : flightForm
    Created on : Oct 30, 2024, 12:00:14 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Flight/flightForm.css">
        <title>Form Page</title>
    </head>
    <body>

        <jsp:include page="../../adminMenu.jsp" flush="true" /> 

        <% String title = (String) request.getAttribute("pagetitle"); %>
        <% if (title != null) { %>
        <h1>Flight ${requestScope.pagetitle} </h1>
        <%}%>

        <p> Login user: ${sessionScope.USERNAME}</p>

        <form action="CapyTravelController" method="POST">

            <table>

                <c:if test="${requestScope.flightdetail.flightID != null}">
                    <tr>
                        <td>Flight ID</td>
                        <td><input name="id" value="${requestScope.flightdetail.flightID}" readonly /></td>
                    </tr>
                </c:if>

                <tr><td>Flight Code</td><td><input name="flightCode" value="${requestScope.flightdetail.flightCode}" required></td></tr>
                <tr><td>Departure Date</td><td><input type="date" name="departureDate" value="${requestScope.flightdetail.departureDate}" required></td></tr>
                <tr><td>Departure Airport</td><td><input name="departureAirport" value="${requestScope.flightdetail.departureAirport}" required></td></tr>
                <tr><td>Arrival Airport</td><td><input name="arrivalAirport" value="${requestScope.flightdetail.arrivalAirport}" required></td></tr>
                <tr><td>Flight Time</td><td><input type="time" name="flightTime" value="${requestScope.flightdetail.flightTime}" required></td></tr>		 
                <tr><td>Airline ID</td><td><input name="airlineID" value="${requestScope.flightdetail.airlineID}" required></td></tr>	

                <tr><td>Active</td><td><select name="active">
                            <option value="1" ${requestScope.flightdetail.active == "1" ? "selected" : ""}>Available</option>
                            <option value="0" ${requestScope.flightdetail.active == "0" ? "selected" : ""}>Not Available</option>
                        </select></td>
                </tr>		 
                <tr>
                    <td>
                        <input name="action" value="${requestScope.flightaction}" type="hidden">
                        <input type=submit value=Save>
                    </td>
                </tr>

            </table>

        </form>

    </body>
</html>
