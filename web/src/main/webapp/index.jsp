<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bank Management Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">
    <img src="https://download.logo.wine/logo/Axis_Bank/Axis_Bank-Logo.wine.png" alt="Bank Logo" class="logo">
</div>


<div class="login-container">
    <form method="post" action="${pageContext.request.contextPath}/login" class="login-box">
        <input type="text" placeholder="User Name" name="email" required>
        <input type="password" placeholder="Password" name="password" required>
        <div class="checkbox-container">
            <input type="checkbox" id="showPass">
            <label for="showPass">Display Password</label>
        </div>
        <button type="submit">Login</button>
    </form>
</div>

<div class="footer">
    <p>
        Copyright © 2025 A_Designer Corporation. All rights reserved |
        <a href="#">Licenses</a> |
        <a href="#">Privacy Policy</a>
    </p>
</div>
</body>
</html>

