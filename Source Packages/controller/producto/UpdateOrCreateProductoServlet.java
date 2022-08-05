package controller.producto;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoDAO;

@WebServlet("/producto/createupdate")
public class UpdateOrCreateProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 4123567154846698726L;

	Producto pr = new Producto();
	ProductoDAO pdao = new ProductoDAO();
	Integer idp;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		String nom1 = request.getParameter("txtNombre");
		Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		Integer stock = Integer.parseInt(request.getParameter("txtStock"));
		String estado = request.getParameter("txtEstado");
		pr.setNombres(nom1);
		pr.setPrecio(precio);
		pr.setStock(stock);
		pr.setEstado(estado);
		
		if (accion.equals("Actualizar")) {
			idp = Integer.parseInt(request.getParameter("txtID"));
			pr.setIdProducto(idp);
			pdao.Actualizar(pr);
		}

		if (accion.equals("Agregar")) {
			pdao.Agregar(pr);
		}

		List<Producto> lista = pdao.Listar();
		request.setAttribute("productos", lista);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Producto.jsp");
		dispatcher.forward(request, response);

	}
}
