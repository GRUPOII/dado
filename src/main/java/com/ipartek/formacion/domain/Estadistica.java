package com.ipartek.formacion.domain;

public class Estadistica {
	private String nombre;
	private int contador;

	/**
	 * Creador estadistica
	 */
	public Estadistica() {
		super();
		this.nombre = "";
		this.contador = -1;
	}

	/**
	 * Getter del nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * setter del nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter contador
	 * 
	 * @return contador
	 */
	public int getContador() {
		return this.contador;
	}

	/**
	 * setter contador
	 * 
	 * @param contador
	 */
	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override()
	public String toString() {
		return "Estadistica [nombre=" + this.nombre + ", contador=" + this.contador + "]";
	}

}
