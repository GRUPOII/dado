package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Estadistica;

public interface ServiceEstadistica {

  List<Estadistica> porcentajes();

  int lanzamientosTotales();

  // List<Tirada> ultimasTiradas();

}
