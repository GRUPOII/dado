package com.ipartek.formacion.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Ranking;
import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.DAOUsuario;

/**
 * Implementacion del servicio USuario
 * 
 * @author curso
 *
 */
@Service(value = "serviceUsuario")
public class ServiceUsuarioImpl implements ServiceUsuario {

	private final Log LOG = LogFactory.getLog(getClass());

	@Autowired()
	private DAOUsuario daoUsuario;

	@Override()
	public List<Usuario> listar() {
		this.LOG.trace("listar usuarios");
		return this.daoUsuario.getAll();
	}

	@Override()
	public List<Ranking> ranking() {
		this.LOG.trace("ranking usuarios");
		return this.daoUsuario.ranking();
	}

	@Override()
	public Usuario buscarPorId(int id) {
		this.LOG.trace("Buscamos usuario por id: " + id);
		Usuario usuario = this.daoUsuario.getById(id);
		return usuario;
	}

	@Override()
	public boolean crear(Usuario u) {
		this.LOG.trace("Insertamos usuario: " + u);
		return this.daoUsuario.insert(u);
	}

	@Override()
	public boolean modificar(Usuario u) {
		this.LOG.trace("Modificamos usuario: " + u);
		return this.daoUsuario.update(u);
	}

	@Override()
	public boolean eliminar(int id) throws DataIntegrityViolationException {
		// TODO Auto-generated method stub
		return daoUsuario.delete(id);
	}

}
