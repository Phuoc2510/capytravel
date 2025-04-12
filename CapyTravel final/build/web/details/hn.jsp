<%-- 
    Document   : nh
    Created on : Nov 5, 2024, 12:26:42 AM
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
        <title>Introduction to Hanoi</title>
    </head>
    <body>

        <jsp:include page="../usermenu.jsp" flush="true"/>

        <div class="container">
            <h2>About Hanoi</h2>
            <p>Hanoi, the capital of Vietnam, is a city with rich history, ancient architecture, and a unique blend of Eastern and Western influences. Situated in northern Vietnam, Hanoi is known for its centuries-old temples, vibrant culture, and iconic landmarks.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>Hoan Kiem Lake:</strong> A historic lake located in the heart of Hanoi, surrounded by beautiful walking paths and cafes, and home to the iconic Turtle Tower.</li>
                <li><strong>Temple of Literature:</strong> Vietnam’s first national university, built in 1070, featuring traditional Vietnamese architecture and lush gardens.</li>
                <li><strong>Old Quarter:</strong> A bustling area with narrow streets, markets, and ancient shops, offering a glimpse into Hanoi’s vibrant street life.</li>
                <li><strong>Ho Chi Minh Mausoleum:</strong> The final resting place of Vietnam's revolutionary leader, Ho Chi Minh, and a symbol of national pride.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/thu-do-ha-noi.jpg" alt="Hanoi City" />

            <h2>Culinary Delights</h2>
            <p>Hanoi is famous for its diverse and delicious cuisine, including dishes like pho, bun cha, banh cuon, and egg coffee. The city offers a unique culinary experience for food lovers!</p>
        </div>

        <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>