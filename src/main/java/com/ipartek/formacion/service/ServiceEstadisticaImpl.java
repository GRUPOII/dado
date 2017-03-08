package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Estadistica;
import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.repository.DAODado;

/**
 * Servicio para las estadiciticas
 * 
 * @author Curso
 *
 */
@Service(value = "serviceEstadistica")
public class ServiceEstadisticaImpl implements ServiceEstadistica {

  @Autowired()
  private DAODado daoDado;

  @Override()
  public List<Estadistica> porcentajes() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override()
  public int lanzamientosTotales() {
    return this.daoDado.total();

  }

  @Override()
  public List<Tirada> todasTiradas() {

    return this.daoDado.getAll();
  }

}
