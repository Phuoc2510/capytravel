<%-- 
    Document   : editairline
    Created on : 27-10-2024, 18:39:06
    Author     : phuja
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
            <form action="CapyTravelController" method="POST">
                <label for="airlineID">Airline ID</label>
                <input type="text" id="airlineID" name="airlineID" placeholder="Enter airline ID">

                <label for="airlineName">Airline Name</label>
                <input type="text" id="airlineName" name="airlineName" placeholder="Enter airline name">

                <label for="status">Status</label>
                <select id="status" name="airlineStatus">
                    <option value="true">Active</option>
                    <option value="false">Inactive</option>
                </select>

                <div class="button-group">
                    <button type="submit" name="action" value="airlineAdminAdd" class="btn-green">Add</button>
                    <button type="submit" name="action" value="airlineAdminManagement" class="btn-cancel">Cancel</button>
                </div>
            </form>
        </div>    
    </body>
    
      <style>
            
/* Reset and General Styling */
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
    min-height: 100vh;
    background-color: #f4f6f9;
}

/* Form Container */
.form-container {
    width: 100%;
    max-width: 400px;
    background-color: #ffffff;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Headings */
.form-container h2 {
    text-align: center;
    margin-bottom: 20px;
    font-size: 1.8em;
    color: #333;
}

/* Form Styling */
.form-container form label {
    display: block;
    margin-bottom: 5px;
    color: #555;
    font-weight: bold;
}
.form-container form input[type="text"],
.form-container form select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}
.form-container form select {
    background-color: #ffffff;
}

/* Button Styling */
.button-group {
    display: flex;
    gap: 10px;
    margin-top: 15px;
}
.button-group button {
    flex: 1;
    padding: 10px;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}
.btn-green {
    background-color: #28a745;
    color: white;
}
.btn-green:hover {
    background-color: #218838;
}
.btn-cancel {
    background-color: #dc3545;
    color: white;
}
.btn-cancel:hover {
    background-color: #c82333;
}

        </style>
</html>
