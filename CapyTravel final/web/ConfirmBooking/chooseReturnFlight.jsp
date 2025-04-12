<%@page import="capytravel.flights.FlightsDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Flight Booking</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/ConfirmBooking/ChooseFlight.css">
    </head>
    <body>
        <div class="container">
            <div class="header">

                <div>
                    <h1>${sessionScope.FLIGHT_DETAILS_RETURN.departureAirport} -> ${sessionScope.FLIGHT_DETAILS_RETURN.arrivalAirport}</h1>
                    <p>${FLIGHT_DETAILS_RETURN.departureDate} | 1 Passenger | Economy</p>
                </div>



            </div>
        </div>




        <div class="flight-list"> 

            <c:forEach var="f" items="${sessionScope.CHOOSE_FLIGHT_RERURN}">
                <div class="flight-option">   
                    <div class="flight-details">                   
                        <div>
                            <p class="airline">${f.airlineID}</p>
                        </div>



                        <div>
                            <p class="time">${f.flightTime}</p>
                            <div class="location">
                                <p>${f.departureAirport} -> ${f.arrivalAirport}</p>
                            </div>
                        </div>                        
                    </div>    


                    <form action="CapyTravelController" method="post">
                        <input type="hidden" name="userid" value="${sessionScope.CHECK_LOGIN.userID}" />
                        <input type="hidden" name="airlinereturn" value="${f.airlineID}" />
                        <input type="hidden" name="airlinedeparture" value="${param.airlinedeparture}" />
                        <input type="hidden" name="flightTimeDeparture" value="${requestScope.FLIGHT_TIME_DEPARTURE}" />
                        <input type="hidden" name="flightTimeReturn" value="${f.flightTime}" />
                        <input type="hidden" name="flightIDReturn" value="${f.flightID}" />
                        <input type="hidden" name="flightIDDeparture" value="${param.flightIDDeparture}">

                        <button type="submit" name="action" value="bookingFlightChoose" class="choose-button">Choose</button> 
                    </form>                   
                </div>


            </c:forEach>
        </div>



    </body>

</html>