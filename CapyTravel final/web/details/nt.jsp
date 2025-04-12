<%-- 
    Document   : nt
    Created on : Nov 5, 2024, 12:39:18 AM
    Author     : phuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/details.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="../css/stylehome.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link rel="stylesheet" type="text/css" href="css/helpcenter.css">
        <title>Introduction to Nha Trang</title>
    </head>
    <body>

         <jsp:include page="../usermenu.jsp" flush="true"/>

        <div class="container">
            <h2>About Nha Trang</h2>
            <p>Nha Trang is a coastal city located in central Vietnam, known for its beautiful beaches, clear waters, and vibrant marine life. As one of Vietnam's top beach destinations, Nha Trang attracts tourists with its stunning coastline and various water activities.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>Vinpearl Land:</strong> A large amusement park and resort on an island, offering a wide range of entertainment and recreational activities.</li>
                <li><strong>Po Nagar Cham Towers:</strong> Ancient Hindu temples built by the Cham civilization, showcasing intricate architecture and historical significance.</li>
                <li><strong>Long Son Pagoda:</strong> A famous Buddhist temple known for its giant white Buddha statue on the hilltop, offering panoramic views of Nha Trang.</li>
                <li><strong>Nha Trang Beach:</strong> The city's main beach, perfect for sunbathing, swimming, and enjoying water sports.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/tour-bai-tranh-nha-trang-1-1638.jpeg" alt="Nha Trang Beach" />

            <h2>Culinary Delights</h2>
            <p>Nha Trang is also renowned for its fresh seafood, such as grilled lobsters, shrimp, and squid. Don't miss the local delicacies like "bun cha ca" (fish cake noodle soup) and "nem nuong" (grilled pork skewers).</p>
        </div>

      <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>

