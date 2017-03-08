package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Lanzamiento;

/**
 * Clase para maperar los datos de los lanzamientos
 * 
 * @author Curso
 *
 */
public class LanzamientoMapper implements RowMapper<Lanzamiento> {

  @Override()
  public Lanzamiento mapRow(ResultSet rs, int rowNum) throws SQLException {
    Lanzamiento l = new Lanzamiento();
    l.setId(rs.getLong("id"));
    l.setNombre(rs.getString("nombre"));
    l.setFecha(rs.getString("fecha"));
    return l;
  }

}
