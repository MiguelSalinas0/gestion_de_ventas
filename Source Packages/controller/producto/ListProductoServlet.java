package controller.producto;

import java.io.IOException;
import java.util.List;

import modelo.Producto;
import modelo.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/producto")
public class ListProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;

	ProductoDAO pdao = new ProductoDAO();

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Producto> lista = pdao.Listar();
		request.setAttribute("productos", lista);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Producto.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
