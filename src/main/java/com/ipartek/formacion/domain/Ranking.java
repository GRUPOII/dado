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

  /**
   * Constructor sin poarametros
   */
  public Ranking() {
    super();
  }

  /**
   * Construcutor de ranking con todos los parametros
   * 
   * @param nombre
   *          del usuario
   * @param tiradas
   *          en las que el usuario reulto
   */
  public Ranking(String nombre, int tiradas) {
    super();
    this.nombre = nombre;
    this.tiradas = tiradas;
  }

  /**
   * Getter nombre usuario
   * 
   * @return nombre usuario
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Setter del nombre de usuario
   * 
   * @param nombre
   *          de usuario
   */

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Getter de las tiradas d eun usuario concreto
   * 
   * @return tiradas de usuario
   */
  public int getTiradas() {
    return this.tiradas;
  }

  /**
   * Setter de tiradas de un usuario
   * 
   * @param tiradas
   *          de usauri
   */
  public void setTiradas(int tiradas) {
    this.tiradas = tiradas;
  }

  @Override()
  public String toString() {
    return "Ranking [nombre=" + this.nombre + ", tiradas=" + this.tiradas + "]";
  }

}
