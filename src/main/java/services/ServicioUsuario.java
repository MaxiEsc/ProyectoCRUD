package services;

import java.util.*;

import model.Usuario;
import persistance.UsuarioDAO;
import persistence.commons.FabricaDAO;

public class ServicioUsuario {

	public Usuario encontrarNombre(String nombreUsuario) {
		return FabricaDAO.obtenerUsuarioDAO().encontrarNombre(nombreUsuario);
	}
	
	public List<Usuario> traerUsuarios(){
		return FabricaDAO.obtenerUsuarioDAO().traerTodos();
	}
	
public Usuario crearUsuario(String nombre_completo, Integer monedas, Double tiempo) {
		
		Usuario aux = new Usuario(nombre_completo, monedas, tiempo);
		
		if(aux.esValido()) {
			UsuarioDAO usuarioDAO = FabricaDAO.obtenerUsuarioDAO();
			usuarioDAO.agregar(aux);
		}
		return aux;
	}
	
	public Usuario editarUsuario(Integer id_Usuario, String nombre_completo, Integer monedas, Double tiempo) {
		
		UsuarioDAO usuarioDAO = FabricaDAO.obtenerUsuarioDAO();
		Usuario aux = usuarioDAO.encontrar(id_Usuario);
		
		aux.setNombre_completo(nombre_completo);
		aux.setMonedas(monedas);
		aux.setTiempo(tiempo);
		
		if(aux.esValido()) {
			usuarioDAO.modificar(aux);
		}		
		
		return aux;
	}
	
	public void eliminarUsuario(Integer id_Usuario) {
		Usuario aux = new Usuario(id_Usuario, null, null, null);

		UsuarioDAO usuarioDAO = FabricaDAO.obtenerUsuarioDAO();
		usuarioDAO.borrar(aux);
	}

	public Usuario encontrarUsuario(Integer id_Usuario) {
		UsuarioDAO usuarioDAO = FabricaDAO.obtenerUsuarioDAO();
		return usuarioDAO.encontrar(id_Usuario);
	}
}
