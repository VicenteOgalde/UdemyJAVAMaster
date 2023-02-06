<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
            <input type="text" id="name" name="name">
        </div>
    </div>
    <div>
        <label for="type">Type</label>
        <div>
            <input type="text" id="type" name="type">
        </div>
    </div>
    <div>
        <label for="price">Price</label>
        <div>
            <input type="number" id="price" name="price">
        </div>
    </div>
    <div><input type="submit" value="Send" ></div>


</form>

</body>
</html>