<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 320px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #4caf50;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
	
	<%
		String message5 = (String) session.getAttribute("message5");
        String message = (String) session.getAttribute("message4");
        if (message != null && !message.isEmpty()) {
    %>
    <script>
        alert("<%= message %>");
    </script>
    <%
        }
        else if(message5 != null && !message5.isEmpty()){
    %>
    <script>
        alert("<%= message5 %>");
    </script>
    <%
    message=null;
    message5=null;
        }
        %>
        <% 
    message="You are a new user!! Please sign up..";
    session.setAttribute("message3", message);
    %>
	
    <div class="container">
        <h2>Sign In</h2>
        <form action="signin" method="post">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="submit" value="Sign In">
        </form>
            <h6>New user <a href="signup.jsp">Sign Up</a></h6>
    </div>
</body>
</html>
        </div>
    </div>
</body>
</html>