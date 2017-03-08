package com.ipartek.formacion.service;

import com.ipartek.formacion.domain.Tirada;

/**
 * Servicio para las tiradas
 * 
 * @author Curso
 *
 */
public interface ServiceTirada {

  /**
   * Inserta una tirada en la base de datos
   * 
   * @param t
   *          tirada a insertar
   * @return true si crea la tirada, false en caso contrario
   */
  boolean lanzarDado(Tirada t);
}
