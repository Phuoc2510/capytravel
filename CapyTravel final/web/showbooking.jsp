<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Booking List</title>
        <link rel="stylesheet" href="css/showbook.css">
    </head>
    <body>
        
         <%@include file="usermenu.jsp" %>
         
        <div class="container">
            <h1>Your Booking</h1>
            <table class="booking-table">
                <thead>
                    <tr>
                        <th>Departure Flight</th>
                        <th>Return Flight</th>
                        <th>Booking Date</th>
                        <th>Total Amount</th>
                        <th>Payment Method</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${requestScope.BOOKINGSHOW}" >
                        <tr>
                            <td>${c.departureFlight}</td>
                            <td>${c.returnFlight}</td>
                            <td>${c.bookingDate}</td>
                            <td>${c.totalAmount}</td>
                            <td>${c.paymentMethod}</td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>

            <!-- Nút Back -->
            <div class="button-container">
                <a href="CapyTravelController?action=userCancelProfile" class="back-button">Back to Home</a>
            </div>
        </div>
         
          <%@include file="homefooter.jsp" %>
          
    </body>
    <!--them cai nay-->
<script src="js/nothomepage.js"></script>
</html>
