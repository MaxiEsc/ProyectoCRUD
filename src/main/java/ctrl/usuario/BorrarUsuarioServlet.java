package ctrl.usuario;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServicioUsuario;

@WebServlet("/borrarUsuario.do")

public class BorrarUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	private ServicioUsuario servUsuario;

	@Override
	public void init() throws ServletException {
		super.init();
		this.servUsuario = new ServicioUsuario();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id_Usuario = Integer.parseInt(request.getParameter("nomIdUsuario"));

		servUsuario.eliminarUsuario(id_Usuario);

		request.setAttribute("mensINFO", "Usuario eliminado Correctamente");
		response.sendRedirect("exitoRegistro.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id_Usuario = Integer.parseInt(request.getParameter("nomIdUsuario"));

		servUsuario.eliminarUsuario(id_Usuario);

		request.setAttribute("mensINFO", "Usuario eliminado Correctamente");
		response.sendRedirect("exitoRegistro.jsp");
	}
}
