package ctrl.atraccion;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServicioAtraccion;

@WebServlet("/borrarAtracciones.do")

public class BorrarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

private ServicioAtraccion servAtraccion;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.servAtraccion = new ServicioAtraccion();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id_Atraccion = Integer.parseInt(request.getParameter("numIdAtraccion"));
		
		servAtraccion.eliminarAtraccion(id_Atraccion);
		
		request.setAttribute("mensINFO", "Atraccion eliminada Correctamente");
		response.sendRedirect("/exitoRegistro.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Integer id_Atraccion = Integer.parseInt(request.getParameter("numIdAtraccion"));
		
		servAtraccion.eliminarAtraccion(id_Atraccion);
		
		request.setAttribute("mensINFO", "Atraccion eliminada Correctamente");
		response.sendRedirect("exitoRegistro.jsp");
	}
	
}
