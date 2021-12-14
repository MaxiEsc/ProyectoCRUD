package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Promocion;
import persistance.PromocionDAO;
import persistence.commons.Conexion;
import persistence.commons.ErroresPerdida;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public Promocion encontrar(Integer id) {
		try {
			String sql = "SELECT * FROM Promocion WHERE id_Promocion = ?";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			Promocion promocion = null;
			if (rs.next()) {
				promocion = crearPromocion(rs);
			}

			return promocion;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public List<Promocion> traerTodos() {
		try {
			String sql = "SELECT * FROM Promocion";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Promocion> promocion = new LinkedList<Promocion>();
			while (rs.next()) {
				promocion.add(crearPromocion(rs));
			}

			return promocion;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}
	
	private Promocion crearPromocion(ResultSet registrador) throws SQLException {
		return new Promocion(registrador.getInt(1), registrador.getString(2),
				registrador.getString(3), registrador.getDouble(4), registrador.getInt(5), registrador.getInt(6));
	}

	@Override
	public int contarTodos() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM Promocion";
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
	public int agregar(Promocion promocion) {
		try {
			String sql = "INSERT INTO Promocion (nombre, tipo, descuento, precio, atraccion_id_gratis) VALUES (?, ?, ?, ?, ?)";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, promocion.getNombre());
			ps.setString(2, promocion.getTipo());
			ps.setDouble(3, promocion.getDescuento());
			ps.setInt(4, promocion.getPrecio());
			ps.setInt(5, promocion.getAtraccion_id_gratis());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int modificar(Promocion promocion) {
		try {
			String sql = "UPDATE Promocion SET nombre = ?, tipo = ?, descuento = ?, precio = ?, atraccion_id_gratis = ?  WHERE id_Promocion= ?";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, promocion.getNombre());
			ps.setDouble(2, promocion.getDescuento());
			ps.setInt(3, promocion.getPrecio());
			ps.setInt(4, promocion.getPrecio());
			ps.setInt(5, promocion.getAtraccion_id_gratis());
			ps.setInt(6, promocion.getId_Promocion());
			
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public int borrar(Promocion promocion) {
		try {
			String sql = "DELETE FROM Promocion WHERE id_Promocion = ?";
			Connection conexion = Conexion.obtenerConexion();

			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, promocion.getId_Promocion());
			int filas = ps.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

	@Override
	public Promocion encontrarNombre(String nombre) {
		try {
			String sql = "SELECT * FROM Promocion WHERE nombre = ?";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();

			Promocion promocion = null;
			if (rs.next()) {
				promocion = crearPromocion(rs);
			}

			return promocion;
		} catch (Exception e) {
			throw new ErroresPerdida(e);
		}
	}

}
