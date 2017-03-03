package com.ipartek.formacion.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.DAOUsuario;

@Service("serviceUsuario")
public class ServiceUsuarioImpl implements ServiceUsuario {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DAOUsuario daoUsuario;

	@Override
	public List<Usuario> listar() {
		logger.trace("listar usuarios");
		return daoUsuario.getAll();
	}

	@Override
	public Usuario buscarPorId(int id) {
		logger.trace("Buscamos usuario por id: " + id);
		Usuario usuario = daoUsuario.getById(id);
		return usuario;
	}

	@Override
	public boolean crear(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) throws DataIntegrityViolationException {
		// TODO Auto-generated method stub
		return false;
	}

}
