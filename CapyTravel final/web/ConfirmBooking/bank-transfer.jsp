<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/ConfirmBooking/Bank_Transfer.css">
        <script src="../js/ConfirmBooking/Bank_Transfer.js" defer></script>
        <title>Bank Transfer Interface</title>

    </head>
    <body>
       <div class="container">
            <!-- Left Section -->
            <div class="left-section">
                <h2>Please Transfer to:</h2>

                <!-- Vietcombank Payment Fields -->
                <div id="vietcombank-fields" class="payment-summary">
                    <h2 id="VCB" >Vietcombank</h2>
                    <div class="bank-qr">
                        <label for="qr-code">CapyTravel Company</label>
                        <img src="imgs/QR_Code/Vietcombank.jpg">
                    </div>

                    <div class="important-notes">
                        IMPORTANT NOTES!<br>
                        1. Please transfer the exact amount (including the last 3 digits unique code).<br>
                        2. Choose the Fast Payment method if you transfer from a bank other than Vietcombank.
                    </div>
                </div>
                <form action="CapyTravelController" method="POST">
                    <div class="completed-payment">
                        <p>Completed your payment?</p>
                        <input type="hidden" name="methodID" value="VCB" />
                        <button type="submit" name="action" value="bookingPayConfirm" onclick="handlePayment()">Yes, I Have Paid</button>
                </form>
            </div>

        </div>


        <div class="right-section">
            <h2>Flight Summary</h2>


            <div class="flight-table">
                <h3>${sessionScope.FLIGHT_DETAILS.departureAirport} ? ${sessionScope.FLIGHT_DETAILS.arrivalAirport}</h3>
                <p>${sessionScope.AIRLINE_DEPARTURER} - Promo</p>
                <p>${FLIGHT_DETAILS.departureDate}</p>
            </div>


            <div class="flight-table">
                <h3>${sessionScope.FLIGHT_DETAILS.arrivalAirport} ? ${sessionScope.FLIGHT_DETAILS.departureAirport}</h3>
                <p>${sessionScope.AIRLINE_RETURNR} - Promo</p>
                <p>${FLIGHT_DETAILS_RETURN.departureDate}</p>
            </div>

        </div>
    </div>

</body>
</html>
