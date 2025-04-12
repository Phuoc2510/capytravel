<%-- 
    Document   : usermenu.jsp
    Created on : 07-11-2024, 19:51:21
    Author     : phuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <link rel="stylesheet" type="text/css" href="../css/stylehome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <script src="../js/homepage.js" defer></script>

    </head>
    <body>

        <header class="header">
            <div class="container_menu">
                <div class="header__wrap">
                    <div class="header__logo">
                        <a href="${pageContext.request.contextPath}/home.jsp"><img src="" alt=""><p>capytravel</p></a>

                    </div>
                    <div class="header__menu">                   
                        
<!--                        them cai nay -->
                        <div class="header__menu-1" id="navbar-menu">
                            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                                <li class=" scroll active"><a href="${pageContext.request.contextPath}/home.jsp#home">Home</a></li>
                                <li class="scroll"><a href="${pageContext.request.contextPath}/home.jsp#explore">Explore</a></li>
                                <li class="scroll"><a href="${pageContext.request.contextPath}/home.jsp#contact">Contact Us</a></li>
                                <li class="scroll"><a href="${pageContext.request.contextPath}/helpcenter.jsp">Help Center</a></li>
                            </ul>
                        </div>
                        
                        
                        
                        <div class="header__menu-4">
                            <div class="profile-container">
                                <img style="width: 30px" src="${pageContext.request.contextPath}/imgs/home-img/user.png" alt="User Icon" class="user-icon" onclick="toggleDropdown()" />
                                <div id="dropdownMenu" class="dropdown-menu">
                                    <!-- Thêm các mục menu ở đây -->
                                    <a href="CapyTravelController?action=userEditProfile">Profile</a>
                                    <a href="CapyTravelController?action=bookingShow">Your book</a>
                                    <a href="CapyTravelController?action=userLogout">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
