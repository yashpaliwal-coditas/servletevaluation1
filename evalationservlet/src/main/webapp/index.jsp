<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello World!</h1>
	<h1>Hello World!</h1>
    	<form action="hello" method="get">
            email : <input type="text" name="email"></br>
            password : <input type="password" name="pass"></br>
            name : <input type="text" name="name"></br>
            city : <input type="text" name="city"></br>
            phoneno : <input type="number" name="phoneno"></br>
            <input type="submit" name="submit"></br>
            <input type="reset" name="name"></br>
        </form>
        <form action="redirectlogin" method="get">

                    <input type="submit" name="login" value="login"></br>

                </form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
