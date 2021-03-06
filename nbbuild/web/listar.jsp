<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Produtos</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

	<div class="container">
	
	<!-- vamos incluir o arquivo do menu -->
	
	<%@ include file="menu.jsp" %>

		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>Listar Produtos</h1>
				</div>
			</div>
		</div>
		
		<!-- formulário para busca -->
		
		<div class="row">
			<div class="col-md-12">
				<form action="Produto" action="get">
				<input type="hidden" name="acao" value="procurar">
				
					<div class="col-md-1">
						<label for="idBusca">Buscar</label>
					</div>			
					
					<div class="col-md-3">
						<input type="text" name="procurar" placeholder="Nome do produto" class="form-control">
					</div>
					
					<div class="col-md-3">
						<input type="submit" value="Buscar" class="btn btn-primary">
					</div>			
				</form>
			</div>		
		</div>
		

		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<td>Nome</td>
                                                        <td>Cor</td>
                                                        <td>Classificação</td>
                                                        <td>genero</td>
                                                        <td>Status</td>
                                                        <td>Categoria</td>
							<td>Valor</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="item" items="${lista }">
							<tr>
								<td>${item.nome}</td>
                                                                <td>${item.valor}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>


</body>
</html>