package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.domain.Usuario;

/**
 * interfaz que hace implementar al servicio todo lo necesario para el CRUD de
 * uduarios
 * 
 * @author Curso
 *
 */
public interface ServiceUsuario {

	/**
	 * lista todos los usuarios
	 * 
	 * @return array de todos los usuarios
	 */
	List<Usuario> listar();

	/**
	 * Devuelve un usuario buscado a traves de su id
	 * 
	 * @param id
	 *            id usuario
	 * @return usuario buscado
	 */
	Usuario buscarPorId(int id);

	/**
	 * Crea un usuario en la BBDD
	 * 
	 * @param u
	 *            usuario a iunsertar
	 * @return true si lo añade, false en caso contrario
	 */
	boolean crear(Usuario u);

	/**
	 * Modifica un usuario
	 * 
	 * @param u
	 *            usuario a modificar
	 * @return true si lo modifica, false en caso contrario
	 */
	boolean modificar(Usuario u);

	/**
	 * Elimina un usuario
	 * 
	 * @param id
	 *            id del usuario a eliminar
	 * @return true si lo elimina, false en caso contrario
	 * @throws DataIntegrityViolationException
	 *             excepcion que salta si se violan la integridad de los datosn
	 *             en la BBDSD
	 */
	boolean eliminar(int id) throws DataIntegrityViolationException;

}
