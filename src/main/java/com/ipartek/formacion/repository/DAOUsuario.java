package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.domain.Usuario;

/**
 * Interfaz para manejar todo lo relativo a los usuarios
 * 
 * @author Curso
 *
 */
public interface DAOUsuario {

	/**
	 * Conexion a la BBDD
	 * 
	 * @param ds
	 *            dataSource
	 */
	void setDatasource(DataSource ds);

	/**
	 * lista todos los usuarios
	 * 
	 * @return arrayList con todos los usuarios
	 */
	List<Usuario> getAll();

	/**
	 * lista todos los usuarios ordenados por el numero de tiradas
	 * 
	 * @return arrayList con todos los usuarios
	 */
	List<Usuario> ranking();

	/**
	 * Obtiene un usuario a traves de su id
	 * 
	 * @param id
	 *            id de usuario
	 * @return Usuario
	 */
	Usuario getById(int id);

	/**
	 * Añade un usuario a la BBDD
	 * 
	 * @param u
	 *            usuario a añadir
	 * @return true si lo añade, false en caso contrario
	 */
	boolean insert(Usuario u);

	/**
	 * Modifica un usuario en la BBDD
	 * 
	 * @param u
	 *            usuario a modificar
	 * @return true si lo modifica, false en caso contrario
	 */
	boolean update(Usuario u);

	/**
	 * Elimina un usuario de la BBDD
	 * 
	 * @param id
	 *            id del usuario a eliminar
	 * @return true si lo eleima, false en caso contrario
	 * @throws DataIntegrityViolationException
	 *             excepcion que controla la integridad de los datos
	 */
	boolean delete(int id) throws DataIntegrityViolationException;

}
