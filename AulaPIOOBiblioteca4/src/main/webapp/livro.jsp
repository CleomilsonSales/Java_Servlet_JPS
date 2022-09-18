<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
		<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
		<link rel="shortcut icon" href="icone.ico">
		<link href="style/style.css" rel="stylesheet">
		<title>Inserir/Editar Livro</title>
	</head>
	<body>
	    <div class="container">
		    <form method="POST" action="LivroController?action=listLivro&page=0" name="frmAddLivro">
			  <div class="form-group">
			    <label >ID</label>
			    <input type="text" readonly="readonly" class="form-control" name="id" 
			    	value="<c:out value="${livros.id}" />" /> <br /> 
			  </div>
			  <div class="form-group">
			    <label >Titulo</label>
			    <input type="text" class="form-control maiuscula" name="titulo"
			            value="<c:out value="${livros.titulo}" />" /> <br /> 
			  </div>
			  <div class="form-group">
			    <label >ISBN</label>
			    <input type="text" class="form-control maiuscula" name="isbn"
			            value="<c:out value="${livros.isbn}" />" /> <br /> 
			  </div>
			  <div class="form-group">
			    <label >Idioma</label>
			    <input type="text" class="form-control maiuscula" name="idioma"
			            value="<c:out value="${livros.idioma}" />" /> <br /> 
			  </div>
	
			  <button type="submit" class="btn btn-primary" value="Submit">Salvar</button>
			  <button type="button" class="btn btn-primary" 
			  onclick="window.location.href = 'http://localhost:8080/AulaPIOOBiblioteca4/LivroController?action=listLivro&page=0'">Cancelar</button>
			</form>
		
		</div>
	</body>
</html>