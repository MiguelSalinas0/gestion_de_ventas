<meta charset="UTF-8" />
<title>Ventas</title>

<link rel="shortcut icon" href="/GestionDeVentas/assets/favicon.png"/>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css" />

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>

<script defer src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script defer type="text/javascript" src="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.js"></script>

<script type="text/javascript" src="js/script.js"></script>

<script type="text/javascript">

window.addEventListener("DOMContentLoaded", function () {
	$("#tab2").DataTable({
		pageLength: 25,
		pagingType: "full_numbers",
		language: {
			decimal: ",",
			emptyTable: "No hay información",
			info: "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
			infoEmpty: "Mostrando 0 to 0 of 0 Entradas",
			infoFiltered: "(Filtrado de _MAX_ total entradas)",
			infoPostFix: "",
			thousands: ".",
			lengthMenu: "Mostrar _MENU_ Entradas",
			loadingRecords: "Cargando...",
			processing: "Procesando...",
			search: "Buscar:",
			zeroRecords: "Sin resultados encontrados",
			paginate: {
				first: "Primero",
				last: "Ultimo",
				next: "Siguiente",
				previous: "Anterior",
			},
		},
		// Opciones
	});
});

</script>