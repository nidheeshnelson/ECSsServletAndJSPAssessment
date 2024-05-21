<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }

        .welcome {
            text-align: center;
            margin-bottom: 20px;
        }

        .products {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .product {
            width: 30%;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
        }

        .product img {
            width: 100%;
            height: auto;
        }

        .product .buy-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Popup styles */
        .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #f1f1f1;
            padding: 20px;
            border-radius: 5px;
            z-index: 999;
        }

        .close-btn {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }
        .nav {
    background-color: #333;
    overflow: hidden;
    padding: 10px 20px;
}

.nav h4 {
    display: inline-block;
    margin: 0 15px;
}

.nav h4 a.inactive {
    text-decoration: none;
    color: #ffffff;
    padding: 14px 20px;
    display: block;
    transition: background-color 0.3s ease, color 0.3s ease;
}

.nav h4 a.inactive:hover {
    background-color: #575757;
    color: #ffffff;
    border-radius: 5px;
}
.nav h4 a#active1{
 	text-decoration: none;
	background-color: #575757;
    color: #ffffff;
    padding: 14px 20px;
    display: block;
    border-radius: 5px;}
    </style>
</head>
<body>
<%
        String username = (String) session.getAttribute("username");
        
    %>
    <%
        String message = (String) session.getAttribute("message2");
        if (message != null && !message.isEmpty()) {
    %>
    <script>
        alert("<%= message %>");
    </script>
    <%
    message=null;
        }
    %>
<div class="container">
    <h1 class="welcome">Welcome, <%= username %>!</h1>
    <div class="nav">
    <h4><a id="active1" href="">Home</a></h4>
    <h4><a class="inactive" href="signin.jsp">SignOut</a></h4>
    <h4><a class="inactive" href="/servletassessment/cart?username=<%= username %>">Cart</a></h4>
    <h4><a class="inactive" href="/servletassessment/order?username=<%= username %>">Order</a></h4>
	</div>
    <div class="products">
        <div class="product">
            <img src="https://m.media-amazon.com/images/G/31/img24/Beauty/BAU/Unrec/Headers/199_unrec_header._SX621_QL85_FMpng_.png" alt="Product 1">
            <h3>Product 1001</h3>
            <p>Description of Product 1001.. 
            Enjoy high-quality sound with these wireless headphones. 
            Featuring noise cancellation and a long-lasting battery, 
            these headphones are perfect for on-the-go listening. 
            Compatible with all Bluetooth-enabled devices.</p>
            <form action="/servletassessment/product" method="post">
         	<input type="hidden" name="username" value="<%= username %>">
        	<input type="hidden" name="productID" value=1001>
        	<button type="submit" class="buy-btn">Buy</button>
    		</form>
        </div>
        <div class="product">
            <img src="https://www.91-cdn.com/hub/wp-content/uploads/2022/12/Apple-Products-expected-to-launch-in-2023.png" alt="Product 2">
            <h3>Product 1002</h3>
            <p>Description of Product 1002..
            Stay connected and track your fitness with this stylish smartwatch. 
            It includes heart rate monitoring, GPS tracking, and customizable watch faces. 
            Syncs seamlessly with your smartphone for notifications and calls.</p>
            <form action="/servletassessment/product" method="post">
         	<input type="hidden" name="username" value="<%= username %>">
        	<input type="hidden" name="productID" value=1002>
        	<button type="submit" class="buy-btn">Buy</button>
    		</form>
        </div>
        <div class="product">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhdD6jvgV34BBMSniFkf7k-FPXhc9wBlkmuXOOxuWoMJ41yDxHFtrqgP48pXjsR8uvSrI&usqp=CAU" alt="Product 3">
            <h3>Product 1003</h3>
            <p>Description of Product 1003..
            This powerful laptop is designed for both work and play. 
            With a fast processor, ample storage, and a high-resolution display, 
            it can handle everything from graphic design to gaming. 
            Lightweight and portable for easy transport.</p>
            <form action="/servletassessment/product" method="post">
         	<input type="hidden" name="username" value="<%= username %>">
        	<input type="hidden" name="productID" value=1003>
        	<button type="submit" class="buy-btn">Buy</button>
    		</form>
        </div>
        <div class="product">
            <img src="https://static.vecteezy.com/system/resources/thumbnails/013/882/809/small/foodstuff-for-donation-storage-and-delivery-various-food-pasta-cooking-oil-and-canned-food-in-cardboard-box-photo.jpg" alt="Product 4">
            <h3>Product 1004</h3>
            <p>Description of Product 1004.. 
            Capture stunning photos and videos with this digital camera. 
            Features include a high-resolution sensor, multiple shooting modes, 
            and built-in Wi-Fi for easy sharing. Ideal for both beginners and professional photographers.</p>
            <form action="/servletassessment/product" method="post">
         	<input type="hidden" name="username" value="<%= username %>">
        	<input type="hidden" name="productID" value=1004>
        	<button type="submit" class="buy-btn">Buy</button>
    		</form>
        </div>
        <div class="product">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOuqF7574OmFxAOUrQIR3Czfl5iO7T0KnFFqDSSH6yDYCyxIpiqnQe83h8lGU4ssdjNHY&usqp=CAU" alt="Product 5">
            <h3>Product 1005</h3>
            <p>Description of Product 1005..
            Brew your perfect cup of coffee with this easy-to-use coffee maker. 
            It offers multiple brewing options, a programmable timer, 
            and a built-in grinder for fresh coffee grounds. 
            Compact design fits seamlessly into any kitchen.</p>
            <form action="/servletassessment/product" method="post">
         	<input type="hidden" name="username" value="<%= username %>">
        	<input type="hidden" name="productID" value=1005>
        	<button type="submit" class="buy-btn">Buy</button>
    		</form>
        </div>
    </div>

    <div id="popup" class="popup">
        <span class="close-btn" onclick="closePopup()">&times;</span>
        <h2>Hi.. <%= username %>  </h2>
        <p id="popup-message"></p>
    </div>
</div>

<script>
    
</script>

</body>
</html>