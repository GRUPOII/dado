package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.domain.Usuario;

@Repository(value = "daoDado")
public class DAODadoImpl implements DAODado {

	private final Log LOG = LogFactory.getLog(getClass());

	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired()
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	// Sentencias SQL
	private static final String SQL_INSERT = "INSERT INTO `tirada` (`usuario_id`) VALUES (?);";

	@Override
	public Usuario crear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lanzarDado(final Tirada t) {
		boolean resul = false;
		try {
			int affectedRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedRows = this.jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					final PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
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

}
