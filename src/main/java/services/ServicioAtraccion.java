package services;

import java.util.*;

import model.Atraccion;
import persistance.AtraccionDAO;
import persistence.commons.FabricaDAO;
import util.OrdenadorAtracciones;

public class ServicioAtraccion {

	public List<Atraccion> trearAtracciones(){
		
		List<Atraccion> atraccionesOrdenadas =  FabricaDAO.obtenerAtraccionDAO().traerTodos();
		atraccionesOrdenadas.sort(new OrdenadorAtracciones());
		
		return atraccionesOrdenadas;
	}
	
	public Atraccion crearAtraccion(String nombre, Integer valor, Double duracion, Integer cupo) {
		
		Atraccion aux = new Atraccion(nombre, valor, duracion, cupo);
		
		if(aux.esValido()) {
			AtraccionDAO atraccionDAO = FabricaDAO.obtenerAtraccionDAO();
			atraccionDAO.agregar(aux);
		}
		return aux;
	}
	
	public Atraccion editarAtraccion(Integer id_Atraccion, String nombre, Integer valor, Double duracion, Integer cupo) {
		
		AtraccionDAO atraccionDAO = FabricaDAO.obtenerAtraccionDAO();
		Atraccion aux = atraccionDAO.encontrar(id_Atraccion);
		
		aux.setCupo(cupo);
		aux.setDuracion(duracion);
		aux.setNombre(nombre);
		aux.setValor(valor);
		
		if(aux.esValido()) {
			atraccionDAO.modificar(aux);
		}		
		
		return aux;
	}
	
	public void eliminarAtraccion(Integer id_Atraccion) {
		Atraccion aux = new Atraccion(id_Atraccion, null, null, null, null);

		AtraccionDAO atraccionDAO = FabricaDAO.obtenerAtraccionDAO();
		atraccionDAO.borrar(aux);
	}

	public Atraccion encontrarAtraccion(Integer id_Atraccion) {
		AtraccionDAO atraccionDAO = FabricaDAO.obtenerAtraccionDAO();				
		return atraccionDAO.encontrar(id_Atraccion);
	}
}
