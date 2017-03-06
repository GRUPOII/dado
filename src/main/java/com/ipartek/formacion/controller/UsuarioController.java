package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * Eliminar usuarios
	 * 
	 * @param id
	 *            selecciona el id del usuario a eliminar
	 * @param model
	 *            atributos
	 * @return a la vista de usuarios con el usuario eliminado
	 */
	@RequestMapping(value = "/usuario/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int id, Model model) {

		LOG.info("eliminar usuario " + id);
		String msg = "Usuario no eliminado";

		try {
			if (this.serviceUsuario.eliminar(id)) {
				msg = "Usuario Eliminada con exito";
			}
		} catch (DataIntegrityViolationException e) {
			msg = e.getMessage();
		}
		model.addAttribute("msg", msg);
		model.addAttribute("usuarios", this.serviceUsuario.listar());

		return "usuario/index";
	}

}
