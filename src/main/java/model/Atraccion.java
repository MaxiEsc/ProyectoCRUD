package model;

import java.util.*;

public class Atraccion {

	private Integer id_Atraccion;
	private String nombre;
	private Integer valor;
	private Double duracion;
	private Integer cupo;

	private Map<String, String> errores;

	public Atraccion(String nombre, Integer valor, Double duracion, Integer cupo) {
		
		this.nombre = nombre;
		this.valor = valor;
		this.duracion = duracion;
		this.cupo = cupo;
	}
	

	public Atraccion(Integer id_Atraccion, String nombre, Integer valor, Double duracion, Integer cupo) {
		super();
		this.id_Atraccion = id_Atraccion;
		this.nombre = nombre;
		this.valor = valor;
		this.duracion = duracion;
		this.cupo = cupo;
	}

	public boolean esValido() {
		validar();
		return errores.isEmpty();
	}

	public void validar() {
		errores = new HashMap<String, String>();

		if (this.valor <= 0) {
			errores.put("Valor", "Debe ser positivo");
		}
		if (this.cupo <= 0) {
			errores.put("Cupo", "Debe ser positivo");
		}
		if (this.duracion <= 0) {
			errores.put("Duracion", "Debe ser positivo");
		}
	}

	public Integer getId_Atraccion() {
		return id_Atraccion;
	}

	public void setId_Atraccion(Integer id_Atraccion) {
		this.id_Atraccion = id_Atraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public void setErrores(Map<String, String> errores) {
		this.errores = errores;
	}
	
	public boolean tieneCapacidad(int i) {
		return this.cupo >= i;
	}

	public void capacidad(int i) {
		this.cupo -= i;
	}

	@Override
	public String toString() {
		return "Atraccion [ id_Atraccion: " + id_Atraccion + ", Nombre: " + nombre + ", Valor: " + valor + ", Duracion: "
				+ duracion + ", Cupo: " + cupo + ", Errores: " + errores + " ]";
	}
	
	
	
	
	
}
