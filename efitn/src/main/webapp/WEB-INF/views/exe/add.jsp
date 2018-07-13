<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Exercício</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Cadastro de Exercícios</h1>
    <hr>
    <div>

		<spring:url value="/exercicio/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<spring:url value="${exercicio.id_exer == null ? '/exercicio/save' : '/exercicio/update'}" var="save"/>	
		<form:form modelAttribute="exercicio" action="${save }" method="post"> 
        <form:hidden path="id_exer"/>
            
            <div class="form-group">
                <label for="nome_exer">Nome: </label>
                <form:input path="nome_exer" class="form-control"/>
                <form:errors path="nome_exer" cssClass="label label-danger"/>                             
            </div>
            <div class="form-group">
                <label for="qtdExercicio">Quantidade: </label>
                <form:input path="qtdExercicio"  class="form-control"/>    
                <form:errors path="qtdExercicio" cssClass="label label-danger"/>          
            </div>
            <div class="form-group">
                <label for="numSeries">Número de Séries: </label>
                <form:input path="numSeries" class="form-control"/>
                <form:errors path="numSeries" cssClass="label label-danger"/>
            </div>
            <div class="form-group">
                <label for="tempDescanso">Tempo de Descanso: </label>
                <form:input path="tempDescanso" class="form-control"/>
                <form:errors path="tempDescanso" cssClass="label label-danger"/>
            </div>
                                
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Confirmar</button>
            </div>
        </form:form>
    </div>
    <hr>
    <footer class="footer">
        <p>&copy; 2018</p> 
    </footer>
</div>
</body>
</html>