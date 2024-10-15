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
        <!-- Typecasting: convert the value of a single data type into another data type -->
        <!-- (User) casts this object to the User type -->
        <%
            User user = (User) session.getAttribute("user");
            if (user != null) {
        %>
                <div class="inner-container">
                    <h3><%= user.getEmail() %></h3>
                </div>
                <div class="inner-container">
                   <a href="/changePWD">Change Password</a>
                </div>
            <%
            } else {
            %>
                <p>Please <a href="/login">log in</a>to see this page.</p>
            <%   
            }
            %>
    </div>
</body>
</html>