<%-- 
    Document   : sp
    Created on : Nov 5, 2024, 12:39:31 AM
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
        <title>Introduction to Sapa</title>
    </head>
    <body>

        <jsp:include page="../usermenu.jsp" flush="true"/>

        <div class="container">
            <h2>About Sapa</h2>
            <p>Sapa, located in northern Vietnam, is a mountainous town known for its stunning terraced rice fields, misty valleys, and the diverse cultures of its ethnic minorities. This charming town offers breathtaking landscapes and a unique cultural experience.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>Fansipan Mountain:</strong> The highest peak in Indochina, often called "the Roof of Indochina," offers adventurous trekking routes and panoramic views.</li>
                <li><strong>Cat Cat Village:</strong> A traditional Hmong village where visitors can experience the lifestyle, culture, and crafts of the ethnic Hmong people.</li>
                <li><strong>Muong Hoa Valley:</strong> Known for its scenic terraced rice fields and the ancient carved stones, it's a picturesque spot perfect for nature lovers.</li>
                <li><strong>Love Waterfall:</strong> A beautiful waterfall surrounded by lush greenery, ideal for nature walks and relaxation.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/sapa.jpg" alt="Sapa Landscape" />

            <h2>Culinary Delights</h2>
            <p>Sapa is famous for its regional dishes, including "thang co" (a traditional hotpot), grilled foods, and various dishes made with fresh local vegetables. The unique flavors reflect the cultural diversity of the area.</p>
        </div>

        <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>
