package com.ipartek.formacion.repository;

import java.util.List;

import com.ipartek.formacion.domain.Lanzamiento;
import com.ipartek.formacion.domain.Tirada;

/**
 * Interfaz para el DAO de dado
 * 
 * @author Curso
 *
 */
public interface DAODado {

  /**
   * Lista todos las tiradas realizadas
   * 
   * @return lista de las toiradas
   */
  List<Tirada> getAll();

  /**
   * Lista todos las tiradas realizadas
   * 
   * @return lista de las toiradas
   */
  List<Lanzamiento> getAllLanzamientos();

  /**
   * Lanza el dado
   * 
   * @param t
   *          tirada realizada
   * @return true si inserta la tirada en la BD, false en caso contrario
   */
  boolean lanzarDado(Tirada t);

  /**
   * Numero total de tiradas realizadas
   * 
   * @return nuemro total de tiradas
   */
  int total();

}
