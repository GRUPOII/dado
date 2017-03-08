package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Ranking;
import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.mapper.RankingMapper;
import com.ipartek.formacion.repository.mapper.UsuarioMapper;

/**
 * DAO para conectarse a la BBDD
 * 
 * @author curso
 *
 */
@Repository(value = "daoUsuario")
public class DAOUsuarioImpl implements DAOUsuario {

  private final Log LOG = LogFactory.getLog(getClass());

  @Autowired()
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  @Autowired()
  @Override()
  public void setDatasource(DataSource ds) {
    this.dataSource = ds;
    this.jdbcTemplate = new JdbcTemplate(this.dataSource);
  }

  // Sentencias SQL

  private static final String SQL_GET_ALL = "SELECT `id`, `nombre`, `fecha_alta`, `fecha_modificacion`,`fecha_baja` FROM `usuario` ORDER BY `id` ASC LIMIT 500;";
  private static final String SQL_GET_BY_ID = "SELECT `id`, `nombre`, `fecha_alta`, `fecha_modificacion`,`fecha_baja` FROM `usuario` WHERE `id` = ?";
  private static final String SQL_INSERT = "INSERT INTO `usuario` (`nombre`) VALUES (?);";
  private static final String SQL_UPDATE = "UPDATE `usuario` SET `nombre`= ?, `fecha_modificacion`= CURRENT_TIMESTAMP WHERE `id`= ? ;";
  private static final String SQL_DELETE = "DELETE FROM `usuario` WHERE `id` = ?;";
  private static final String SQL_RANKING = "SELECT count(tirada.id) as tiradas, usuario.nombre FROM tirada, usuario WHERE usuario.id = tirada.usuario_id AND `fecha_baja` IS NULL GROUP BY usuario.nombre ORDER BY tiradas DESC LIMIT 10;";
  private static final String SQL_GET_ALL_USUARIOS_ALTA = "SELECT `id`, `nombre`, `fecha_alta`, `fecha_modificacion`, `fecha_baja` FROM `usuario` WHERE `fecha_baja` IS NULL  ORDER BY `id` DESC LIMIT 500;";

  private static final String SQL_USUARIO_BAJA = "UPDATE `usuario` SET `fecha_modificacion`= CURRENT_TIMESTAMP , `fecha_baja`= CURRENT_TIMESTAMP WHERE `id`= ? ;";
  private static final String SQL_USUARIO_ALTA = "UPDATE `usuario` SET `fecha_alta`= CURRENT_TIMESTAMP,`fecha_modificacion`= CURRENT_TIMESTAMP , `fecha_baja`= NULL WHERE `id`= ? ;";

  @Override()
  public List<Usuario> getAll() {
    ArrayList<Usuario> lista = new ArrayList<Usuario>();

    try {

      lista = (ArrayList<Usuario>) this.jdbcTemplate.query(SQL_GET_ALL, new UsuarioMapper());

    } catch (EmptyResultDataAccessException e) {

      this.LOG.warn("No existen usuarios todavia");

    } catch (Exception e) {

      this.LOG.error(e.getMessage());

    }
    return lista;
  }

  @Override()
  public Usuario getById(int id) {
    Usuario u = new Usuario();

    try {

      u = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new UsuarioMapper());

    } catch (EmptyResultDataAccessException e) {

      this.LOG.warn("No existen usuarios todavia");

    } catch (Exception e) {

      this.LOG.error(e.getMessage());

    }

    return u;
  }

  @Override()
  public boolean insert(final Usuario u) {

    this.LOG.trace("insert " + u);
    boolean resul = false;

    try {

      KeyHolder keyHolder = new GeneratedKeyHolder();

      int affectedeRows = this.jdbcTemplate.update(new PreparedStatementCreator() {

        @Override()
        public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
          PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
          ps.setString(1, u.getNombre());

          return ps;
        }
      }, keyHolder);

      if (affectedeRows == 1) {
        u.setId((int) keyHolder.getKey().longValue());
        resul = true;
      }
    } catch (Exception e) {

      this.LOG.error(e.getMessage());

    }

    return resul;
  }

  @Override()
  public boolean update(Usuario u) {
    this.LOG.trace("update " + u);
    boolean resul = false;
    int affectedRows = -1;

    try {

      Object[] argumentos = { u.getNombre(), u.getId() };
      affectedRows = this.jdbcTemplate.update(SQL_UPDATE, argumentos);

      if (affectedRows == 1) {
        resul = true;
      }

    } catch (Exception e) {

      this.LOG.error(e.getMessage());

    }

    return resul;
  }

  @Override()
  public boolean delete(int id) {
    this.LOG.trace("eliminar usuario " + id);
    boolean resul = false;
    int affectedRows = -1;

    try {

      affectedRows = this.jdbcTemplate.update(SQL_DELETE, id);

      if (affectedRows == 1) {
        resul = true;
      }
    } catch (DataIntegrityViolationException e) {
      this.LOG.warn(e.getMessage());

    } catch (Exception e) {

      this.LOG.error(e.getMessage());

    }

    return resul;
  }

  @Override()
  public ArrayList<Ranking> ranking() {
    ArrayList<Ranking> lista = new ArrayList<Ranking>();

    try {

      lista = (ArrayList<Ranking>) this.jdbcTemplate.query(SQL_RANKING, new RankingMapper());

    } catch (EmptyResultDataAccessException e) {

      this.LOG.warn("No existen usuarios todavia");

    } catch (Exception e) {

      this.LOG.error(e.getMessage());

    }
    return lista;
  }

  @Override()
  public List<Usuario> getAllUsuariosDeAlta() {
    ArrayList<Usuario> lista = new ArrayList<Usuario>();
    try {
      lista = (ArrayList<Usuario>) this.jdbcTemplate.query(SQL_GET_ALL_USUARIOS_ALTA,
          new UsuarioMapper());
    } catch (EmptyResultDataAccessException e) {
      this.LOG.warn("No existen usuarios todavia");
    } catch (Exception e) {
      this.LOG.error(e.getMessage());
    }
    return lista;
  }

  @Override()
  public boolean baja(int id) {
    boolean resul = false;
    try {
      int affectedRows = this.jdbcTemplate.update(SQL_USUARIO_BAJA, id);
      if (affectedRows == 1) {
        resul = true;
      }
    } catch (DataIntegrityViolationException e) {
      this.LOG.warn(e.getMessage());
    } catch (Exception e) {
      this.LOG.error(e.getMessage());
    }
    return resul;
  }

  @Override()
  public boolean alta(int id) {
    boolean resul = false;
    try {
      int affectedRows = this.jdbcTemplate.update(SQL_USUARIO_ALTA, id);
      if (affectedRows == 1) {
        resul = true;
      }
    } catch (DataIntegrityViolationException e) {
      this.LOG.warn(e.getMessage());
    } catch (Exception e) {
      this.LOG.error(e.getMessage());
    }
    return resul;
  }
}
