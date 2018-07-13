<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Exercícios do Usuário</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Lista de Exercícios do Usuário</h1>
    <hr>


        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>NOME</th>
                <th>NOME EXERCICIO</th>
                <th>QUANTIDADE</th>
                <th>SERIES</th>
                <th>DESCANSO</th>
                
            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${usuarios }">
                <tr>
                    <td>${usuario.nome }</td>

                </tr>
            </c:forEach>
            <c:forEach var="exercicio" items="${exercicios }">
                <tr>
                    <td>${exercicio.nome_exer }</td>
                    <td>${exercicio.qtdExercicio }</td>
                    <td>${exercicio.numSeries }</td>
                    <td>${exercicio.tempDescanso }</td>
               </tr>
            </c:forEach>
            </tbody>
        </table>
    <spring:url value="/exercicio/user" var="user"/>
   	<a class="btn btn-default" href="${user }">Voltar</a>
    <hr>
    <footer class="footer">
        <p>&copy; 2018</p>
    </footer>
</div>
</body>
</html>