<%-- 
    Document   : flightdetails
    Created on : 27-10-2024, 18:39:58
    Author     : phuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Booking/bookingDetail.css">
        <title>Flight Detail Page</title>

    </head>
    <body>

        <jsp:include page="../../adminMenu.jsp" flush="true" /> 
        <h1>Flight Details</h1>         
        <p> Login user: ${sessionScope.USERNAME}</p>

        <div class="container">
            <table>           
                <tr>
                    <th>Flight ID</th>
                    <td>${requestScope.flightdetail.flightID}</td>                    
                </tr>
                <tr>
                    <th>Flight Code</th>                    
                    <td>${requestScope.flightdetail.flightCode}</td>                    
                </tr>
                <tr>
                    <th>Departure Date</th>      
                    <td>${requestScope.flightdetail.departureDate}</td>                         
                </tr>
                <tr>
                    <th>Departure Airport</th>                    
                    <td>${requestScope.flightdetail.departureAirport}</td>                    
                </tr>
                <tr>
                    <th>Arrival Airport</th>                    
                    <td>${requestScope.flightdetail.arrivalAirport}</td>                    
                </tr>
                <tr>
                    <th>Flight Time</th>                    
                    <td>${requestScope.flightdetail.flightTime}</td>                    
                </tr>
                <tr>
                    <th>Airline ID</th>                    
                    <td>${requestScope.flightdetail.airlineID}</td>                    
                </tr>
                <tr>
                    <th>Active</th>
                    <td>${requestScope.flightdetail.active}</td>
                </tr>
            </table>

            <div  class="form-container">
                <form action="CapyTravelController">
                    <input type="hidden" name="id" value="${requestScope.flightdetail.flightID}">
                    <input type="submit" name="action" value="Edit">
                </form>
                <form action="CapyTravelController">
                    <input type="submit" name="action" value="Back">
                </form>
            </div>
        </div>

    </body>
</html>
