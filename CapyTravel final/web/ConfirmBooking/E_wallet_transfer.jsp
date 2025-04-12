<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bank Transfer Interface</title>
        <link rel="stylesheet" type="text/css" href="css/ConfirmBooking/E_Wallet.css">
        <script src="js/ConfirmBooking/E_Wallet.js" defer></script>

    </head>
    <body>
       <div class="container">
            <!-- Left Section -->
            <div class="left-section">
                <h2>Please transfer to:</h2>
                <form action="CapyTravelController" method="Post">
                    <!-- Bank Selection -->
                    <div class="bank-selection">
                        <label for="bank">Choose an E_Wallet:</label>
                        <select name="methodID" id="bank" onchange="updatePaymentFields()">
                            <option hidden>Select option</option>
                            <option value="ZP">Zalopay</option>
                            <option value="MM">Momo</option>
                            <option value="SP">Shopee Pay</option>
                        </select>
                    </div>

                    <!-- QR Code Inputs for Other Banks -->
                    <div id="other-banks-fields" style="display: none;">
                        <div class="bank-qr">
                            <label for="qr-code">Scan the QR Code to Pay</label>
                            <input type="file" accept="image/*" />
                        </div>
                    </div>

                    <!-- Images for Different Wallets -->
                    <div class="wallet-images" style="text-align: center; margin-top: 20px;">
                        <img id="zalopay-image" class="wallet-image" width="260px" src="../imgs/QR_Code/Zalo.jpg" alt="Zalopay QR Code">
                
                        <img id="momo-image" class="wallet-image" width="260px" src="../imgs/QR_Code/MoMo.jpg" alt="Momo QR Code">
                    
                        <img id="shopee-pay-image" class="wallet-image" width="260px" src="../imgs/QR_Code/Shopee.jpg" alt="Shopee Pay QR Code">

                    </div>

                    <div class="completed-payment" style="text-align: center; margin-top: 30px;">
                        <p>Completed your payment?</p>

                        <button name="action" value="bookingPayConfirm" onclick="handlePayment()">Yes, I Have Paid</button>
                </form>
            </div>
        </div>

        <!-- Right Section (Flight Summary) -->
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
