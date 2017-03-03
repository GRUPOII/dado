package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

		Usuario u = new Usuario();

		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setFechaAlta(rs.getTimestamp("fecha_alta"));
		u.setFechaAlta(rs.getTimestamp("fecha_modificacion"));
		u.setFechaAlta(rs.getTimestamp("fecha_baja"));

		return u;
	}

}
