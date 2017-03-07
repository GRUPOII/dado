package com.ipartek.formacion.repository;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.domain.Usuario;

/**
 * Interfaz para el DAO de dado
 * 
 * @author Curso
 *
 */
public interface DAODado {

	/**
	 * Crea
	 * 
	 * @return retorna
	 */
	Usuario crear();

	boolean lanzarDado(Tirada t);

}
