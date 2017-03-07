package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Estadistica;
import com.ipartek.formacion.domain.Tirada;

public interface ServiceEstadistica {

	List<Estadistica> porcentajes();

	int lanzamientosTotales();

	List<Tirada> ultimasTiradas();

}
