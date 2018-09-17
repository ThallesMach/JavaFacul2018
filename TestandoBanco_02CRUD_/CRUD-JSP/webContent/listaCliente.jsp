<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
<%@ include file="header.jsp" %>
</head>
<body>
	<%@ include file="menu.jsp"%>
<div class="container">
	<h1>Lista de Clientes</h1>
	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>

	<h3>Clientes por Serviço</h3>
		<form class="form-inline" action="clienteServlet" method="get">
			<input type="hidden" value="buscar" name="acao"/>

				<label>Serviço</label>
				<select name="servico" class="form-control">
				<option value="0">Escolha um Serviço</option>
				<c:forEach items="${servicos }" var="s">
				<option value="${s.codigo }"> ${s.nome } </option>
				</c:forEach>
			</select>
				<input type="submit" value="Listar" class="btn btn-success"/>

		</form>


	<h3>Lista de Clientes</h3>
	<table class="table">
		<tr>
			<th>CPF</th><th>Nome</th>
			<th>Data Nascimento</th>
			<th>Serviço</th><th>Valor do Serviço</th><th></th>
		</tr>
		<c:forEach items="${lista}" var="cliente">
			<tr>
				<td>${cliente.cpf }</td>
				<td>${cliente.nome }</td>
				<td><fmt:formatDate value="${cliente.dataNascimento.time }" pattern="dd/MM/yyyy"/></td>
				<td><c:forEach items="${servicos}" var="s">
					<c:if test="${s.codigo == cliente.codigoServico }">
						${s.nome }
					</c:if>
					</c:forEach>
				</td>
				<td><c:forEach items="${servicos }" var="s">
					<c:if test="${s.codigo == cliente.codigoServico }">
						<fmt:formatNumber value="${s.preco }" type="currency"/>
					</c:if>
					</c:forEach>
				</td>
				<td>
					<c:url value="clienteServlet" var="link1">
						<c:param name="acao" value="exibir"/>
						<c:param name="codigo" value="${cliente.codigo }"/>
					</c:url>
					<a href="${link1}" class="btn btn-info">Alterar</a>
					<c:url value="clienteServlet" var="link">
						<c:param name="acao" value="remover"/>
						<c:param name="codigo" value="${cliente.codigo }"/>
					</c:url>
					<a class="btn btn-danger" href="${link}">Remover</a>
				</td>

			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>
