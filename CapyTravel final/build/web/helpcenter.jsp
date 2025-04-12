<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Help Center - CapyTravel</title>
        <link rel="stylesheet" href="css/helpcenter.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

        <script src="js/helpcenter.js" defer></script>

    </head>
    <body>

        <%@include file="usermenu.jsp" %>

        <div class="help-center">
            <h1>Help Center</h1>
            <p class="description">Welcome to the CapyTravel Help Center! Here you can find answers to frequently asked questions and contact our support team.</p>

            <!-- FAQ Section 1 -->
            <div class="faq-section">
                <h2><i class="fas fa-info-circle"></i> Frequently Asked Questions</h2>
                <div class="faq-item">
                    <h3 class="question">1. How do I book a flight?</h3>
                    <p class="answer">You can book a flight by selecting your departure and arrival cities, choosing your dates, and following the prompts to complete your booking.</p>
                </div>
                <div class="faq-item">
                    <h3 class="question">2. How can I change or cancel my booking?</h3>
                    <p class="answer">To change or cancel your booking, please log into your account and navigate to your bookings. You can also contact our support for assistance.</p>
                </div>
                <div class="faq-item">
                    <h3 class="question">3. What should I do if I have a problem during my flight?</h3>
                    <p class="answer">If you encounter any issues during your flight, please contact our cabin crew for immediate assistance or reach out to our customer support after your flight.</p>
                </div>
                <div class="faq-item">
                    <h3 class="question">4. How can I contact customer support?</h3>
                    <p class="answer">You can reach our customer support via the contact form on our website or by calling our hotline at <span style="text-decoration: underline">0386900940</span>.</p>
                </div>
            </div>

        </div>

         <%@include file="homefooter.jsp" %>

        <!--them cai nay-->
        <script src="js/nothomepage.js"></script>
    </body>
</html>
