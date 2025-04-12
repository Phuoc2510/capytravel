<%-- 
    Document   : userinfomation
    Created on : 27-10-2024, 18:29:16
    Author     : phuja
--%>

<%@page import="capytravel.users.UsersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Information</title>
    <link rel="stylesheet" type="text/css" href="css/Booking/bookingDetail.css">
</head>
<body>
    <div class="container">
        <h2>User Information</h2>
        <div class="form-container">
       
        </div>
        <table>
            <tr>
                <th>User ID</th>
                <td>${requestScope.DETAIL_USER.userID}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${requestScope.DETAIL_USER.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${requestScope.DETAIL_USER.lastName}</td>
            </tr>
            <tr>
                <th>Username</th>
                <td>${requestScope.DETAIL_USER.userName}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>***</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${requestScope.DETAIL_USER.gender}</td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td>${requestScope.DETAIL_USER.dateOfBirth}</td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>${requestScope.DETAIL_USER.phoneNumber}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${requestScope.DETAIL_USER.email}</td>
            </tr>
            <tr>
                <th>Identification Number</th>
                <td>${requestScope.DETAIL_USER.identificationNumber}</td>
            </tr>
            <tr>
                <th>Status</th>
                <td>
                    <c:choose>
                        <c:when test="${DETAIL_USER.status}">
                            Available
                        </c:when>
                        <c:otherwise>
                            Not Available
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="actions">
                        <a href="CapyTravelController?action=userAdminEdit&userID=${requestScope.DETAIL_USER.userID}">
                            <button style="background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s;">Edit</button>
                        </a>
                       <a href="CapyTravelController?action=userAdminBack">
                <button style="background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s;">Back</button>
            </a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
