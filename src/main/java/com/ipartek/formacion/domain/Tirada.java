package com.ipartek.formacion.domain;

/**
 * Pojo tirada
 * 
 * @author Curso
 *
 */
public class Tirada {

	// ATRIBUTOS
	private int id;
	private int idUsuario;
	private String fechaTirada;

	// CONSTRUCTORES
	/**
	 * Contructor sin parametros
	 */
	public Tirada() {
		super();
	}

	/**
	 * Construcor al que se le pasan todos los parametros
	 * 
	 * @param id
	 *            id de la tirada
	 * @param idUsuario
	 *            id del usuario
	 * @param fechaTirada
	 *            fecha que se crea automatica
	 */
	public Tirada(int id, int idUsuario, String fechaTirada) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.fechaTirada = fechaTirada;
	}

	// GETERS AN SETTERS
	/**
	 * Para recuperar la id de la tirada
	 * 
	 * @return id de la tirada
	 */
	public int getId() {
		return id;
	}

	/**
	 * Para dar valor al id de la tirada
	 * 
	 * @param id
	 *            id de la tirada
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Recuperas la id del usuario que resulto en la tirada
	 * 
	 * @return id de usuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Para dar valor al id de Usuario de la tirada
	 * 
	 * @param idUsuario
	 *            id usuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * PAra obtener la fecha de una tirada
	 * 
	 * @return
	 */

	public String getFechaTirada() {

		return fechaTirada;
	}

	/**
	 * Para asignar una fecha a una tirada
	 * 
	 * @param fechaTirada
	 */
	public void setFechaTirada(String fechaTirada) {
		this.fechaTirada = fechaTirada;
	}

	// TO STRING

	@Override()
	public String toString() {
		return "Tirada [id=" + id + ", idUsuario=" + idUsuario + ", fechaTirada=" + fechaTirada + "]";
	}

}
