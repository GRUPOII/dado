package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Estadistica;
import com.ipartek.formacion.domain.Lanzamiento;
import com.ipartek.formacion.domain.Tirada;

/**
 * Interfaz que hace implemtentar una serie de estaditicas
 * 
 * @author Curso
 *
 */
public interface ServiceEstadistica {

  /**
   * Porcentaje de cada usuario resultante en las tiradas
   * 
   * @return Lista de los resultados
   */
  List<Estadistica> porcentajes();

  /**
   * Numero de tiradas toales realizadas
   * 
   * @return numero total de tiradas
   */
  int lanzamientosTotales();

  /**
   * Todas las toiradas
   * 
   * @return lista de todas laas tiradas
   */
  List<Tirada> todasTiradas();

  /**
   * Obtiene topdos los lanzacmientosa
   * 
   * @return array list de todsos los lanzamientos
   */
  List<Lanzamiento> lanzamientosGetAll();

}
