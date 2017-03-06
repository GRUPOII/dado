package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;
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

	/**
	 * 
	 * @param usuario
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/usuario/crear", method = RequestMethod.POST)
	public String crear(@Validated Usuario usuario, BindingResult bindingResult, Model model) {

		LOG.info("recibimos datos del formulario " + usuario);
		String msg = null;

		// validar datos del formulario
		if (!bindingResult.hasErrors()) {

			if (usuario.getId() == -1) {

				serviceUsuario.crear(usuario);
				msg = "Creado nuevo Usuario";

			} else {

				serviceUsuario.modificar(usuario);
				msg = "Modificado Usuario";

			}

		} else {

			LOG.info("formulario con datos no validos");

		}

		model.addAttribute("msg", msg);
		return "usuario/form";
	}

}
