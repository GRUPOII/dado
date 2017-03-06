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

import com.ipartek.formacion.domain.Usuario;
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
	private static final String SQL_INSERT = "INSERT INTO `dado`.`usuario` (`nombre`) VALUES (?);";

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
			int affectedeRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedeRows = this.jdbcTemplate.update(new PreparedStatementCreator() {

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override()
	public boolean delete(int id) throws DataIntegrityViolationException {
		// TODO Auto-generated method stub
		return false;
	}

}
