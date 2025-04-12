

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="capytravel.users.UsersDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/User/User_Edit.css">

        <title>Edit User</title>
        
    </head>
    <body>

        <div class="form-container">
            <h2>Edit User</h2>
            <form action="CapyTravelController" method="post">
                <div class="form-group">
                    <label for="userId">User ID</label>
                    <input type="text" id="userId" name="userID" value="${requestScope.DETAIL_USER.userID}" readonly required>
                </div>



                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" value="${requestScope.DETAIL_USER.firstName}">
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" value="${requestScope.DETAIL_USER.lastName}">
                </div>

                <div class="form-group">
                    <label for="userName">UserName</label>
                    <input type="text" id="userName" name="userName" value="${requestScope.DETAIL_USER.userName}">
                </div>
                
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text" id="password" name="password" value="${requestScope.DETAIL_USER.password}">
                </div>

                <div class="form-group">
                    <label for="dob">Date of Birth</label>
                    <input type="date" id="dob" name="dob" value="${requestScope.DETAIL_USER.dateOfBirth}">
                </div>

                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" value="${requestScope.DETAIL_USER.phoneNumber}">
                </div>

                <div class="form-group">
                    <label for="gender">Gender</label>
                    <select name="gender">
                        <option value="Male" ${requestScope.DETAIL_USER.gender == "Male" ? "selected" : ""}>Male</option>

                        <option value="Female" ${requestScope.DETAIL_USER.gender == "Female" ? "selected" : ""}>Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="${requestScope.DETAIL_USER.email}">
                </div>

                <div class="form-group">
                    <label for="identificationNumber">identificationNumber</label>
                    <input type="text" id="identificationNumber" name="identificationNumber" value="${requestScope.DETAIL_USER.identificationNumber}">
                </div>

                <div class="form-group">
                    <label for="status">status</label>
                    <select name="status">
                        <option value="true" ${requestScope.DETAIL_USER.status == "true" ? "selected" : ""}> Available</option>
                        <option value = "false" ${requestScope.DETAIL_USER.status == "false" ? "selected" : ""} >Not  Available</option>
                    </select>
                </div>

                <div class="button-group">

                    <button type="submit" name ="action" value ="userAdminSave"
                            class="edit-button">Save Changes</button>


                    <a href="CapyTravelController?action=userAdminDetail&userID=${requestScope.DETAIL_USER.userID}"> 
                        <button type="button" class="cancel-button">Cancel</button>
                    </a>
                </div>
            </form>
        </div>

    </body>
</html>
