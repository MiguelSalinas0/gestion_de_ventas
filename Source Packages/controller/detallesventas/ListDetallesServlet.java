package controller.detallesventas;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DetalleVenta;
import modelo.DetalleVentaDAO;

@WebServlet("/detalles")
public class ListDetallesServlet extends HttpServlet{

	private static final long serialVersionUID = 6699849795052822713L;
	
	DetalleVentaDAO dvo = new DetalleVentaDAO();
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DetalleVenta> lista = dvo.Listar();
		request.setAttribute("detalles", lista);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DetallesVenta.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
