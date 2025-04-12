<%-- 
    Document   : register
    Created on : Oct 25, 2024, 11:01:38 AM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/register.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CapyTravel - Register</title>
    </head>



    <body class="register_body">
        <div class="wrapper">

            <form action="CapyTravelController" method="post" >

                <h1>Register</h1>
                <div class="res_success" id="successMessage">
                    <h3>${requestScope.errorRegisterMessage}</h3>
                </div>
                <div class="input-box" id="register" >

                    <input name="username" type="text" placeholder="Username" required>

                    <i class='bx bxs-user'></i>

                </div>

                <div class="input-box" id="register">

                    <input name="password" type="password" placeholder="Password" required>

                    <i class='bx bxs-lock-alt'></i>
                </div>
                <div class="input-box" id="register">

                    <input name="firstname" type="text" placeholder="First Name" required>

                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box" id="register">

                    <input name="lastname" type="text" placeholder="Last Name" required>

                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box" id="register">

                    <input name ="email"  type="email" placeholder="Email" required>

                    <i class='bx bxs-envelope'></i>
                </div>

                <button type="submit" name ="action" value ="userRegister" class="btn">Register</button>

                <%
                    //duong dan de dang ky
                    String urlLogin = "CapyTravelController?action=userLogin";
                %>

                <div class="login-link">
                    <p>Already have an account? <a href="<%= urlLogin%>">Login</a></p>
                </div>
            </form>
        </div>
    </body>
    <script>
        // Lấy các phần tử thông báo thành công và thất bại
        const successMessage = document.getElementById('successMessage');
        // Kiểm tra nếu thông báo thành công có nội dung, ẩn thông báo thất bại
        if (successMessage && successMessage.textContent.trim() !== "") {
            // Tự động đóng thông báo thành công sau 3 giây
            setTimeout(() => {
                successMessage.style.opacity = '0'; // Giảm dần opacity
                setTimeout(() => {
                    successMessage.style.display = 'none'; // Xóa thông báo sau khi hiệu ứng kết thúc
                }, 1000);
            }, 3000);
        } else {
            successMessage.style.display = 'none'; // Ẩn nội dung lỗi

        }
    </script>
</html>
