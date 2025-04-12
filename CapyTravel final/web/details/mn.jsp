<%-- 
    Document   : mn
    Created on : Nov 5, 2024, 12:39:44 AM
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
        <title>Introduction to Mui Ne</title>
    </head>
    <body>

        <jsp:include page="../usermenu.jsp" flush="true"/>

        <div class="container">
            <h2>About Mui Ne</h2>
            <p>Mui Ne, located along the southern coast of Vietnam, is famous for its beautiful beaches, red and white sand dunes, and year-round sunny weather. Known as a paradise for water sports enthusiasts, Mui Ne attracts visitors seeking relaxation, adventure, and breathtaking landscapes.</p>

            <h2>Popular Attractions</h2>
            <ul>
                <li><strong>White Sand Dunes:</strong> A unique desert-like landscape where you can enjoy sandboarding, jeep tours, and a beautiful view of the lakes surrounding the dunes.</li>
                <li><strong>Red Sand Dunes:</strong> Smaller than the white dunes but equally stunning, these red-hued dunes offer a great spot for watching the sunset and taking photos.</li>
                <li><strong>Fairy Stream:</strong> A shallow, scenic stream lined with colorful rock formations and lush greenery, perfect for a peaceful walk.</li>
                <li><strong>Mui Ne Beach:</strong> A beautiful beach known for its clear waters, ideal for swimming, kitesurfing, and relaxing by the sea.</li>
            </ul>

            <h2>Featured Image</h2>
            <img src="../imgs/home-img/lang-chai-mui-ne.jpg" alt="Mui Ne Beach and Sand Dunes" />

            <h2>Culinary Delights</h2>
            <p>Mui Ne is known for its fresh seafood and local specialties such as "banh can" (mini rice pancakes) and "lau tha" (a unique seafood hotpot). The vibrant food culture here is a delight for food lovers!</p>
        </div>

        <%@include file="../homefooter.jsp" %>

        <script src="js/help.js" defer></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/viewerjs/1.11.6/viewer.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>
