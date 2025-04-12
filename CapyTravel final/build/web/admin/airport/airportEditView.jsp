<%-- 
    Document   : editairport
    Created on : 29-10-2024
    Author     : YourName
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Airport</title>
      
    </head>
    <body>

        <div class="form-container">
            <h2>Edit Airport</h2>
            <form action="CapyTravelController">
                <div class="form-group">
                    <label>Airport ID</label>
                    <input type="text" name="airportID" value="${requestScope.AIRPORT.airportID}" readonly>
                </div>

                <div class="form-group">
                    <label>Airport Name</label>
                    <input type="text" name="airportName" value="${requestScope.AIRPORT.airportName}" required="">
                </div>

                <div class="form-group">
                    <label>Location</label>
                    <input type="text" name="location" value="${requestScope.AIRPORT.location}" required="">
                </div>
                
                <div class="form-group">
                    <label>Status</label>
                    <select name="status">
                        <option value="1" ${requestScope.AIRPORT.status == "1" ? "Selected" : ""}>Available</option>
                        <option value="0" ${requestScope.AIRPORT.status == "0" ? "Selected" : ""}>Not Available</option>
                    </select>
                </div>


                <div class="button-group">
                    <input type="hidden" name="id" value="${requestScope.AIRPORT.airportID}"/>
                    <button type="submit" name="action" class="edit-button" value="airportAdminUpdate">Save change</button>
                    <button type="submit" name="action" class="cancel-button" value="cancel">Cancel</button>
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
