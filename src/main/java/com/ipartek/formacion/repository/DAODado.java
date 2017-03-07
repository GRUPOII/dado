package com.ipartek.formacion.repository;

import java.util.List;

import com.ipartek.formacion.domain.Tirada;

/**
 * Interfaz para el DAO de dado
 * 
 * @author Curso
 *
 */
public interface DAODado {

	List<Tirada> getAll();

	boolean lanzarDado(Tirada t);

	int total();

	List<Tirada> getUltimos();

}
