package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.domain.Ranking;
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
   *          dataSource
   */
  void setDatasource(DataSource ds);

  /**
   * lista todos los usuarios
   * 
   * @return arrayList con todos los usuarios
   */
  List<Usuario> getAll();

  /**
   * Lista todos los usuarios dados de alta
   * 
   * @return arrayList con todos los usuarios
   */
  List<Usuario> getAllUsuariosDeAlta();

  /**
   * lista todos los usuarios ordenados por el numero de tiradas
   * 
   * @return arrayList con todos los usuarios
   */
  ArrayList<Ranking> ranking();

  /**
   * Obtiene un usuario a traves de su id
   * 
   * @param id
   *          id de usuario
   * @return Usuario
   */
  Usuario getById(int id);

  /**
   * A�ade un usuario a la BBDD
   * 
   * @param u
   *          usuario a a�adir
   * @return true si lo a�ade, false en caso contrario
   */
  boolean insert(Usuario u);

  /**
   * Modifica un usuario en la BBDD
   * 
   * @param u
   *          usuario a modificar
   * @return true si lo modifica, false en caso contrario
   */
  boolean update(Usuario u);

  /**
   * Elimina un usuario de la BBDD
   * 
   * @param id
   *          id del usuario a eliminar
   * @return true si lo eleima, false en caso contrario
   * @throws DataIntegrityViolationException
   *           excepcion que controla la integridad de los datos
   */
  boolean delete(int id) throws DataIntegrityViolationException;

  /**
   * Damos de baja un usuario sin borrarlo d ela base de datos
   * 
   * @param id
   *          del usuario
   * @return true si lo da d ebaja, false en caso contrario
   */
  boolean baja(int id);

  /**
   * Damos de alta un usuario que este de baja
   * 
   * @param id
   *          del usuario
   * @return true si lo da d alta, false en caso contrario
   */
  boolean alta(int id);

}
