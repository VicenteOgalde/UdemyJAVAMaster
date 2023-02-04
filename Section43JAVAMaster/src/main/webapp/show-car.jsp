<%@page contentType="text/html" pageEncoding="UTF-8" import="cl.vicoga.webappHeaders.models.*" %>
<%
ShopCar car=(ShopCar) session.getAttribute("car");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car</title>
</head>
<body>
<h1>Shop Car</h1>
<% if(car==null || car.getShopCar().isEmpty()){ %>
<h3>No products in the car.</h3>
<%} else{%>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Total</th>
    </tr>
    <% for(ItemCar s:car.getShopCar()){ %>
     <tr>
            <td><%=s.getProduct().getId()%></td>
            <td><%=s.getProduct().getName()%></td>
            <td><%=s.getProduct().getPrice()%></td>
            <td><%=s.getNumberOfItems()%></td>
            <td><%=s.getTotal()%></td>
        </tr>
         <% } %>
         <tr>
             <td colspan="4" style="text-align:right">Car Total</td>
             <td><%=car.getTotal()%></td>
         </tr>
</table>

<%}%>
<br>
<a href="<%=request.getContextPath()%>/products.html">Product</a>
<br>
<a href="<%=request.getContextPath()%>/index.html">Home</a>
<br>
<a href="/Section43JAVAMaster/logout">Logout</a>
</body>
</html>