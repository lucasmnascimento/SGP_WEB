<!-- para o menu vamos adicionar tamb�m o js do bootstrap e jQuery -->

<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<!-- c�digo do menu (navbar)
existem v�rias classes do navbar, vou pegar no site do bootstrap
� basicamente um ctrl+c ctrl+v 
 -->

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">SGP</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Produto <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrar.jsp">Cadastrar</a></li>
						<c:url var="listagem" value="Produto">
							<c:param name="acao" value="listar"></c:param>
						</c:url>
						<li><a href="${listagem }">Listar</a></li>
					</ul></li>
                                        
                                <li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Cliente <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrar.jsp">Cadastrar</a></li>
						<c:url var="listagem" value="Produto">
							<c:param name="acao" value="listar"></c:param>
						</c:url>
						<li><a href="${listagem }">Listar</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>