<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Produto</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

<div class="container">

	<!-- vamos incluir o arquivo do menu -->
	
	<%@ include file="menu.jsp" %>

	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>Cadastrar Produto</h1></div>
		</div>
	</div>
	
	<!-- nossa mensagem de sucesso ou erro -->
	<div class="row">
		<div class="col-md-12">
			<div class="${tipoMensagem }">
				<p>${mensagem }</p>
				<!-- vamos adicionar a mensagem de erro da Exception -->
				<p>${erro }</p>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<!-- o action do form deve ser o configurado no servlet 
			method � o doPost ou doGet
			-->
			<form action="Produto" method="post">
			
			<!-- input hidden com a acao e qual a��o faremos -->
				<input type="hidden" name="acao" value="cadastrar">
				<div class="form-group">
					<label for="idNome">Nome</label>
					<!-- n�o esquecer de colocar a propriedade name -->
					<input type="text" id="idNome" name="nome" class="form-control">
				</div>
                                
                                <div class="form-group">
					<label for="idCodigo">C�digo</label>
					<!-- n�o esquecer de colocar a propriedade name -->
					<input type="text" id="idCodigo" name="codigo" class="form-control">
				</div>
                                
                                <div class="form-group">
					<label for="idCor">Cor</label>
					<!-- n�o esquecer de colocar a propriedade name -->
					<input type="text" id="idCor" name="cor" class="form-control">
				</div>
                                
                                <div class="form-group">
                                    <label for="idCor">Foto</label>
                                <div class="input-group col-xs-12">
                                   
                                    <input type="text" class="form-control input-lg" disabled placeholder="Escolha o arquivo">
                                    
                                    <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> Pesquisar</button>
                                    
                                </div>
                                </div>


                                
                                <div class="form-group">
                                <label for="idFaixaClass">Faixa de Classifica��o</label>
                                <select class="form-control" id="idFaixaClass">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                </select>
                                </div>
                                
                                <div class="form-group">
                                <label for="idFaixaClass">Genero</label>
                                <select class="form-control" id="idGenero">
                                <option value="1">Masculino</option>
                                <option value="2">Feminimo</option>
                                </select>
                                </div>
                                
                                <div class="form-group">
                                <label for="idFaixaClass">Status</label>
                                <select class="form-control" id="idStatus">
                                <option value="0">Ativo</option>
                                <option value="1">Inativo</option>
                                </select>
                                </div>
                                
                                <div class="form-group">
                                <label for="idFaixaClass">Categoria</label>
                                <select class="form-control" id="idCategoria">
                                <option value="1">sei</option>
                                <option value="2">la</option>
                                </select>
                                </div>
                                
                                
				<div class="form-group">
					<label for="idValor">Valor</label>
					<!-- n�o esquecer de colocar a propriedade name -->
					<input type="number" step="0.10" id="idValor" name="valor" class="form-control">
				</div>
				<div class="form-group">
					<input type="submit" value="Salvar" class="btn btn-primary">
					<input type="reset" value="Limpar" class="btn btn-danger">
				</div>
			</form>
			
		</div>
		<%-- <!-- para mandar a acao devemos passar pela URL -->
		<c:url var="link" value="Produto">
			<c:param name="acao" value="listar"></c:param>
		</c:url>
		
		<!-- no pr�ximo v�deo faremos um menu -->
		<a href="${link }" class="btn btn-success">Listar</a> --%>
	</div>
	
</div>

</body>
</html>