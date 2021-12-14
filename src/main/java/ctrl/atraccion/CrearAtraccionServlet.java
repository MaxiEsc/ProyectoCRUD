package ctrl.atraccion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.ServicioAtraccion;

@WebServlet("/altaAtracciones.do")

public class CrearAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	
	private ServicioAtraccion servAtraccion;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.servAtraccion = new ServicioAtraccion();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("altaAtraccion.jsp");
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nomAtraccion");
		Integer valor = Integer.parseInt(request.getParameter("numValor"));
		Double duracion = Double.parseDouble(request.getParameter("numDuracion"));
		Integer cupo = Integer.parseInt(request.getParameter("numCupo"));
		
		Atraccion aux = servAtraccion.crearAtraccion(nombre, valor, duracion, cupo);
		
		if(aux.esValido()) {
			request.setAttribute("mensINFO", "Usuario Creado Correctamente");
			response.sendRedirect("exitoRegistro.jsp");
		}else {
			request.setAttribute("atraccion", aux);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("altaAtraccion.jsp");
			dispatcher.forward(request, response);
		}		
	}
	
}
