

<%@page import="capytravel.users.UsersDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/User/User_Add.css">
        <title>Edit User</title>
      
    </head>
    <body>



        <div class="form-container">
            <h2>Edit User</h2>
            <form action="CapyTravelController" method="post">
          

                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" value="" required>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" value="" required>
                </div>

                <div class="form-group">
                    <label for="userName">UserName</label>
                    <input type="text" id="userName" name="userName" value="" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" value="" required>
                </div>

                <div class="form-group">
                    <label for="dob">Date of Birth</label>
                    <input type="date" id="dob" name="dob" value="" required>
                </div>

                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" value="" required>
                </div>

                <div class="form-group">
                    <label for="gender">Gender</label>
                    <select name="gender">
                        <option value="male" checked>Male</option>
                        <option value="female">Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="" required>
                </div>

                <div class="form-group">
                    <label for="identificationNumber">Identification Number</label>
                    <input type="text" id="identificationNumber" name="identificationNumber" value="" required>
                </div>

                <div class="form-group">
                    <label for="status">Status</label>
                    <select name="status">
                        <option value="true">Available</option>
                        <option value="false">Not Available</option>
                    </select>
                </div>

                <div class="button-group">
                    <button type="submit" name="action" value="userAdminAdd" class="edit-button">Save Changes</button>
                    <a href="CapyTravelController?action=userAdminList">
                        <button type="button" class="cancel-button">Cancel</button>
                    </a>
                </div>
            </form>

    </body>
</html>
