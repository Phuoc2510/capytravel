<%-- 
    Document   : ha
    Created on : Nov 5, 2024, 12:39:25 AM
    Author     : phuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/details.css">

        <title>Introduction to Hoi An</title>
    </head>
    <body>

        <jsp:include page="../usermenu.jsp" flush="true"/>

        <div class="container">
            <h2>About Hoi An</h2>
            <p>Hoi An, a UNESCO World Heritage Site located in central Vietnam, is known for its well-preserved Ancient Town, unique architecture, and rich cultural heritage. The town’s atmospheric lantern-lit streets, traditional houses, and vibrant markets make it a must-visit destination.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>Japanese Covered Bridge:</strong> A historic 18th-century bridge and one of Hoi An’s most iconic landmarks, symbolizing the harmony between Japanese, Chinese, and Vietnamese cultures.</li>
                <li><strong>Hoi An Ancient Town:</strong> A beautiful area with narrow streets, old houses, and a blend of local and foreign influences in architecture.</li>
                <li><strong>Thu Bon River:</strong> Enjoy a boat ride along the river and experience the charming scenery of Hoi An at sunset.</li>
                <li><strong>An Bang Beach:</strong> A serene beach located just a few kilometers from the town, perfect for relaxation and water activities.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/hoi-an.webp" alt="Hoi An Ancient Town" />

            <h2>Culinary Delights</h2>
            <p>Hoi An is famous for its unique dishes such as “cao lau” (noodle dish with pork and greens), “banh mi” (Vietnamese baguette), and “com ga” (chicken rice). Don't miss the local delicacies in this historic town!</p>
        </div>

        <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>

