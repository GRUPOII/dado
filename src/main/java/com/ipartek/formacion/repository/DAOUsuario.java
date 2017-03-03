package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.domain.Usuario;

public interface DAOUsuario {

	void setDatasource(DataSource ds);

	List<Usuario> getAll();

	Usuario getById(int id);

	boolean insert(Usuario u);

	boolean update(Usuario u);

	boolean delete(int id) throws DataIntegrityViolationException;

}
