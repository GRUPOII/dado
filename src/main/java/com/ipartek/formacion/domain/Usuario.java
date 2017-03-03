package com.ipartek.formacion.domain;

import java.sql.Timestamp;

public class Usuario {

	// ATRIBUTOS
	private int id;
	private String nombre;
	private Timestamp fechaAlta;
	private Timestamp fechaModificacion;
	private Timestamp fechaBaja;

	// CONSTRUCTOR

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Usuario(int id, String nombre, Timestamp fechaAlta, Timestamp fechaModificacion, Timestamp fechaBaja) {
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

	public Timestamp getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Timestamp getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	// TO STRING

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", fechaModificacion="
				+ fechaModificacion + ", fechaBaja=" + fechaBaja + "]";
	}

}
