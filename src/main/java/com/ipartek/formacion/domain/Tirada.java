package com.ipartek.formacion.domain;

public class Tirada {

	// ATRIBUTOS
	private int id;
	private int idUsuario;
	private String fechaTirada;

	// CONSTRUCTORES
	public Tirada() {
		super();
	}

	public Tirada(int id, int idUsuario, String fechaTirada) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.fechaTirada = fechaTirada;
	}

	// GETERS AN SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFechaTirada() {
		return fechaTirada;
	}

	public void setFechaTirada(String fechaTirada) {
		this.fechaTirada = fechaTirada;
	}

	// TO STRING

	@Override
	public String toString() {
		return "Tirada [id=" + id + ", idUsuario=" + idUsuario + ", fechaTirada=" + fechaTirada + "]";
	}

	// METODOS

	public void tirarDado(Usuario user) {

	};

}
