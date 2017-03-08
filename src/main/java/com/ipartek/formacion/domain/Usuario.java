package com.ipartek.formacion.domain;

import java.sql.Timestamp;

/**
 * Pojo Usuario
 * 
 * @author curso
 *
 */
public class Usuario {

  // ATRIBUTOS
  private int id;
  private String nombre;
  private Timestamp fechaAlta;
  private Timestamp fechaModificacion;
  private Timestamp fechaBaja;

  // CONSTRUCTOR

  /**
   * Contructor con parámetros vacios
   */
  public Usuario() {
    super();
    this.id = -1;
    this.nombre = "";
  }

  /**
   * Constructor con parámetros
   * 
   * @param id
   *          id del usuario
   * @param nombre
   *          nombre del usuario
   * @param fechaAlta
   *          fecha en la que se registra
   * @param fechaModificacion
   *          fecha en la que sufre algún cambio
   * @param fechaBaja
   *          fecha en la que se le da de baja
   */
  public Usuario(int id, String nombre, Timestamp fechaAlta, Timestamp fechaModificacion,
      Timestamp fechaBaja) {
    super();
    this.id = id;
    this.nombre = nombre;
    this.fechaAlta = fechaAlta;
    this.fechaModificacion = fechaModificacion;
    this.fechaBaja = fechaBaja;
  }

  // GETTERS AND SETTERS

  /**
   * Getter
   * 
   * @return devuleve la id del usuario
   */
  public int getId() {
    return this.id;
  }

  /**
   * Setter
   * 
   * @param id
   *          id del usuario
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter
   * 
   * @return devuelve el nombre del usuario
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Setter
   * 
   * @param nombre
   *          parametro del nombre del usuario
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Getter
   * 
   * @return devuelve la fecha de registro
   */
  public Timestamp getFechaAlta() {
    return this.fechaAlta;
  }

  /**
   * Setter
   * 
   * @param fechaAlta
   *          fecha en la que se da alta
   */
  public void setFechaAlta(Timestamp fechaAlta) {
    this.fechaAlta = fechaAlta;
  }

  /**
   * Getter
   * 
   * @return devuelve la fecha de modificacion
   */
  public Timestamp getFechaModificacion() {
    return this.fechaModificacion;
  }

  /**
   * Setter
   * 
   * @param fechaModificacion
   *          fecha en la que se modifica
   */
  public void setFechaModificacion(Timestamp fechaModificacion) {
    this.fechaModificacion = fechaModificacion;
  }

  /**
   * Getter
   * 
   * @return devuelve la fecha de baja
   */
  public Timestamp getFechaBaja() {
    return this.fechaBaja;
  }

  /**
   * Setter
   * 
   * @param fechaBaja
   *          fecha en la que se da de baja
   */
  public void setFechaBaja(Timestamp fechaBaja) {
    this.fechaBaja = fechaBaja;
  }

  // TO STRING

  @Override()
  public String toString() {
    return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", fechaAlta=" + this.fechaAlta
        + ", fechaModificacion=" + this.fechaModificacion + ", fechaBaja=" + this.fechaBaja + "]";
  }

}
