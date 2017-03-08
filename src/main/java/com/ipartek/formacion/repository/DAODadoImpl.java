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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.repository.mapper.TiradaMapper;

/**
 * DAO para manejar todos los datos referidos a las tiradas
 * 
 * @author Curso
 *
 */
@Repository(value = "daoDado")
public class DAODadoImpl implements DAODado {

  private final Log LOG = LogFactory.getLog(getClass());

  @Autowired()
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  /**
   * Conexion Base de datos
   * 
   * @param ds
   *          datasource base de datos
   */
  @Autowired()
  public void setDatasource(DataSource ds) {
    this.dataSource = ds;
    this.jdbcTemplate = new JdbcTemplate(this.dataSource);
  }

  // Sentencias SQL
  private static final String SQL_INSERT = "INSERT INTO `tirada` (`usuario_id`) VALUES (?);";
  private static final String SQL_COUNT = "SELECT COUNT(id) FROM tirada;";
  private static final String SQL_GET_ALL = "SELECT `id`, `fecha`, `usuario_id` FROM `tirada` ORDER BY `id` DESC LIMIT 500;";
  private static final String SQL_ULTIMAS = "SELECT tirada.id, usuario.nombre, tirada.fecha FROM tirada, usuario WHERE usuario.id = tirada.usuario_id ORDER BY fecha DESC, tirada.id DESC LIMIT 10;";

  @Override()
  public boolean lanzarDado(final Tirada t) {
    boolean resul = false;
    try {
      int affectedRows = -1;
      KeyHolder keyHolder = new GeneratedKeyHolder();

      affectedRows = this.jdbcTemplate.update(new PreparedStatementCreator() {
        @Override()
        public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
          final PreparedStatement ps = conn.prepareStatement(SQL_INSERT,
              Statement.RETURN_GENERATED_KEYS);
          ps.setLong(1, t.getIdUsuario());
          return ps;
        }
      }, keyHolder);

      if (affectedRows == 1) {
        resul = true;
        t.setId((int) keyHolder.getKey().longValue());
      }

    } catch (Exception e) {
      this.LOG.error(e.getMessage());
    }
    return resul;
  }

  @Override()
  public int total() {
    int resul;
    resul = this.jdbcTemplate.queryForInt(SQL_COUNT);
    return resul;
  }

  @Override()
  public List<Tirada> getAll() {
    ArrayList<Tirada> lista = new ArrayList<Tirada>();
    try {
      lista = (ArrayList<Tirada>) this.jdbcTemplate.query(SQL_GET_ALL, new TiradaMapper());
    } catch (EmptyResultDataAccessException e) {
      this.LOG.warn("No existen tiradas todavia");
    } catch (Exception e) {
      this.LOG.error(e.getMessage());
    }
    return lista;
  }

}
