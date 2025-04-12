<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/ConfirmBooking/HomeBooking.css">

        <title>Booking Summary</title>

    </head>

    <body>
        <div class="container">
            <!-- Left Panel -->
            <div class="left-panel">

                <h2>Your Booking</h2>
                <p>Fill in your details and review your booking.</p>

                <div class="account-detail" data-testid="account-detail-loggedIn">
                    <div class="account-icon">
                        <img importance="low" loading="lazy" src="https://ik.imagekit.io/tvlk/image/imageResource/2018/07/27/1532667628823-8d3fb51a3735f35d48dfcd223d2f8bde.svg?tr=q-75,w-170"
                             width="170" style="object-fit: fill; object-position: 50% 50%;">
                    </div>
                    <div class="additional-icon">
                        <img src="https://d1785e74lyxkqq.cloudfront.net/_next/static/v2/1/10e771009e605099270565bf161c5ac4.svg">
                    </div>
                    <div class="user-info">
                        <h3 class="user-name">Đăng nhập với tên ${requestScope.USER_INFORMATION.userName}</h3>
                        <div class="user-email">${requestScope.USER_INFORMATION.firstName} (Google)</div>
                    </div>
                </div>

                <!--               ------------------------- hành lý ------------------------------->
                <div class="luggage-info">
                    <div class="luggage-header">
                        <img importance="low" loading="lazy" src="https://ik.imagekit.io/tvlk/image/imageResource/2022/02/24/1645670922968-3be65131ac44904991840ad5f5f1f9df.png?tr=h-24,q-75,w-24" 
                             width="24" height="24" style="object-fit: fill; object-position: 50% 50%;">
                        <h2 class="luggage-title">Hành lý</h2>
                        <div class="choose-luggage" role="button" tabindex="0">
                            <span style="color: rgb(1, 148, 243);">Chọn hành lý</span>
                        </div>
                    </div>
                    <div class="luggage-details">
                        <p class="luggage-info-text">Bạn có thể mang 20kg kiện/khách. Cần mua thêm? Chạm tại đây.</p>
                        <div class="luggage-price">
                            <span class="starting-from">Bắt đầu từ</span>
                            <span class="price" style="color: rgb(255, 94, 31);">265.736 VND</span>
                        </div>
                    </div>
                </div>

                <!------------------------------------------------------------------------> 
                <div class="section">
                    <div class="section-title">Contact Details</div>
                    <div class="details contact-info"> <!-- Thay đổi ở đây -->
                        <!-- Thông tin liên hệ -->
                        <form action="CapyTravelController" method="post">
                            <label for="mobile">Mobile Number:</label>
                            <input name="phonenumber" value="${requestScope.USER_INFORMATION.phoneNumber}"type="text" id="mobile" class="form-input" placeholder="Enter your mobile number" required>

                            <label for="email">Email:</label>
                            <input name="email" type="email" value="${requestScope.USER_INFORMATION.email}" id="email" class="form-input" placeholder="Enter your email" required>

                            </div>
                            </div>

                            <div class="section">
                                <div class="section-title">Traveler Details</div>
                                <div class="details traveler-info"> <!-- Thay đổi ở đây -->
                                    <!-- Thông tin người đi -->
                                    <label for="fullName">First Name:</label>
                                    <input name="firstname" type="text" value="${requestScope.USER_INFORMATION.firstName}" id="fullName" class="form-input" placeholder="Enter first name" required>
                                    <label for="fullName">Last Name:</label>
                                    <input name="lastname" type="text" value="${requestScope.USER_INFORMATION.lastName}" id="fullName" class="form-input" placeholder="Enter last name" required>

                                    <input type="hidden" name="id" value="${requestScope.USER_INFORMATION.userID}">
                                    <input type="hidden" name="username" value="${requestScope.USER_INFORMATION.userName}">
                                    <input type="hidden" name="gender" value="${requestScope.USER_INFORMATION.gender}">

                                    <label for="dob">Date of Birth:</label>
                                    <input name="dateOfBirth" type="date" value="${requestScope.USER_INFORMATION.dateOfBirth}" id="dob" class="form-input" required>

                                    <label for="identNumber">Identification Number:</label>
                                    <input name="identificationnumber" type="text" value="${requestScope.USER_INFORMATION.identificationNumber}" id="identificationNumber" class="form-input" placeholder="Enter Identification Number" required>
                                </div>
                            </div>


                            <!-- Thay thế nút "Continue" bằng tổng giá tiền và nút "Continue to Payment" -->
                            <div class="total-price">

                                <p><strong>Total Price: 2,000,000 VND </strong></p>
                                <%
                                    LocalDate today = LocalDate.now();

                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                    String bookingDate = today.format(formatter);
                                %>
                                <input type="hidden" name="flightIDReturn" value="${param.flightIDReturn}" />
                                <input type="hidden" name="flightIDDeparture" value="${param.flightIDDeparture}" />
                                <input type="hidden" name="bookingDate" value="<%=bookingDate%>"/>
                                <input type="hidden" name="totalAmount" value="<%=2000000%>" />
                                <button type="submit"  name="action" value="userContinuePayment" class="payment-button">Continue to Payment</button>
                        </form>
                    </div>

                </div>

                <!-- Right Panel -->
                <div class="right-panel">
                    <div class="trip-title">${sessionScope.FLIGHT_DETAILS.departureAirport} ⇄ ${sessionScope.FLIGHT_DETAILS.arrivalAirport} </div>
                    <div class="trip-details">
                        <!-- Thông tin chuyến đi -->                    
                        <p><strong>Departure - ${sessionScope.FLIGHT_DETAILS.departureDate}</strong></p>
                        <p>Airline: ${requestScope.AIRLINE_DEPARTURE} </p>
                        <p>Class: Economy</p>
                        <p>Departure Time: ${sessionScope.FLIGHT_TIME_DEPARTURE}  </p>

                        <hr>

                        <p><strong>Return - ${sessionScope.FLIGHT_DETAILS_RETURN.departureDate}</strong></p>
                        <p>Airline:${requestScope.AIRLINE_RETURN}  </p>
                        <p>Class: Economy</p>
                        <p>Departure Time: ${requestScope.flightTimeReturn} </p>
                    </div>
                </div>
            </div>


    </body>

</html>
