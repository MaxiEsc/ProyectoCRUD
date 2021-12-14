package services;

import java.util.*;

import model.Promocion;
import persistance.PromocionDAO;
import persistence.commons.FabricaDAO;
import util.OrdenadorPromociones;

public class ServicioPromocion {

	public List<Promocion> traerPromociones(){
		List<Promocion> promocionesOrdenadas = FabricaDAO.obtenerPromocionDAO().traerTodos();
		promocionesOrdenadas.sort(new OrdenadorPromociones());
		
		return promocionesOrdenadas;
	}
	
	public Promocion crearPromociones(String nombre, String tipo, Double descuento, Integer precio, Integer atraccion_id_gratis) {
		
		Promocion aux = new Promocion(nombre, tipo, descuento, precio, atraccion_id_gratis);
		
		if(aux.esValido()) {
			PromocionDAO promocionDAO = FabricaDAO.obtenerPromocionDAO();
			promocionDAO.agregar(aux);
		}
		return aux;
	}
	
	public Promocion editarPromocion(Integer id_Promocion, String nombre, String tipo, Double descuento, Integer precio, Integer atraccion_id_gratis) {
		
		PromocionDAO promocionDAO = FabricaDAO.obtenerPromocionDAO();
		Promocion aux = promocionDAO.encontrar(id_Promocion);
		
		aux.setAtraccion_id_gratis(atraccion_id_gratis);
		aux.setDescuento(descuento);
		aux.setNombre(nombre);
		aux.setPrecio(precio);
		aux.setTipo(tipo);
		
		
		if(aux.esValido()) {
			promocionDAO.modificar(aux);
		}		
		
		return aux;
	}
	
	public void eliminarPromocion(Integer id_Atraccion) {
		Promocion aux = new Promocion(id_Atraccion, null, null, null, null, null);

		PromocionDAO promocionDAO = FabricaDAO.obtenerPromocionDAO();
		promocionDAO.borrar(aux);
	}

	public Promocion encontrarPromocion(Integer id_Atraccion) {
		PromocionDAO promocionDAO = FabricaDAO.obtenerPromocionDAO();				
		return promocionDAO.encontrar(id_Atraccion);
	}
	
}
