package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceUsuario;

@Controller
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	ServiceUsuario serviceUsuario;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String listar(Model model) {

		model.addAttribute("usuarios", serviceUsuario.listar());

		return "usuario/index";
	}

}
