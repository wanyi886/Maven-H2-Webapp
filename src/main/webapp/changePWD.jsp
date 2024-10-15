<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.wlee.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
    <div class="container">
        <h1>Change Password</h1>
                <div class="inner-container">
                    <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                    %>
                    <div class="form">
                        <div class="inner-container">
                            <!-- <h2>Change Password</h2> -->
                        </div>
                        <form action="/changePWD" method="post">
                            <div class="form-group">
                                <input placeholder="Current Password" type="password" id="currentPassword" name="currentPassword" required>
                            </div>
                            <div class="form-group">
                                <input placeholder="New Password" type="password" id="newPassword" name="newPassword" required>
                            </div>
                            <div class="form-group">
                                <input placeholder="Confirm New Password" type="password" id="confirmPassword" name="confirmPassword" required>
                            </div>
                            <input hidden name="email" value="<%= user.getEmail() %>">
                            <button type="submit">Change Password</button>
                        </form>
                        <%
                    } else {
                    %>
                        <p>Please <a href="login">log in</a>to see this page.</p>
                    <%   
                    }
                    %>
                    </div>
                </div>
    </div>
</body>
</html>