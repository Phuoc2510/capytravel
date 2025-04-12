<%-- 
    Document   : homefooter
    Created on : Nov 8, 2024, 1:52:35 AM
    Author     : ADMIN
--%>

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
        <title>Home Footer Page</title>
    </head>
    <body>
        <div class="footer" id="contact-footer">
            <div class="container_footer">
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/imgs/home-img/Logo_tmp.png" alt="CapyTravel Logo">
                </div>
                <div class="payment-partners">
                    <h3>Payment Partners</h3>
                    <div class="partners-row">
                        <img src="${pageContext.request.contextPath}/imgs/home-img/Vcb_logo.png" alt="Vietcombank">
                        <img src="${pageContext.request.contextPath}/imgs/home-img/Shoppepay_logo.jpg" alt="ShopeePay">
                    </div>
                    <div class="partners-row">
                        <img src="${pageContext.request.contextPath}/imgs/home-img/Momo_logo.jpg" alt="Momo">
                        <img src="${pageContext.request.contextPath}/imgs/home-img/Zalopay_logo.png" alt=""/>
                    </div>
                </div>
                <div class="contact" id="contact">
                    <h3>Contact</h3>
                    <p>
                        <img src="${pageContext.request.contextPath}/imgs/home-img/send-mail.png" alt="Email Icon" class="icon">
                        <a href="mailto:capy@capytravel.com">capy@capytravel.com</a>
                    </p>
                    <p class="phone--contact">
                        <img src="${pageContext.request.contextPath}/imgs/home-img/phone-ringing.png" alt="Phone Icon" class="icon">
                        <a href="tel:0386900940">0386900940</a>
                    </p>
                </div>
            </div>
            <div class="copyright">
                <p>Capytravel Co., D1 Street, Long Thanh My Ward, Thu Duc City, Ho Chi Minh City</p>
                <p>Copyright © 2024 Capytravel. All rights reserved</p>
            </div>
        </div>
    </body>
</html>
