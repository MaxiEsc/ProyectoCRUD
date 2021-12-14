package ctrl.usuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.ServicioUsuario;

@WebServlet("/modificarUsuario.do")


public class EditarUsuarioServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 1L;
	
	private ServicioUsuario servUsuario;

	@Override
	public void init() throws ServletException {
		super.init();
		this.servUsuario = new ServicioUsuario();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("modificarUsuario.jsp");
		dispatcher.forward(request, response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id_usuario = Integer.parseInt(request.getParameter("nomIdUsuario"));
		String nombre_completo = request.getParameter("nomUsuario");
		Integer monedas = Integer.parseInt(request.getParameter("nomMonedas"));
		Double tiempo = Double.parseDouble(request.getParameter("numTiempo"));

		Usuario aux = servUsuario.editarUsuario(id_usuario, nombre_completo, monedas, tiempo);
		
		if(aux.esValido()) {
			request.setAttribute("mensINFO", "Usuario EDITADO Correctamente");
			response.sendRedirect("exitoRegistro.jsp");
		}else {
			request.setAttribute("atraccion", aux);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("modificarUsuario.jsp");
			dispatcher.forward(request, response);
		}		
	}

}
