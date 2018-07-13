<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>E-Fit</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>E-Fit</h1>
    <hr>

        <div>

        	<spring:url value="/exercicio/user" var="user"/>
        	<a class="btn btn-default" href="${user }">Entrar</a>
        	
			<spring:url value="/usuario/cadastro" var="cadastro"/>
        	<a class="btn btn-default" href="${cadastro }">Cadastrar Usuário</a>
        	

    	</div>

  
    <hr>
    <footer class="footer">
        <p>&copy; 2018</p>
    </footer>
</div>
</body>
</html>