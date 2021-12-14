package persistence.commons;

import java.util.List;

public interface PlantillaDAO<P> {

	public P encontrar(Integer id);
	public List<P> traerTodos();
	public int contarTodos();
	public int agregar(P p);
	public int modificar(P p);
	public int borrar(P p);
	public P encontrarNombre(String nombre);
	
}
