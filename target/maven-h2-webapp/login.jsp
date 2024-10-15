<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Maven-H2-app</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/index.css"/>
    </head>
    <body>
        <div class="container">
            <div class="inner-container">
                <h1 >Login</h1>
            </div>
            <div class="inner-container">
                <form action="/login" method="post">
                    <% String errorMessage = (String) request.getAttribute("errorMessage");
                       if (errorMessage != null) { %>       
                        <p style="color: red;">Invalid email or Password.</p>
                    <% } %>
                    <input type="text" name="email" placeholder="email"><br>
                    <input type="password" name="password" placeholder="Password"><br>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>

