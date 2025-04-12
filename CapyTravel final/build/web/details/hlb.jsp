<%-- 
    Document   : hlb
    Created on : Nov 5, 2024, 12:29:59 AM
    Author     : phuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/details.css">

        <title>Introduction to Ha Long Bay</title>
    </head>
    <body>

         <jsp:include page="../usermenu.jsp" flush="true"/>
        <div class="container">
            <h2>About Ha Long Bay</h2>
            <p>Ha Long Bay, located in northeastern Vietnam, is a UNESCO World Heritage Site and one of the country's most popular tourist destinations. Known for its emerald waters, limestone islands, and mystical caves, Ha Long Bay is a natural wonder that attracts visitors from around the world.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>Thien Cung Cave:</strong> A famous cave with stunning stalactites and stalagmites, creating a magical experience for visitors.</li>
                <li><strong>Ti Top Island:</strong> A small island offering a panoramic view of the bay from its peak.</li>
                <li><strong>Luon Cave:</strong> A beautiful cave accessible by boat, where visitors can see unique rock formations and marine life.</li>
                <li><strong>Surprise Cave:</strong> One of the largest and most spectacular caves in Ha Long Bay, known for its impressive size and formations.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/ha-long-bay.jpg" alt="Ha Long Bay" />

            <h2>Culinary Delights</h2>
            <p>Ha Long Bay is also known for its fresh seafood dishes such as grilled squid, steamed crab, and fish hotpot. Don't miss the chance to savor these local delicacies while enjoying the scenic views!</p>
        </div>

       <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>

