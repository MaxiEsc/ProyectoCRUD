package ctrl.promocion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.ServicioPromocion;

@WebServlet("/listarPromociones.do")

public class ListarPromocionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	ServicioPromocion servPromocion;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.servPromocion = new ServicioPromocion();		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Promocion> promociones = servPromocion.traerPromociones();
		request.setAttribute("promo", promociones);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listaPromociones.jsp");
		dispatcher.forward(request, response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
	
}
