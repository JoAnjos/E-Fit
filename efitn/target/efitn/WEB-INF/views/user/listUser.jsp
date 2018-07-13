<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Usuário</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Lista de Usuários</h1>
    <hr>


    <div class="${message == null ? 'panel-default' : 'panel-success'}">

        <div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>
        
        <div>

			<spring:url value="/usuario/cadastro" var="cadastro"/>
        	<a class="btn btn-default" href="${cadastro }">Novo Usuário</a>
        	
        	<spring:url value="/usuario/exe" var="exe"/>
        	<a class="btn btn-default" href="${exe }">Exercícios</a>
    	</div>
        

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>SENHA</th>
                <th>EMAIL</th>
                <th>CEP</th>
                <th>CIDADE</th>
                <th>ESTADO</th>
                
            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${usuarios }">
                <tr>
                    <td>${usuario.id_user }</td>
                    <td>${usuario.nome }</td>
                    <td>${usuario.senha }</td>
                    <td>${usuario.email }</td>
                    <td>${usuario.cep }</td>
                    <td>${usuario.cidade }</td>
                    <td>${usuario.estado }</td>
                    
                    <td>                        
                        
                        
                        <spring:url value="/usuario/update/${usuario.id_user }" var="update"/>
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/usuario/delete/${usuario.id_user }" var="delete"/>
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