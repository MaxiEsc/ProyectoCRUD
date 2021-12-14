package persistence.commons;

import persistance.*;
import persistence.impl.*;

public class FabricaDAO {

	public static UsuarioDAO obtenerUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionDAO obtenerAtraccionDAO() {
		return new AtraccionDAOImpl();
	}
	
	public static PromocionDAO obtenerPromocionDAO() {
		return new PromocionDAOImpl();
	}	
	
}
