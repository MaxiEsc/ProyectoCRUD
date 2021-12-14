package persistence.impl;

import java.sql.*;
import java.util.*;
import model.Usuario;
import persistance.UsuarioDAO;
import persistence.commons.*;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public Usuario encontrar(Integer id) {
		try {
			String sql = "SELECT * FROM Usuario WHERE id_Usuario = ?";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultados = ps.executeQuery();

			Usuario usuario = new Usuario();

			if (resultados.next()) {
				usuario = crearUsuario(resultados);
			}
			return usuario;
			
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public List<Usuario> traerTodos() {
		try {
			String sql = "SELECT * FROM Usuario";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet resultados = ps.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(crearUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}
	
	private Usuario crearUsuario(ResultSet Registrador) throws SQLException {
		return new Usuario(Registrador.getInt(1), Registrador.getString(2), Registrador.getInt(3),
				Registrador.getDouble(4));
	}

	@Override
	public int contarTodos() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM Usuario";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet resultados = ps.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int agregar(Usuario usuario) {
		try {
			String sql = "INSERT INTO Usuario (nombre_completo,monedas,tiempo) VALUES (?, ?, ?)";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, usuario.getNombre_completo());
			ps.setInt(2, usuario.getMonedas());
			ps.setDouble(3, usuario.getTiempo());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int modificar(Usuario usuario) {
		try {
			String sql = "UPDATE Usuario SET nombre_completo = ?, monedas = ?, tiempo = ? WHERE id_Usuario = ?";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, usuario.getNombre_completo());
			ps.setInt(2, usuario.getMonedas());
			ps.setDouble(3, usuario.getTiempo());
			ps.setInt(4, usuario.getId_Usuario());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int borrar(Usuario usuario) {
		try {
			String sql = "DELETE FROM Usuario WHERE id_Usuario = ?";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, usuario.getId_Usuario());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}
	
	@Override
	public Usuario encontrarNombre(String nombre){
		try{
			Usuario usuario = null;
		
		String sql = "select * from Usuario where nombre_completo = ?";
		Connection conexion = Conexion.obtenerConexion();
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.setString(1, nombre);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			usuario = new Usuario(rs.getString(2));
		}
		return usuario;
		}catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}
}
