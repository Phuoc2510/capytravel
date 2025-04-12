<%-- 
    Document   : home.jsp
    Created on : Oct 17, 2024, 5:52:49 PM
    Author     : a
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylehome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <script src="js/homepage.js" defer></script>
        <title>Home-Page</title>
    </head>
    <body>

        <%@include file="usermenu.jsp" %>

        <!-- Section-1 -->
        <div class="section-1" id="home">
            <div class="section-1__title">
                <div class="section-1__title--1">Peacefull like a capybara</div>
                <div class="section-1__title--2">reaching every corner of the country!</div>
            </div>
            <div class="section-1__buttons">
                <diV class="section-1__flights">
                    <i class="fa-sharp fa-solid fa-plane-departure"></i>
                    <div class="button-title-1">
                        Flights
                    </div>
                </diV>

            </div>
            <div class="section1__travel">
                <!--form chọn điểm đi về vv    -->
                <form action="CapyTravelController" method="POST">
                    <div class="select-container">
                        <!-- Chọn chuyến đi -->
                        <div class="section1__travel-input">
                            <label for="departure" class="select-label">From</label>  
                            <i class="fa-sharp fa-solid fa-plane-departure"></i>                   
                            <br>
                            <select id="destination" name="departureAirport" class="select-input select-1" required>

                                <option class="select" value="" selected=""> Departure </option>
                                <c:forEach var="c" items="${sessionScope.CHOOSE_AIRPORT}">
                                    <option value="${c.airportID}"> ${c.location} </option>
                                </c:forEach>
                            </select>
                        </div>


                        <!-- Chọn chuyến về -->
                        <div class="section1__travel-input">
                            <label for="destination" class="select-label">To</label>
                            <i class="fa-sharp fa-solid fa-plane-arrival"></i>
                            <br>                      
                            <select id="destination" name="arrivalAirport" class="select-input select-2" required>
                                <option class="select" value="" selected=""> Destination </option>
                                <c:forEach var="c" items="${sessionScope.CHOOSE_AIRPORT}">
                                    <option value="${c.airportID}"> ${c.location}</option>
                                </c:forEach>
                            </select>
                        </div>                   
                    </div>

                    <div class="schedule">
                        <div class="input-container">
                            <label for="departure-date" class="select-label">Departure Date</label>
                            <i class="fa-solid fa-calendar-days"></i>
                            <br>
                            <input name="departure-date" type="date" id="departure-date" placeholder="Chọn ngày đi" class="schedule__input-1">
                        </div>
                        <div class="input-container">
                            <label for="return-date" class="select-label">Return Date</label>
                            <i class="fa-solid fa-calendar-days"></i>
                            <br>
                            <input  name="return-date" type="date" id="return-date" placeholder="Chọn ngày về" class="schedule__input-2 dark">
                        </div>
                    </div>

                    <button type="submit" name="action" value="flightUserSearch" class="section-1__button"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
            </div>
        </div>
        <!-- End Section-1 -->

        <!--Header end-->    
        <!--message thong bao -->
        <%
            String successRegisterMessage = (String) request.getAttribute("successRegisterMessage");
            if (successRegisterMessage != null) {%>
        <h2 style="color: greenyellow"> <%= successRegisterMessage%>   </h2>
        <%   }%>

        <%
            String UPDATE_PROFILE_MESSAGES = (String) request.getAttribute("UPDATE_PROFILE_MESSAGES");
            if (UPDATE_PROFILE_MESSAGES != null) {%>
        <h2 style="color: greenyellow"> <%= UPDATE_PROFILE_MESSAGES%>   </h2>
        <%   }%>


        <div class="content-wrapper">
            <div class="content">
                <!-- start Body 1 -->
                <div class="offer">
                    <h2>Offers</h2>
                    <p>Promotions, deals, and special offers for you</p>
                    <div class="deal-container">
                        <!-- Deal 1 -->
                        <div class="deal-box box1">
                            <img  src="imgs/home-img/KhaiTruong.png" alt="Capybara Sanctuary" class="large-image">
                            <div class="deal-content">
                                <h2>Grand Opening Celebration! </h2>
                                <p>Flat rate of just 1 million VND for every flight!</p>
                                <a href="#" class="deal-button">Find Getaway Deals</a>
                            </div>
                        </div>

                        <!-- Deal 2 -->
                        <div class="deal-box box2">
                            <div class="deal-content">
                                <h2>Travel Light, Go Far!</h2>
                                <p>Celebrate our Grand Opening with Free 20kg Baggage Allowance on all flights! Book and fly with us before January 7, 2025."</p>
                                <a href="#" class="deal-button">Find Late Escape Deals</a>
                            </div>
                            <img src="imgs/home-img/offer_IMG2.jpg" alt="Canoe Trip" class="small-image">
                        </div>
                    </div>

                </div>
            </div>

            <!-- end Body 1 -->

            <!-- Body 2 -->
            <!-- Popular Destinations Section -->
            <section class="popular-destinations" id="explore">
                <h2>POPULAR DESTINATIONS</h2>
                <div class="destination-container">
                    <div class="destination-card" id="destination-card">
                        <img src="imgs/home-img/thanh-pho-hcm.png" alt="Ho Chi Minh City">
                        <div class="destination-details">
                            <h3>Ho Chi Minh City</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 33.0°C</p>
                            <p class="description">Ho Chi Minh City, also known as Saigon, is the largest city in Vietnam and serves as the economic, cultural, and educational center of the country.</p>
                            <a href="details/hcm.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-2">
                        <img src="imgs/home-img/thu-do-ha-noi.jpg" alt="Hanoi">
                        <div class="destination-details">
                            <h3>Hanoi</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 30.0°C</p>
                            <p class="description">Hanoi, the capital of Vietnam, is a city with rich history, ancient architecture, and a unique blend of Eastern and Western influences.</p>
                            <a href="details/hn.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-3">
                        <img src="imgs/home-img/da-nang.jpg" alt="Da Nang">
                        <div class="destination-details">
                            <h3>Da Nang</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 28.0°C</p>
                            <p class="description">Da Nang is a coastal city in central Vietnam, known for its sandy beaches, stunning landscapes, and vibrant cultural life.</p>
                            <a href="details/dn.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-4">
                        <img src="imgs/home-img/ha-long-bay.jpg" alt="Ha Long Bay">
                        <div class="destination-details">
                            <h3>Ha Long Bay</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 25.0°C</p>
                            <p class="description">Ha Long Bay, located in northeastern Vietnam, is a UNESCO World Heritage Site and one of the country's most popular tourist destinations.</p>
                            <a href="details/hlb.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-4">
                        <img src="imgs/home-img/nha-trang.jpeg" alt="Nha Trang">
                        <div class="destination-details">
                            <h3>Nha Trang</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 31.0°C</p>
                            <p class="description">Nha Trang is a coastal city located in central Vietnam, known for its beautiful beaches, clear waters, and vibrant marine life</p>
                            <a href="details/nt.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-4">
                        <img src="imgs/home-img/hoi-an.webp" alt="Hoi An">
                        <div class="destination-details">
                            <h3>Hoi An</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 29.5°C</p>
                            <p class="description">Hoi An, a UNESCO World Heritage Site located in central Vietnam, is known for its well-preserved Ancient Town, unique architecture, and rich cultural heritage.</p>
                            <a href="details/ha.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-4">
                        <img src="imgs/home-img/sapa.jpg" alt="Sa Pa">
                        <div class="destination-details">
                            <h3>Sapa</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 18.0°C</p>
                            <p class="description">Sapa, located in northern Vietnam, is a mountainous town known for its stunning terraced rice fields, misty valleys, and the diverse cultures of its ethnic minorities.</p>
                            <a href="details/sp.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>
                    <div class="destination-card" id="destination-card-4">
                        <img src="imgs/home-img/mui-ne.jpg" alt="Mui Ne">
                        <div class="destination-details">
                            <h3>Mui Ne</h3>
                            <p class="location">Vietnam</p>
                            <p class="temperature">🌡 Temperature: 34.0°C</p>
                            <p class="description">Mui Ne is known for its fresh seafood and local specialties such as "banh can" (mini rice pancakes) and "lau tha" (a unique seafood hotpot).</p>
                            <a href="details/mn.jsp" class="view-details">View Details →</a>
                        </div>
                    </div>  
                </div>
            </section>

            <!-- end Body 2 -->

            <!-- start Body 3 -->
            <div class="Partner">
                <h2>Airline Partners - Easily book cheapest flights</h2>
                <div class="airline-logos">
                    <img src="imgs/home-img/logo-viet_travel.jpg" alt="Vietravel Airlines">
                    <img src="imgs/home-img/Logo-vietjet.jpg" alt="Vietjet Air">
                    <img src="imgs/home-img/logo-vietnam_airlines.jpg" alt="Vietnam Airlines">
                    <img src="imgs/home-img/Bamboo_logo.png" alt="Bamboo Airways">
                </div>
            </div>
            <!-- end Body 3 -->

            <!-- start Footer -->

                    <%@include file="homefooter.jsp" %>
            <!-- end Footer -->
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    
    
<!--    them cai nay-->
    <script>
    // Thiết lập biến toàn cục để kiểm tra xem có phải là trang home không
    window.isHomePage = true; // Hoặc có thể là một điều kiện kiểm tra khác
</script>

</html>

