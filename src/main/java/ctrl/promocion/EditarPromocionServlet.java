package ctrl.promocion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.ServicioPromocion;

@WebServlet("/modificarPromocion.do")

public class EditarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	private ServicioPromocion servPromocion;

	@Override
	public void init() throws ServletException {
		super.init();
		this.servPromocion = new ServicioPromocion();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("modificarPromocion.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id_promocion = Integer.parseInt(request.getParameter("numIdPromocion"));
		String nombre = request.getParameter("nomPromocion");
		String tipo = request.getParameter("nomTipo");
		Double descuento = Double.parseDouble(request.getParameter("numDescuento"));
		Integer precio = Integer.parseInt(request.getParameter("numPrecio"));
		Integer atraccionId = Integer.parseInt(request.getParameter("numAtraccion_Id_Gratis"));

		Promocion aux = servPromocion.editarPromocion(id_promocion, nombre, tipo, descuento, precio, atraccionId);

		if (aux.esValido()) {
			request.setAttribute("mensINFO", "Promocion EDITADA Correctamente");
			response.sendRedirect("exitoRegistro.jsp");
		} else {
			request.setAttribute("promocion", aux);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("modificarPromocion.jsp");
			dispatcher.forward(request, response);
		}
	}

}
