package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para las estadisticas
 * 
 * @author Curso
 *
 */
@Controller()
public class EstadisticasController {

	private static final Logger LOG = LoggerFactory.getLogger(EstadisticasController.class);

	/**
	 * Lista las estadisticas
	 * 
	 * @param model
	 *            atributos para la JSP
	 * @return vista index
	 */
	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public String listar(Model model) {

		// TODO mostrar tabla de estadísticas por usuario
		LOG.info("Lista las estadicticas");
		return "estadisticas/index";
	}

}
