<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <title>CapyTravel - Login</title>
    </head>
    <body>

        <div class="wrapper">
            <form action="CapyTravelController" method="post">
                <h1>Login</h1>

                <div class="res_success" id="successMessage">
                    <h3>${requestScope.successRegisterMessage}</h3>
                </div>

                <div class="login_failed" id="loginFailed">
                    <h2>${requestScope.ERROR}</h2>
                </div>

                <div class="input-box">
                    <input type="text" name="username" placeholder="Username" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="password" name="password" placeholder="Password" required>
                    <i class='bx bxs-lock-alt'></i>
                </div>
                <button type="submit" name="action" value="userLogin" class="btn">Login</button>
                <%
                    String urlRegister = "CapyTravelController?action=userCreateNewAccount";
                %>
                <div class="register-link">
                    <p>Don't have an account? <a href="<%= urlRegister%>">Register</a></p>
                </div>
            </form>
        </div>

    </body>
    <script>
        // Lấy các phần tử thông báo thành công và thất bại
        const successMessage = document.getElementById('successMessage');
        const loginFailed = document.getElementById('loginFailed');

        // Kiểm tra nếu thông báo thành công có nội dung, ẩn thông báo thất bại
        if (successMessage && successMessage.textContent.trim() !== "") {
            loginFailed.style.display = 'none'; // Ẩn nội dung lỗi
            // Tự động đóng thông báo thành công sau 3 giây
            setTimeout(() => {
                successMessage.style.opacity = '0'; // Giảm dần opacity
                setTimeout(() => {
                    successMessage.style.display = 'none'; // Xóa thông báo sau khi hiệu ứng kết thúc
                }, 1000);
            }, 3000);
        } else if (loginFailed && loginFailed.textContent.trim() !== "") {
            loginFailed.style.display = 'block';
            successMessage.style.display  = 'none';
            setTimeout(() => {
                loginFailed.style.opacity = '0'; // Giảm dần opacity
                setTimeout(() => {
                    loginFailed.style.display = 'none'; // Xóa thông báo sau khi hiệu ứng kết thúc
                }, 1000);
            }, 500);
        }

    </script>
</html>
