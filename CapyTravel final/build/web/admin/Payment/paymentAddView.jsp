<%-- 
    Document   : paymentAddView
    Created on : 01-11-2024
    Author     : phuja
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Payment</title>
        
    </head>
    <body>
         <div class="form-container">
        <h2>Add Payment</h2>
        <form action="CapyTravelController" method="POST">
            <div class="form-group">
                <label>Booking ID</label>
                <input type="number" name="bookingID" required>
            </div>

            <div class="form-group">
                <label>Payment Date</label>
                <input type="date" name="paymentDate" required>
            </div>

            <div class="form-group">
                <label>Amount</label>
                <input type="number" name="amount" step="0.01" required>
            </div>

            <div class="form-group">
                <label>Payment Method</label>
                <select name="paymentMethod" required>
                    <option value="VCB">Vietcombank</option>
                    <option value="MM">Momo</option>
                    <option value="SP">ShopeePay</option>
                    <option value="ZP">ZaloPay</option>
                </select>
            </div>

            <div class="button-group">
                <button type="submit" name="action" class="btn-green" value="paymentAdminSave">Save</button>
                <button type="submit" name="action" class="btn-cancel" value="paymentAdminCancel">Cancel</button>
            </div>
        </form>
    </div>
    </body>
    
    <style>
            /* Reset CSS */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }

            /* Form Container */
            .form-container {
                margin: 20px auto;
                width: 50%;
                max-width: 500px;
                background-color: #f9f9f9;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            /* Headings */
            h2 {
                color: #333;
                margin-bottom: 20px;
                font-size: 1.5em;
                text-align: center;
            }

            /* Form Styling */
            form label {
                display: block;
                margin: 10px 0 5px;
                color: #333;
            }
            form input, form select {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            /* Button */
            .btn-green {
                width: 100%;
                padding: 10px;
                color: #fff;
                background-color: #28a745;
                border: none;
                cursor: pointer;
                border-radius: 5px;
            }
            .btn-cancel {
                width: 100%;
                padding: 10px;
                color: #fff;
                background-color: #dc3545;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                margin-top: 10px;
            }
        </style>
</html>
