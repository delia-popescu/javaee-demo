<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>New person</h1>
<form method="post" action="jaxrs/persons/create">
    Name: <input type="text" name="name"/><br/>
    Age: <input type="text" name="age"/><br/>
    <input type="submit" value="Create person"/>
</form>
</body>
</html>
