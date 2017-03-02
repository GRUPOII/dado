package com.ipartek.formacion.domain;

public class Usuario {

	// ATRIBUTOS
	private int id;
	private String nombre;
	private String fechaAlta;
	private String fechaModificacion;
	private String fechaBaja;

	// CONSTRUCTOR

	public Usuario() {
		super();

	}

	public Usuario(int id, String nombre, String fechaAlta, String fechaModificacion, String fechaBaja) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.fechaModificacion = fechaModificacion;
		this.fechaBaja = fechaBaja;

	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", fechaModificacion="
				+ fechaModificacion + ", fechaBaja=" + fechaBaja + "]";
	}

}
