package controller.nuevaventa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import config.GenerarSerie;
import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

@WebServlet("/nuevaventa")
public class NuevaVentaServlet extends HttpServlet {

	private static final long serialVersionUID = 5660090281862259818L;

	Cliente cl = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
	Producto pr = new Producto();
	ProductoDAO pdao = new ProductoDAO();
	Integer idc;
	Integer idp;
	
	Venta v = new Venta();
	List<Venta> lista = new ArrayList<>();
	Integer item = 0;
	Integer cod;
	String descripcion;
	Double precio;
	Integer cantidad;
	Double subtotal;
	Double totalPagar;

	String numeroserie;
	VentaDAO vdao = new VentaDAO();

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		switch (accion) {
		case "Buscar Cliente":
			String dni = request.getParameter("codigoCliente");
			cl.setDni(dni);
			cl = cdao.buscar(dni);
			request.setAttribute("cliente", cl);
			request.setAttribute("nserie", numeroserie);
			break;
		case "Buscar Producto":
			idp = Integer.parseInt(request.getParameter("codigoProducto"));
			pr = pdao.buscar(idp);
			request.setAttribute("producto", pr);
			request.setAttribute("lista", lista);
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("cliente", cl);
			request.setAttribute("nserie", numeroserie);
			break;
		case "Agregar":
			totalPagar = 0.0;
			item = item + 1;
			cod = pr.getIdProducto();
			descripcion = request.getParameter("nombreproducto");
			precio = Double.parseDouble(request.getParameter("precio"));
			cantidad = Integer.parseInt(request.getParameter("cantidad"));
			subtotal = precio * cantidad;
			v = new Venta();
			v.setItem(item);
			v.setIdproducto(cod);
			v.setDescripcionP(descripcion);
			v.setPrecio(precio);
			v.setCantidad(cantidad);
			v.setSubtotal(subtotal);
			lista.add(v);
			for (int i = 0; i < lista.size(); i++) {
				totalPagar += lista.get(i).getSubtotal();
			}
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("lista", lista);
			request.setAttribute("cliente", cl);
			request.setAttribute("nserie", numeroserie);
			break;
		case "GenerarVenta":
			for (int i = 0; i < lista.size(); i++) {
				Producto pr = new Producto();
				int cantidad = lista.get(i).getCantidad();
				int idproducto = lista.get(i).getIdproducto();
				ProductoDAO pdao = new ProductoDAO();
				pr = pdao.buscar(idproducto);
				int sac = pr.getStock() - cantidad;
				pdao.actualizarStock(idproducto, sac);
			}
			v.setIdcliente(cl.getIdCliente());
			v.setIdempleado(2);
			v.setNumserie(numeroserie);
			java.util.Date ahora = new java.util.Date();
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			v.setFecha(formateador.format(ahora));
			v.setMonto(totalPagar);
			v.setEstado("1");
			vdao.guardarVenta(v);
			int idv = Integer.parseInt(vdao.IdVentas());
			for (int i = 0; i < lista.size(); i++) {
				v = new Venta();
				v.setId(idv);
				v.setIdproducto(lista.get(i).getIdproducto());
				v.setCantidad(lista.get(i).getCantidad());
				v.setPrecio(lista.get(i).getPrecio());
				vdao.guardarDetalleventas(v);
			}
			request.setAttribute("nserie", numeroserie);
			break;
		default:
			v = new Venta();
			lista = new ArrayList<>();
			item = 0;
			totalPagar = 0.0;
			numeroserie = vdao.GenerarSerie();
			if (numeroserie == null) {
				numeroserie = "00000001";
				request.setAttribute("nserie", numeroserie);
			} else {
				Integer incrementar = Integer.parseInt(numeroserie);
				GenerarSerie gs = new GenerarSerie();
				numeroserie = gs.NumeroSerie(incrementar);
				request.setAttribute("nserie", numeroserie);
			}
			
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/NuevaVenta.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
