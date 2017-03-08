package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Tirada;

/**
 * Clase para mappear los datos de las toradas
 * 
 * @author Curso
 *
 */
public class TiradaMapper implements RowMapper<Tirada> {

  @Override()
  public Tirada mapRow(ResultSet rs, int rowNum) throws SQLException {
    Tirada t = new Tirada();

    t.setId(rs.getInt("id"));
    t.setFechaTirada(rs.getDate("fecha"));
    t.setIdUsuario(rs.getInt("usuario_id"));

    return t;
  }

}
