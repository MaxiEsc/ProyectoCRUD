package model;

import java.util.HashMap;
import java.util.Map;

public class Promocion {

	private Integer id_Promocion;
	private String nombre;
	private String tipo;
	private Double descuento;
	private Integer precio;
	private Integer atraccion_id_gratis;
	
	private Map<String, String> erroresPromociones;

	public Promocion(Integer id_Promocion, String nombre, String tipo, Double descuento, Integer precio,
			Integer atraccion_id_gratis) {
		super();
		this.id_Promocion = id_Promocion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descuento = descuento;
		this.precio = precio;
		this.atraccion_id_gratis = atraccion_id_gratis;
	}

	public Promocion(String nombre, String tipo, Double descuento, Integer precio, Integer atraccion_id_gratis) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descuento = descuento;
		this.precio = precio;
		this.atraccion_id_gratis = atraccion_id_gratis;
	}

	public Integer getId_Promocion() {
		return id_Promocion;
	}

	public void setId_Promocion(Integer id_Promocion) {
		this.id_Promocion = id_Promocion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Integer getAtraccion_id_gratis() {
		return atraccion_id_gratis;
	}

	public void setAtraccion_id_gratis(Integer atraccion_id_gratis) {
		this.atraccion_id_gratis = atraccion_id_gratis;
	}

	public Map<String, String> getErroresPromociones() {
		return erroresPromociones;
	}

	public void setErroresPromociones(Map<String, String> erroresPromociones) {
		this.erroresPromociones = erroresPromociones;
	}
	
	public boolean esValido() {
		validar();
		return this.erroresPromociones.isEmpty();
	}

	public void validar() {
		erroresPromociones = new HashMap<String, String>();

		if (this.precio <= 0) {
			erroresPromociones.put("Precio", "Debe ser positivo");
		}
		if (this.descuento <= 0) {
			erroresPromociones.put("Descuento", "Debe ser positivo");
		}
		if (this.atraccion_id_gratis < 0) {
			erroresPromociones.put("Gratis", "Debe ser positivo");
		}
	}

	@Override
	public String toString() {
		return "Promocion [ id_Promocion: " + id_Promocion + ", Nombre: " + nombre + ", Tipo: " + tipo + ", Precio: "
				+ precio + ", Descuento: " + descuento + ", Atraccion Id Gratis: " + atraccion_id_gratis
				+ " ]";
	}
	
}
