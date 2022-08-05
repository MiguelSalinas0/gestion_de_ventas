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

@WebServlet("/producto/delete")
public class DeleteProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 5903002766377479263L;
	
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

		idp = Integer.parseInt(request.getParameter("id"));
		pdao.Delete(idp);

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
