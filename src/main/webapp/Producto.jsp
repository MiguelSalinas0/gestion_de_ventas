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

	<div class="d-flex justify-content-around pt-3">
		<div class="card col-sm-4">
			<div class="card-body">
				<form class="needs-validation" action="/GestionDeVentas/producto/createupdate" method="post">
					<div class="form-group pt-2">
						<label class="form-label" for="nombre">Nombre</label> <input required id="nombre" type="text"
							value="${producto.getNombres()}" name="txtNombre"
							class="form-control">
					</div>
					<div class="form-group pt-2">
						<label class="form-label" for="precio">Precio</label> <input required id="precio" type="text"
							value="${producto.getPrecio()}" name="txtPrecio"
							class="form-control">
					</div>
					<div class="form-group pt-2">
						<label class="form-label" for="stock">Stock</label> <input required id="stock" type="text"
							value="${producto.getStock()}" name="txtStock"
							class="form-control">
					</div>
					<div class="form-group pt-2 pb-3">
						<label class="form-label" for="estado">Estado</label> <input required id="estado" type="text"
							value="${producto.getEstado()}" name="txtEstado"
							class="form-control">
					</div>
					<div>
						<label></label> <input required type="hidden"
							value="${producto.getIdProducto()}" name="txtID"
							class="form-control">
					</div>
					<input type="submit" name="accion" value="Agregar"
						class="btn btn-info"> <input type="submit" name="accion"
						value="Actualizar" class="btn btn-success">
				</form>
			</div>
		</div>

		<div class="col-sm-7">
			<table class="datatable table table-hover" id="tab2">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRES</th>
						<th>PRECIO</th>
						<th>STOCK</th>
						<th>ESTADO</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pr" items="${productos}">
						<tr>
							<td>${pr.getIdProducto()}</td>
							<td>${pr.getNombres()}</td>
							<td>${pr.getPrecio()}</td>
							<td>${pr.getStock()}</td>
							<td>${pr.getEstado()}</td>
							<td><a class="btn btn-warning"
								href="/GestionDeVentas/producto/edit?id=${pr.getIdProducto()}">Editar</a>
								<a class="btn btn-danger"
								href="/GestionDeVentas/producto/delete?id=${pr.getIdProducto()}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>