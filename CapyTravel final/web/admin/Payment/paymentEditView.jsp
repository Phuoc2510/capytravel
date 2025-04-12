<%-- 
    Document   : paymentEditView
    Created on : 29-10-2024
    Author     : YourName
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
            <h2>Edit Payment</h2>
            <form action="CapyTravelController">

                <div class="form-group">
                    <label>Payment Date</label>
                    <input type="date" name="paymentDate" value="${requestScope.PAYMENT.paymentDate}" required>
                </div>

                <div class="form-group">
                    <label>Amount</label>
                    <input type="number" name="amount" value="${requestScope.PAYMENT.amount}" step="0.01" required>
                </div>
                
                <div class="form-group">
                    <label>Payment Method</label>
                    <select name="paymentMethod" required>
                        <option value="VCB" ${requestScope.PAYMENT.paymentMethod == 'VCB' ? 'selected' : ''}>Vietcombank</option>
                        <option value="MM" ${requestScope.PAYMENT.paymentMethod == 'MM' ? 'selected' : ''}>Momo</option>
                        <option value="SP" ${requestScope.PAYMENT.paymentMethod == 'SP' ? 'selected' : ''}>ShoppePay</option>
                        <option value="ZP" ${requestScope.PAYMENT.paymentMethod == 'ZP' ? 'selected' : ''}>ZaloPay</option>
                    </select>
                </div>

                <div class="button-group">
                    <input type="hidden" name="id" value="${requestScope.PAYMENT.paymentID}"/>
                    <button type="submit" name="action" class="edit-button" value="paymentAdminUpdate">Save Changes</button>
                    <button type="submit" name="action" class="cancel-button" value="paymentAdminCancel">Cancel</button>
                </div>
            </form>
        </div>

    </body>
    
     <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f0f0f0;
            }
            .form-container {
                max-width: 500px;
                width: 100%;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #ffffff;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }
            .form-container h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #333;
            }
            .form-group {
                display: flex;
                flex-direction: column;
                margin-bottom: 15px;
            }
            .form-group label {
                margin-bottom: 5px;
                font-weight: bold;
                color: #555;
            }
            .form-container input {
                padding: 10px;
                font-size: 16px;
                border-radius: 5px;
                border: 1px solid #ccc;
                width: 100%;
                box-sizing: border-box;
            }
            .button-group {
                display: flex;
                gap: 10px;
                margin-top: 10px;
            }
            .form-container button {
                padding: 10px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
                box-sizing: border-box;
            }
            .form-container .edit-button {
                background-color: #28a745;
                color: white;
                border: none;
            }
            .form-container .edit-button:hover {
                background-color: #218838;
            }
            .form-container .cancel-button {
                background-color: #dc3545;
                color: white;
                border: none;
            }
            .form-container .cancel-button:hover {
                background-color: #c82333;
            }
        </style>
</html>
