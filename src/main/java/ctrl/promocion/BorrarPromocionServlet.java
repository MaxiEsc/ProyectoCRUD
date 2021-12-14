package ctrl.promocion;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServicioPromocion;

@WebServlet("/borrarPromociones.do")

public class BorrarPromocionServlet extends HttpServlet implements Servlet {

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

		Integer id_Promocion = Integer.parseInt(request.getParameter("numIdPromocion"));

		servPromocion.eliminarPromocion(id_Promocion);

		request.setAttribute("mensINFO", "Promocion eliminada Correctamente");
		response.sendRedirect("exitoRegistro.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id_Promocion = Integer.parseInt(request.getParameter("numIdPromocion"));

		servPromocion.eliminarPromocion(id_Promocion);

		request.setAttribute("mensINFO", "Promocion eliminada Correctamente");
		response.sendRedirect("exitoRegistro.jsp");
	}
}
