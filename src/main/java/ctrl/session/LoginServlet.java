package ctrl.session;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Usuario;
import services.ServicioUsuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4725251482440438311L;
	
	ServicioUsuario uServicio;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		uServicio = new ServicioUsuario();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreUsuario = request.getParameter("nameReg");
		String contrasenia = request.getParameter("passReg");
		Usuario usuario = null;
		usuario = uServicio.encontrarNombre(nombreUsuario);
				
		if(nombreUsuario.equals("admin") && contrasenia.equals("admin777root")) {
			request.getSession().setAttribute("usuario", nombreUsuario);
			response.sendRedirect("exitoRegistro.jsp");
		}else if(nombreUsuario.equals(contrasenia) && usuario != null){
			request.getSession().setAttribute("usuario", nombreUsuario);
			response.sendRedirect("exitoRegistro.jsp");
			
		}else {			
			request.setAttribute("mensaje", "Nombre de usuario o contraseña incorectos");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ingresarUsuario.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
