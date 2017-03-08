package com.ipartek.formacion.domain;

/**
 * Calse para manejar las estadisticas de los lanzamientos
 * 
 * @author Curso
 *
 */
public class Lanzamiento {

  private long id;
  private String nombre;
  private String fecha;

  /**
   * Construcotr con todos los campos
   */
  public Lanzamiento() {
    super();
    this.id = -1;
    this.nombre = "";
    this.fecha = "";
  }

  /**
   * Getter de la id
   * 
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * Setter de la id
   * 
   * @param id
   *          de la tirada
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Getter del nombre del usuario
   * 
   * @return nombre del usario
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Setter del nombre de usario
   * 
   * @param nombre
   *          del ususario
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Geter Fecha de la tirada
   * 
   * @return fecha de la tirada
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * Setter de la fecha de la tiradfa
   * 
   * @param fecha
   *          de la tirada
   */
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  @Override()
  public String toString() {
    return "Lanzamientos [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + "]";
  }

}
