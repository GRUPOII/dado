package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Ranking;

public class RankingMapper implements RowMapper<Ranking> {

	@Override
	public Ranking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ranking r = new Ranking();

		r.setNombre(rs.getString("nombre"));
		r.setTiradas(rs.getInt("tiradas"));

		return r;
	}

}
