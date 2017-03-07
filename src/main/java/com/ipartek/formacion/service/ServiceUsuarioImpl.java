package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Ranking;
import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.DAODado;
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

	@Autowired()
	private DAODado daoDado;

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
		this.LOG.trace("Eliminamos usuario: " + id);
		return daoUsuario.delete(id);
	}

	@Override
	public Usuario lanzarDado() {
		ArrayList<Usuario> usuariosAlta = (ArrayList<Usuario>) daoUsuario.getAllUsuariosDeAlta();
		// Creamos un numero aleatorio con la largura del array resultante
		double aleatorio = Math.round(Math.random() * (usuariosAlta.size() - 1));
		int n = (int) aleatorio;
		LOG.info("Numero aleatorio");
		return usuariosAlta.get(n);
	}

	@Override
	public boolean darBaja(int id) {
		this.LOG.trace("Damos de baja usuario: " + id);
		return daoUsuario.baja(id);
	}

	@Override
	public boolean darAlta(int id) {
		this.LOG.trace("Damos de alta usuario: " + id);
		return daoUsuario.alta(id);
	}

}
