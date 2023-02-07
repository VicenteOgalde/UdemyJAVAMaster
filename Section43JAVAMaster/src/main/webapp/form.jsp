<%@page contentType="text/html" pageEncoding="UTF-8"
 import="java.util.*, cl.vicoga.webappHeaders.models.*" %>
 <%
  Map <String,String> errors=(Map<String,String>)request.getAttribute("errors");
  Product p=(Product) request.getAttribute("product");
  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Form</title>
</head>
<body>
<h1>Product Form</h1>
<form action="<%=request.getContextPath()%>/products/form" method="post">


    <div>
        <label for="name">Name</label>
        <div>
            <input type="text" id="name" name="name" value="<%=p.getName()!=null?p.getName():""%>">
        </div>
       <% if(errors!=null&&errors.containsKey("name")){%>
       <div style="color:red;"><%=errors.get("name")%></div>
        <%}%>
    </div>
    <div>
        <label for="type">Type</label>
        <div>
            <input type="text" id="type" name="type"  value="<%=p.getType()!=null?p.getType():""%>">
        </div>
        <% if(errors!=null&&errors.containsKey("type")){%>
               <div style="color:red;"><%=errors.get("type")%></div>
                <%}%>
    </div>
    <div>
        <label for="price">Price</label>
        <div>
            <input type="number" id="price" name="price"  value="<%=p.getPrice()!=0?p.getPrice():""%>">
        </div>
         <% if(errors!=null&&errors.containsKey("price")){%>
                       <div style="color:red;"><%=errors.get("price")%></div>
                        <%}%>
    </div>
    <div><input type="submit" value="Send" ></div>


</form>

</body>
</html>