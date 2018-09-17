<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
	<h1>Cadastro de Clientes</h1>

	<c:if test="${not empty erro}">
			<div class="alert alert-danger">
				${erro}
			</div>
	</c:if>
	<form action="clienteServlet" method="post">
		<input type="hidden" name="acao" value="cadastrar">
		<input type="hidden" name="codigo" value="${cliente.codigo }"/>
		<div class="row">
			<div class="form-group col-md-6">
				<label for="idSer">Serviço</label>
				<select id="idSer" name="ser" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${servico}" var="s">
					<c:if test="${s.codigo == cliente.codigoServico }">
						<option selected= "selected" value="${s.codigo}">${s.nome}</option>
					</c:if>
					<c:if test="${s.codigo != cliente.codigoServico }">
						<option value="${s.codigo}">${s.nome}</option>
					</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="form-group col-md-6">
				<label for="cpf">CPF</label>
				<input type="text" name="cpf" value="${cliente.cpf }"
				       class="form-control" id="cpf"
				       placeholder="Digite o CPF">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<label for="idNome">Nome</label>
				<input type="text" name="nome" value="${cliente.nome }"
				       class="form-control" id="idNome"
				       placeholder="Digite o Nome">
			</div>
			<div class="form-group col-md-6">
				<label for="data">Data de Nascimento</label>
				<input type="text" name="data"  value="<fmt:formatDate value="${cliente.dataNascimento.time }" pattern="dd/MM/yyyy" />"
					   class="form-control" id="data"
					   placeholder="Digite a Data de Nascimento">
			</div>
		</div>
		<div class="form-group">
			<label for="idEnd">Endereço</label>
			<input type="text" name="end" value="${cliente.endereco }"
			 	   class="form-control" id="idEnd"
			 	   placeholder="Digite o Endereço">
		</div>
		<div class="form-group">
			<input type="submit" value="Salvar"
			       class="btn btn-success" name="botao">
			<c:if test="${not empty cliente }">
				<a class="btn btn-danger" href="clienteServlet?acao=listar">Voltar</a>
			</c:if>
		</div>
	</form>
</div>
</body>
</html>
