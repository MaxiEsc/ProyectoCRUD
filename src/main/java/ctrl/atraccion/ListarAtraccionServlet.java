package ctrl.atraccion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.ServicioAtraccion;

@WebServlet("/listarAtracciones.do")

public class ListarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	private ServicioAtraccion servAtraccion;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.servAtraccion = new ServicioAtraccion();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Atraccion> atraccioneLista = servAtraccion.trearAtracciones();				
		request.setAttribute("atracciones", atraccioneLista);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listaAtracciones.jsp");
		dispatcher.forward(request, response);
				
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
