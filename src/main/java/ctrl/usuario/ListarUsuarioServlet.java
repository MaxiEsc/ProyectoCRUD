package ctrl.usuario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.ServicioUsuario;


@WebServlet("/GestionUsuario.do")

public class ListarUsuarioServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 1L;
	
	private ServicioUsuario servUsuarios;
	
	@Override
	public void init() throws ServletException {
		super.init();
		servUsuarios = new ServicioUsuario();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = servUsuarios.traerUsuarios();
		request.setAttribute("usu", usuarios);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestionUsuarios.jsp");
		dispatcher.forward(request, response);	
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	

}
