package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceUsuario;

/**
 * Controlador del usuario
 * 
 * @author curso
 *
 */
@Controller()
public class UsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired()
	private ServiceUsuario serviceUsuario;

	/**
	 * Listar usuarios
	 * 
	 * @param model
	 *            atributos
	 * @return listado de usuarios
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String listar(Model model) {
		LOG.info("listar");

		model.addAttribute("usuarios", this.serviceUsuario.listar());

		return "usuario/index";
	}

}
