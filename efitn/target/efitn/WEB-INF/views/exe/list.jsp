<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Exercícios</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Lista de Exercícios</h1>
    <hr>


    <div class="${message == null ? 'panel-default' : 'panel-success'}">

        <div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>
        
        <div>

			<spring:url value="/exercicio/cadastro" var="cadastro"/>
        	<a class="btn btn-default" href="${cadastro }">Novo Exercício</a>
        	
        	<spring:url value="/exercicio/user" var="user"/>
        	<a class="btn btn-default" href="${user }">Usuários</a>
    	</div>
        

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>QUANTIDADE</th>
                <th>SERIES</th>
                <th>DESCANSO</th>                    
            </tr>
            </thead>
            <tbody>
            <c:forEach var="exercicio" items="${exercicios }">
                <tr>
                    <td>${exercicio.id_exer }</td>
                    <td>${exercicio.nome_exer }</td>
                    <td>${exercicio.qtdExercicio }</td>
                    <td>${exercicio.numSeries }</td>
                    <td>${exercicio.tempDescanso }</td>
                    <td>                        
                        
                        
                        <spring:url value="/exercicio/update/${exercicio.id_exer }" var="update"/>
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/exercicio/delete/${exercicio.id_exer }" var="delete"/>
                        <a class="btn btn-danger" href="${delete }" >Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <hr>
    <footer class="footer">
        <p>&copy; 2018</p>
    </footer>
</div>
</body>
</html>