<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Usuário</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
    
</head>
<body>
<div class="container">
    <h1>Cadastro de Usuários</h1>
    <hr>
    <div>

		<spring:url value="/usuario/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<spring:url value="${usuario.id_user == null ? '/usuario/save' : '/usuario/update'}" var="save"/>	
		<form:form modelAttribute="usuario" action="${save }" method="post"> 
        <form:hidden path="id_user"/>
            
            <div class="form-group">
                <label for="nome">Nome: </label>
                <form:input path="nome" class="form-control"/>
                <form:errors path="nome" cssClass="label label-danger"/>  
                             
            </div>
            <div class="form-group">
                <label for="senha">Senha: </label>
                <form:input path="senha"  class="form-control"/>    
				<form:errors path="senha" cssClass="label label-danger"/>                          
            </div>
            <div class="form-group">
                <label for="email">E-mail: </label>
                <form:input path="email" class="form-control"/>
                <form:errors path="email" cssClass="label label-danger"/>
            </div>
            <div class="form-group">
                <label for="cep">CEP: </label>
                <form:input path="cep" class="form-control"/>
                <form:errors path="cep" cssClass="label label-danger"/>
            </div>
            <div class="form-group">
                <label for="cidade">Cidade: </label>
                <form:input path="cidade" class="form-control"/>
                <form:errors path="cidade" cssClass="label label-danger"/>
            </div>                    
            <div class="form-group">
                <label for="estado">Estado: </label>
                <form:input path="estado" class="form-control"/>
                <form:errors path="estado" cssClass="label label-danger"/>
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