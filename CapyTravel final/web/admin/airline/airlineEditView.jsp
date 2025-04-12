<%-- 
    Document   : airlinedetails
    Created on : 29-10-2024
    Author     : YourName
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Airline</title>
        
    </head>
    <body>

        <div class="form-container">
            <h2>Edit Airline</h2>
            <form action="CapyTravelController" method="GET">
                <div class="form-group">
                    <label>Airline ID</label>
                    <input type="text" name="airlineID" value="${requestScope.AIRLINE_DETAILS.airlineID}" readonly>

                </div>

                <div class="form-group">
                    <label>Airline Name</label>
                      <input type="text" name="airlineName" value="${requestScope.AIRLINE_DETAILS.airlineName}" required="">
                </div>

                <div class="form-group">
                    <label for="airlineStatus">Status</label>
                    <select id="airlineStatus" name="airlineStatus">
                        <option value="true" ${requestScope.AIRLINE_DETAILS.airlineStatus == "true" ? "Selected" : ""}>Available</option>
                        <option value="false" ${requestScope.AIRLINE_DETAILS.airlineStatus == "false" ? "Selected" : ""}>Not Available</option>
                    </select>
                </div>

                <div class="button-group">
                    <input name="airlineID" value="${requestScope.id}" type="hidden">
                    <button class="edit-button" name="action" type="submit" value="airlineAdminUpdate">Save Changes</button>
                    <button class="cancel-button" name="action" type="submit" value="airlineAdminManagement">Cancel</button>
                </div>
            </form>
        </div>

    </body>
    <style>
            /* Basic reset and styling */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f8f9fa;
            }
            .form-container {
                max-width: 400px;
                width: 100%;
                padding: 25px;
                border-radius: 8px;
                background-color: #ffffff;
                box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
            }
            .form-container h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #343a40;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                font-weight: bold;
                color: #495057;
                margin-bottom: 5px;
            }
            .form-container input[type="text"], .form-container select {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border-radius: 5px;
                border: 1px solid #ced4da;
                outline: none;
                transition: border-color 0.3s ease;
            }
            .form-container input[type="text"]:focus, .form-container select:focus {
                border-color: #80bdff;
                box-shadow: 0 0 5px rgba(0, 123, 255, 0.25);
            }
            .button-group {
                display: flex;
                gap: 10px;
                margin-top: 20px;
            }
            .form-container button {
                flex: 1;
                padding: 12px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                border: none;
                color: white;
                transition: background-color 0.3s ease;
            }
            .form-container .edit-button {
                background-color: #007bff;
            }
            .form-container .edit-button:hover {
                background-color: #0056b3;
            }
            .form-container .cancel-button {
                background-color: #6c757d;
            }
            .form-container .cancel-button:hover {
                background-color: #5a6268;
            }
        </style>
</html>
