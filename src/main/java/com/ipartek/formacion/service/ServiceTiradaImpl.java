package com.ipartek.formacion.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.repository.DAODado;
import com.ipartek.formacion.repository.DAOUsuario;

@Service(value = "serviceTirada")
public class ServiceTiradaImpl implements ServiceTirada {
	private final Log LOG = LogFactory.getLog(getClass());

	@Autowired()
	private DAOUsuario daoUsuario;

	@Autowired()
	private DAODado daoDado;

	@Override
	public boolean lanzarDado(Tirada t) {
		this.LOG.trace("Tiramos dado: ");
		return this.daoDado.lanzarDado(t);
	}

}
