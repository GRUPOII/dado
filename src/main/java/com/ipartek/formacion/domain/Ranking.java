package com.ipartek.formacion.domain;

/**
 * Clase para realizar el ranking de usuarios
 * 
 * @author Curso
 *
 */
public class Ranking {

	private String nombre;
	private int tiradas;

	public Ranking() {
		super();
	}

	public Ranking(String nombre, int tiradas) {
		super();
		this.nombre = nombre;
		this.tiradas = tiradas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiradas() {
		return tiradas;
	}

	public void setTiradas(int tiradas) {
		this.tiradas = tiradas;
	}

	@Override
	public String toString() {
		return "Ranking [nombre=" + nombre + ", tiradas=" + tiradas + "]";
	}

}
