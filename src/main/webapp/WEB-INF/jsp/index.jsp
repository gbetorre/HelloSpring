<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring MVC JSP Input</title>
    <!-- Basic styling for aesthetics -->
    <style>
        body {
            font-family: 'Inter', system-ui, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #333;
        }
        .container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            text-align: center;
        }
        input[type="text"] {
            padding: 10px;
            margin: 10px 0;
            width: 80%;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.2s;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Spring JSP</h1>
        <p>Please enter your name to receive a greeting:</p>
        
        <form action="${pageContext.request.contextPath}/web/greetings" method="post">
            <input type="text" name="name" placeholder="Enter your name" required>
            <br>
            <button type="submit">Greet Me</button>
        </form>
        
        <p style="margin-top:20px; font-size: 0.9em; color:#666;">
            (This demonstrates classic Java Web Server-Side Rendering)
        </p>
    </div>
</body>
</html>
