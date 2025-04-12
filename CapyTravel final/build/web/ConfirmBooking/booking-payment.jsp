<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/ConfirmBooking/Booking_Payment.css">
        <title>Payment Interface</title>

    </head>
    <body>
        <div class="container">
            <!-- Left Section -->
            <div class="left-section">
                <form action="CapyTravelController" method="POST">

                    <h2>How would you like to pay?</h2>
                    <div class="payment-method" >

                        <!-- Bank Transfer Option -->
                        <label class="payment-option">
                            <input type="radio" name="payment" value="bank-transfer" required>
                            <img src="https://img.icons8.com/ios-filled/50/000000/bank.png" alt="Bank Icon">
                            Bank Transfer
                        </label>

                        <!-- E-Wallet Option -->
                        <label class="payment-option">
                            <input type="radio" name="payment" value="e-wallet" required>
                            <img src="https://img.icons8.com/ios-filled/50/000000/wallet.png" alt="Wallet Icon">
                            Other E-Wallets
                        </label>
                    </div>

                    <div class="total-price">
                        Total Price: 2,000,000 VND
                    </div>

                    <button name="action" value="PayandShowQR" class="pay-button">Pay & Show QR Code</button>
                </form>

            </div>
            <!-- Right Section (Flight Summary) -->
            <div class="right-section">
                <h2>Flight Summary</h2>

                <!-- First Flight Information Table -->
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
