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
		<div class="col-sm-4 parte1">
			<div class="card">
				<form class="needs-validation" action="/GestionDeVentas/nuevaventa"
					method="post">
					<div class="card-body">
						<div class="form-group">
							<label for="datosCL" class="pb-2">Datos del Cliente</label>
						</div>
						<div class="form-group d-flex justify-content-around">
							<div class="col-sm-6 d-flex">
								<input id="datosCL" type="text" name="codigoCliente"
									class="form-control" placeholder="Codigo"
									value="${cliente.getDni()}"> <input type="submit"
									name="accion" value="Buscar Cliente"
									class="btn btn-outline-info">
							</div>
							<div class="col-sm-5">
								<input type="text" name="nombresClientes"
									placeholder="Datos Cliente" class="form-control col-sm-6"
									value="${cliente.getNombres()}">
							</div>
						</div>
						<div class="form-group">
							<label for="datosPR" class="pt-2 pb-2">Datos producto</label>
						</div>
						<div class="form-group d-flex justify-content-around">
							<div class="col-sm-6 d-flex">
								<input id="datosPR" type="text" name="codigoProducto"
									class="form-control" placeholder="Codigo"
									value="${producto.getIdProducto()}">
								<button type="submit" name="accion" value="Buscar Producto"
									class="btn btn-outline-info">Buscar</button>
							</div>
							<div class="col-sm-5">
								<input type="text" name="nombreproducto"
									placeholder="Datos Producto" class="form-control col-sm-6"
									value="${producto.getNombres()}">
							</div>
						</div>
						<div class="form-group d-flex justify-content-around pt-3">
							<div class="col-sm-6 d-flex">
								<input type="text" name="precio" class="form-control"
									value="${producto.getPrecio()}" placeholder="s/.0.00">
							</div>
							<div class="col-sm-2">
								<input type="number" name="cantidad" value="1"
									class="form-control col-sm-6">
							</div>
							<div class="col-sm-3">
								<input type="text" name="stock" placeholder="stock"
									value="${producto.getStock()}" class="form-control col-sm-6">
							</div>
						</div>
						<div class="form-group pt-3">
							<button type="submit" name="accion" value="Agregar"
								class="btn btn-outline-info">Agregar Producto</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="card">
				<div class="card-body d-flex justify-content-end">
					<div class="d-flex col-sm-6 ml-auto">
						<label>Nro. Serie: </label> <input type="text" name="NroSerie"
							value="${nserie}" class="form-control">
					</div>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nro</th>
							<th>Codigo</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Cantidad</th>
							<th>SubTotal</th>
							<th class="acciones">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${lista}">
							<tr>
								<td>${list.getItem()}</td>
								<td>${list.getIdproducto()}</td>
								<td>${list.getDescripcionP()}</td>
								<td>${list.getPrecio()}</td>
								<td>${list.getCantidad()}</td>
								<td>${list.getSubtotal()}</td>
								<td><a href="#" class="btn btn-warning">Editar</a> <a
									href="#" class="btn btn-danger">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card-footer d-flex">
				<form action="/GestionDeVentas/nuevaventa" method="post">
					<div class="col-sm-12">
						<button type="submit" name="accion" value="GenerarVenta"
							class="btn btn-success">Generar Venta</button>
						<button type="submit" name="accion" value="CancelarVenta"
							class="btn btn-danger">Cancelar</button>
					</div>
				</form>
			</div>
			<div class="col-sm-6 ml-auto">
				<input type="text" name="txtTotal" value="S/. ${totalPagar}0"
					class="form-control">
			</div>
		</div>
	</div>

</body>
</html>