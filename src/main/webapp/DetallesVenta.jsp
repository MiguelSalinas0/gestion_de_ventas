<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<jsp:include page="partials/head.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<div class="container-fluid col-sm-7 pt-4">
		<table class="datatable table table-hover" id="tab2">
			<thead>
				<tr>
					<th>Nombre Cliente</th>
					<th>DNI</th>
					<th>Nombre Producto</th>
					<th>Cantidad</th>
					<th>Monto Total</th>
					<th>Número de Serie</th>
					<th>Fecha</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="de" items="${detalles}">
					<tr>
						<td>${de.getNombreCL()}</td>
						<td>${de.getDni()}</td>
						<td>${de.getNombrePR()}</td>
						<td>${de.getCantidad()}</td>
						<td>${de.getMonto()}</td>
						<td>${de.getNserie()}</td>
						<td>${de.getFecha()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>