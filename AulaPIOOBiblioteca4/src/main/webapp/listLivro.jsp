<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Livros Cadastrados</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
		<link href="style/style.css" rel="stylesheet">
	</head>
<body>
	<div class="container">
		<div>Pós Graduação: Engenharia de Software - ESTACIO</div>
		<div>Disciplina: PROJETO E IMPLEMENTAÇÃO ORIENTADO A OBJETOS - ESTACIO</div>
		<div>Alunos: Antonio Cleomilson Gomes Sales - mat.: 202110129805</div>
		<br>
	    <table border=1 class="table table-striped">
	        <thead>
	            <tr>
	                <th>Id</th>
	                <th>Titulo</th>
	                <th>ISBN</th>
	                <th>Idioma</th>
	                <th colspan=2>Ações</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${livros}" var="livro">
	                <tr>
	                    <td><c:out value="${livro.id}" /></td>
	                    <td class="maiuscula"><c:out value="${livro.titulo}" /></td>
	                    <td class="maiuscula"><c:out value="${livro.isbn}" /></td>
	                    <td class="maiuscula"><c:out value="${livro.idioma}" /></td>
	                    <td>
	                    	<a class="btn btn-warning" role="button" href="LivroController?action=edit&page=0&id=<c:out value="${livro.id}"/>">Atualizar</a>
	                    </td>
	                    <td>
	                    	<a class="btn btn-danger" role="button" href="LivroController?action=delete&page=0&id=<c:out value="${livro.id}"/>">Deletar</a>
	                    </td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    
	    <nav aria-label="Navegação de página exemplo">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="LivroController?action=listLivro&page=<c:out value="${ant}" />">Anterior</a></li>
		    <li class="page-item"><a class="page-link" href="LivroController?action=listLivro&page=<c:out value='${prox != null ? prox : "1"}'/>">Próximo</a></li>
		  </ul>
		</nav>
	    
	    <div class="d-grid gap-2">
	     	<a class="btn btn-primary" href="LivroController?action=insert&page=0" role="button">Adicionar Livros</a>
	     </div>
	  </div>
	  <br>
	</body>
</html>