package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.domain.Ranking;
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
	 * lista todos los usuarios ordenados por el numero de tiradas
	 * 
	 * @return array de todos los usuarios
	 */
	List<Ranking> ranking();

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
	 * Para recoger el usuario que resulta al tirar el dado
	 * 
	 * @return el usuario resultante
	 */
	Usuario lanzarDado();

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

	/**
	 * Da de baja un usuario sin eliminarlo de la base de datos
	 * 
	 * @param id
	 *            del usuario
	 * @return true si da de baja , false en caso contrario
	 */
	boolean darBaja(int id);

	/**
	 * Da de alta un usuario que este dado de baja
	 * 
	 * @param id
	 *            del usuario
	 * @return true si da de alta , false en caso contrario
	 */
	public boolean darAlta(int id);

}
