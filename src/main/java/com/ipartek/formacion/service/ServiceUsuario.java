package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.domain.Usuario;

public interface ServiceUsuario {

	List<Usuario> listar();

	Usuario buscarPorId(int id);

	boolean crear(Usuario u);

	boolean modificar(Usuario u);

	boolean eliminar(int id) throws DataIntegrityViolationException;

}
