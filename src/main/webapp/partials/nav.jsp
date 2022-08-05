<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-light bg-info">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?menu=Home"
					target="myFrame">Home</a></li>
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="/GestionDeVentas/producto">Producto</a></li>
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="ventas/producto?accion=Listar"
					target="myFrame">Empleado</a></li>
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?menu=Clientes"
					target="myFrame">Clientes</a></li>
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light"
					href="/GestionDeVentas/nuevaventa?accion=default">Nueva Venta</a></li>
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light"
					href="/GestionDeVentas/detalles">Detalles Ventas</a></li>
			</ul>
			<div class="dropdown">
				<button style="border: none"
					class="btn btn-outline-light dropdown-toggle pl-5" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">${usuario.getNombre()}</button>
				<div class="dropdown-menu text-center"
					aria-labelledby="dropdownMenuButton1">
					<a class="dropdown-item" href="#"> aca imagen <img alt=""
						src="">
					</a> <a class="dropdown-item" href="#">${usuario.getUsuario()}</a> <a
						class="dropdown-item" href="#">usuario@gmail.com</a>
					<div class="dropdown-divider"></div>
					<form action="Validar" method="post">
						<button name="accion" value="Salir" class="dropdown-item">Salir</button>
					</form>
				</div>
			</div>
		</div>

	</div>
</nav>