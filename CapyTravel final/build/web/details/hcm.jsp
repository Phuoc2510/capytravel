<%-- 
    Document   : hscm
    Created on : Nov 4, 2024, 9:19:56 PM
    Author     : phuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/details.css">

        <title>Introduction to Ho Chi Minh City</title>
    </head>
    <body>

         <jsp:include page="../usermenu.jsp" flush="true"/>
        
        <div class="container">
            <h2>About Ho Chi Minh City</h2>
            <p>Ho Chi Minh City, also known as Saigon, is the largest city in Vietnam and serves as the economic, cultural, and educational center of the country. Located in southern Vietnam, this city is famous for its vibrant lifestyle, rich cuisine, and various attractions.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>Ben Thanh Market:</strong> One of the most famous markets in Saigon, where you can find a variety of handicrafts, souvenirs, and street food.</li>
                <li><strong>Notre-Dame Cathedral Basilica of Saigon:</strong> An iconic architectural symbol built in the 19th century, showcasing Romanesque style.</li>
                <li><strong>Bitexco Financial Tower:</strong> The tallest building in the city with a sky deck, offering panoramic views of the cityscape.</li>
                <li><strong>23 September Park:</strong> An ideal green space for relaxation and recreational activities.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/thanh-pho-hcm.png" alt="Ho Chi Minh City" />

            <h2>Culinary Delights</h2>
            <p>Ho Chi Minh City is also renowned for its delicious dishes such as pho, banh mi, com tam, and various street foods. Come and experience the amazing culinary culture of this vibrant city!</p>
        </div>

        <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>