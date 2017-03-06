package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EstadisticasController {

	private static final Logger LOG = LoggerFactory.getLogger(EstadisticasController.class);

	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public String listar(Model model) {

		// TODO mostrar tabla de estadísticas por usuario

		return "estadisticas/index";
	}

}
