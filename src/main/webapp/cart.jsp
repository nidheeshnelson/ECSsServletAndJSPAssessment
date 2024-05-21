    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 50px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .center {
            text-align: center;
        }
        .right {
            text-align: right;
        }
        td .buy-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
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
        @media (max-width: 768px) {
            .container {
                width: 95%;
                margin: 20px auto;
            }
            th, td {
                padding: 8px;
            }
        }
    </style>
</head>
<body>
<%
        String username = (String) session.getAttribute("username");
        
    %>
    <%
        String message = (String) session.getAttribute("message1");
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
        <h1>Hii ${username}.. This is Your Cart</h1>
        <div class="nav">
        <h4><a class="inactive" href="/servletassessment/signin?username=${username}">Home</a></h4>
    	<h4><a class="inactive" href="signin.jsp">SignOut</a></h4>
    	<h4><a id="active1" href="">Cart</a></h4>
    	<h4><a class="inactive" href="/servletassessment/order?username=${username}">Order</a></h4>
	</div>
        <table>
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th class="right">Price</th>
                    <th class="right">GST</th>
                    <th class="right">Offer</th>
                    <th class="right">Rate</th>
                    <th class="center">Count</th>
                    <th class="center">Total Amount</th>
                    <th class="center">Payment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.productID}</td>
                        <td>${product.productName}</td>
                        <td>${product.productDescription}</td>
                        <td class="right">${product.productPrice}</td>
                        <td class="right">${product.gst}</td>
                        <td class="right">${product.offer}</td>
                        <td class="right">${product.netPrice}</td>
                        <td class="center">${product.count}</td>
                        <td class="center">${product.netPrice*product.count}</td>
                        <td class="center">
                        	<form action="/servletassessment/order" method="post">
         						<input type="hidden" name="username" value="${username}">
                                <input type="hidden" name="productID" value="${product.productID}">
                                <input type="hidden" name="productName" value="${product.productName}">
                                <input type="hidden" name="netPrice" value="${product.netPrice}">
                                <input type="hidden" name="quantity" value="${product.count}">
                                <input type="hidden" name="totalAmount" value="${product.netPrice*product.count}">
                                <button type="submit" class="buy-btn">Buy</button>
    						</form>
    					</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>