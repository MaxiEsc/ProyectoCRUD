package model;

public class Usuario {

	private Integer id_Usuario;
	private String nombre_completo;
	private Integer monedas;
	private Double tiempo;
	
	
	public Usuario(String nombre_completo, Integer monedas, Double tiempo) {
		this.nombre_completo = nombre_completo;
		this.monedas = monedas;
		this.tiempo = tiempo;
	}
	
	

	public Usuario(String nombre_completo) {
		super();
		this.nombre_completo = nombre_completo;
	}

	public Usuario(Integer id_Usuario, String nombre_completo, Integer monedas, Double tiempo) {
		this.id_Usuario = id_Usuario;
		this.nombre_completo = nombre_completo;
		this.monedas = monedas;
		this.tiempo = tiempo;
	}

	public Usuario() {
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}


	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}


	public String getNombre_completo() {
		return nombre_completo;
	}


	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}


	public Integer getMonedas() {
		return monedas;
	}


	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}


	public Double getTiempo() {
		return tiempo;
	}


	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

	public void agregaritinerario(Atraccion atraccion) {
		this.monedas -= atraccion.getValor();
		this.tiempo -= atraccion.getDuracion();
		//Agregar al itinerario
	}
	
	public boolean tieneTiempo(Atraccion atraccion) {
		return atraccion.getDuracion() < this.tiempo;
	}

	public boolean puedePagar(Atraccion atraccion) {
		return atraccion.getValor() < this.monedas;
	}
	
	public boolean esValido() {
		return this.monedas >= 0 && this.tiempo >= 0 && !this.nombre_completo.isBlank();
	}


	@Override
	public String toString() {
		return "Usuario [ id_Usuario: " + id_Usuario + ", Nombre Completo: " + nombre_completo + ", Monedas: " + monedas
				+ ", Tiempo: " + tiempo + " ]";
	}
	
}
