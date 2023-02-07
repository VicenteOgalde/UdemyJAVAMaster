<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*, cl.vicoga.webappHeaders.models.*" %>
<%
List<Product> products=(List<Product>) request.getAttribute("products");
Optional<String> user= (Optional<String>) request.getAttribute("user");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
 <% if(user.isPresent()){%>
    <p><a href="<%=request.getContextPath()%>/products/form">Create a Product</a></p>
 <%}%>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Type</th>
        <% if(user.isPresent()){%>
        <th>Price</th>
        <th>Add</th>
        <th>Edit</th>
        <%}%>
    </tr>
    <% for(Product p:products){ %>
    <tr>

        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getType()%></td>
        <% if(user.isPresent()){%>
        <td><%=p.getPrice()%></td>
        <td><a href="<%=request.getContextPath()%>/car/add?id=<%=p.getId()%>">Add to Car</a></td>
        <td><a href="<%=request.getContextPath()%>/products/form?id=<%=p.getId()%>">Edit</a></td>
        <%}%>
    </tr>
    <%}%>
</table>

</body>
</html>