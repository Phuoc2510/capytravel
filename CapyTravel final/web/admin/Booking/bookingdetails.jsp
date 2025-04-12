<%-- 
    Document   : bookingdetails
    Created on : 27-10-2024, 18:30:48
    Author     : phuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Booking/bookingDetail.css">
        <title>Booking Page</title>

    </head>
    <body>

        <jsp:include page="../../adminMenu.jsp" flush="true" /> 

        <h1>Booking Details</h1>         
     

        <div class="container">
            <table>           
                <tr>
                    <th>Booking ID</th>
                    <td>${requestScope.bookingdetail.bookingID}</td>                    
                </tr>
                <tr>
                    <th>User ID</th>                    
                    <td>${requestScope.bookingdetail.userID}</td>                    
                </tr>
                <tr>
                    <th>Full Name</th>      
                    <td>${requestScope.bookingdetail.fullName}</td>                         
                </tr>
                <tr>
                    <th>Departure Flight</th>                    
                    <td>${requestScope.bookingdetail.departureFlight}</td>                    
                </tr>
                <tr>
                    <th>Return Flight</th>                    
                    <td>${requestScope.bookingdetail.returnFlight}</td>                    
                </tr>
                <tr>
                    <th>Booking Date</th>                    
                    <td>${requestScope.bookingdetail.bookingDate}</td>                    
                </tr>
                <tr>
                    <th>Total Amount</th>                    
                    <td>${requestScope.bookingdetail.totalAmount}</td>                    
                </tr>
                <tr>
                    <th>Payment Method</th>                    
                    <td>${requestScope.bookingdetail.paymentMethod}</td>                    
                </tr>
            </table>

            <div  class="form-container">
                <form action="CapyTravelController">
                    <input type="hidden" name="id" value="${requestScope.bookingdetail.bookingID}">
                     <button type="submit" name="action" value="bookingAdminEdit" class="create-button">Edit</button>                 
                </form>
                <form action="CapyTravelController">
                     <button type="submit" name="action" value="bookingAdminBack" class="create-button">Back</button>                   
                </form>
            </div>
        </div>

    </body>
</html>
