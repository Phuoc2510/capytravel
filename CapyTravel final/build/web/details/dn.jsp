<%-- 
    Document   : dn
    Created on : Nov 5, 2024, 12:29:45 AM
    Author     : phuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/details.css">
             
        <title>Introduction to Da Nang</title>
    </head>
    <body>

        <jsp:include page="../usermenu.jsp" flush="true"/>
        
        <div class="container">
            <h2>About Da Nang</h2>
            <p>Da Nang is a coastal city in central Vietnam, known for its sandy beaches, stunning landscapes, and vibrant cultural life. It is often considered one of the most livable cities in Vietnam, with a blend of modernity and natural beauty.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>My Khe Beach:</strong> A beautiful beach with soft white sands, clear blue water, and numerous resorts and activities for tourists.</li>
                <li><strong>Ba Na Hills:</strong> A scenic mountain resort featuring the famous Golden Bridge held by giant hands, offering breathtaking views of the surrounding area.</li>
                <li><strong>Dragon Bridge:</strong> A unique bridge in the shape of a dragon, which breathes fire and water during weekend nights, symbolizing Da Nang's modernization.</li>
                <li><strong>Marble Mountains:</strong> A cluster of marble and limestone hills with caves, pagodas, and spectacular views over the city and ocean.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/da-nang.jpg" alt="Da Nang City" />

            <h2>Culinary Delights</h2>
            <p>Da Nang offers a variety of culinary delights, including dishes like mi quang, banh xeo, and fresh seafood. The city's cuisine reflects its coastal location and rich cultural influences from central Vietnam.</p>
        </div>

       <%@include file="../homefooter.jsp" %>
       
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
<!--them cai nay-->
<script src="js/nothomepage.js"></script>
</html>

