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
        <h1>Welcome</h1>
        <%
            <!-- Typecasting: convert the value of a single data type into another data type -->
            <!-- (User) casts this object to the User type -->
            User user = (User) session.getAttribute("user");
            if (user != null) {
        %>
                <div class="user-info">
                    <div>Your account email: <%= user.getEmail() %></div>
                </div>

                <div class="form">
                    <h2>Change Password</h2>
                    <form action="/api/change_pwd" method="POST">
                        <div class="form-group">
                            <label for="currentPassword">Current Password:</label>
                            <input type="password" id="currentPassword" name="currentPassword" required>
                        </div>
                        <div class="form-group">
                            <label for="newPassword">New Password:</label>
                            <input type="password" id="newPassword" name="newPassword" required>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm New Password:</label>
                            <input type="password" id="confirmPassword" name="confirmPassword" required>
                        </div>
                        <button type="submit">Change Password</button>
                    </form>
                </div>
            <%
            } else {
            %>
                <p>Please <a href="login.jsp">log in</a>to see this page.</p>
            <%   
            }
            %>
    </div>
</body>
</html>