package persistence.impl;

import java.sql.*;
import java.util.*;

import model.Atraccion;
import persistance.AtraccionDAO;
import persistence.commons.*;


public class AtraccionDAOImpl implements AtraccionDAO{

	@Override
	public Atraccion encontrar(Integer id) {
		try {
			String sql = "SELECT * FROM Atraccion WHERE id_Atraccion = ?";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			Atraccion atraccion = null;
			if (rs.next()) {
				atraccion = crearAtraccion(rs);
			}

			return atraccion;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public List<Atraccion> traerTodos() {
		try {
			String sql = "SELECT * FROM Atraccion";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Atraccion> atraccion = new LinkedList<Atraccion>();
			while (rs.next()) {
				atraccion.add(crearAtraccion(rs));
			}

			return atraccion;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}
	
	private Atraccion crearAtraccion(ResultSet registrador) throws SQLException {
		return new Atraccion(registrador.getInt(1), registrador.getString(2),
				registrador.getInt(3), registrador.getDouble(4), registrador.getInt(5));
	}

	@Override
	public int contarTodos() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM Atraccion";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.next();
			int total = rs.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int agregar(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO Atraccion (nombre, valor, duracion, cupo) VALUES (?, ?, ?, ?)";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, atraccion.getNombre());
			ps.setInt(2, atraccion.getValor());
			ps.setDouble(3, atraccion.getDuracion());
			ps.setInt(4, atraccion.getCupo());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int modificar(Atraccion atraccion) {
		try {
			String sql = "UPDATE Atraccion SET nombre = ?, valor = ?, duracion = ?, cupo = ? WHERE id_Atraccion = ?";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, atraccion.getNombre());
			ps.setInt(2, atraccion.getValor());
			ps.setDouble(3, atraccion.getDuracion());
			ps.setInt(4, atraccion.getCupo());
			ps.setInt(5, atraccion.getId_Atraccion());
			
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int borrar(Atraccion atraccion) {
		try {
			String sql = "DELETE FROM Atraccion WHERE id_Atraccion = ?";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, atraccion.getId_Atraccion());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public Atraccion encontrarNombre(String nombre) {
		try {
			String sql = "SELECT * FROM Atraccion WHERE nombre = ?";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();

			Atraccion atraccion = null;
			if (rs.next()) {
				atraccion = crearAtraccion(rs);
			}

			return atraccion;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

}
