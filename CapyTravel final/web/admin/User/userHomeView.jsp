<%@page import="java.util.ArrayList"%>
<%@page import="capytravel.users.UsersDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Details Delete</title>
    <link rel="stylesheet" type="text/css" href="css/adminHomeStyle.css"> 

</head>
<body class="admin-body">

    <jsp:include page="../../adminMenu.jsp" flush="true" />
    <div class="admin-container">
        <h2>Management User</h2>
        
        <!-- Phần tìm kiếm và thêm người dùng -->
        <div class="form-container">
            <form action="CapyTravelController" class="search-form">
                <input type="text" class="search-input" name="searchValue" value="<%= request.getParameter("searchValue") != null ? request.getParameter("searchValue") : "" %>" placeholder="Search for user...">
                <button style="margin-right: 10px" name="action" value="userAdminSearch" type="submit" class="search-button">Search</button>
                <button type="submit" value="userAdminInsert" name="action" class="create-button">Add User</button>
            </form>
        </div>
        
        <!-- Bảng hiển thị danh sách người dùng -->
        <table class="flight-table">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    String status = "Not Available";
                    ArrayList<UsersDTO> searchResult = (ArrayList<UsersDTO>) request.getAttribute("SEARCH_RESULT");
                    if (searchResult != null) {
                        for (UsersDTO list : searchResult) {
                            if (list != null) {
                                status = list.isStatus() ? "Available" : "Not Available";
                %>
                <tr>
                    <td><%= list.getUserID() %></td>
                    <td><%= list.getFirstName() %></td>
                    <td><%= list.getLastName() %></td>
                    <td><%= status %></td>
                    <td>
                        <form class="action-form">
                            <a href="CapyTravelController?action=userAdminDetail&userID=<%= list.getUserID() %>">
                                <button type="button" class="detail-button">Details</button>
                            </a>
                            <a href="CapyTravelController?action=userAdminDelete&lastsearch=<%= request.getParameter("searchValue") %>&userID=<%= list.getUserID() %>">
                                <button type="button" class="delete-button">Delete</button>
                            </a>
                        </form>
                    </td>
                </tr>
                <% 
                            }
                        }
                    } else { 
                %>
                <c:forEach var="list" items="${requestScope.USER_LIST}">
                    <tr>
                        <td>${list.userID}</td>
                        <td>${list.firstName}</td>
                        <td>${list.lastName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${list.status}">Available</c:when>
                                <c:otherwise>Not Available</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <form class="action-form">
                                <a href="CapyTravelController?action=userAdminDetail&userID=${list.userID}">
                                    <button type="button" class="detail-button">Details</button>
                                </a>
                                <a href="CapyTravelController?action=userAdminDelete&userID=${list.userID}">
                                    <button type="button" class="delete-button">Delete</button>
                                </a>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
