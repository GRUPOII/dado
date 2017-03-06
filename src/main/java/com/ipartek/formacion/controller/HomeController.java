package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador de la vista de inicio
 * 
 * @author curso
 *
 */
@Controller()
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Vista inicial
	 * 
	 * @param locale
	 *            Devuelve el idioma del navegador
	 * @param model
	 *            atributos para la vista
	 * @return vista de inicio
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	/**
	 * Lanza el dado
	 * 
	 * @param locale
	 *            idioma del navegador
	 * @param model
	 *            atributos
	 * @return vista de inicio
	 */
	@RequestMapping(value = "/lanzar", method = RequestMethod.GET)
	public String lanzarDado(Locale locale, Model model) {
		logger.info("Lanzar dado");

		model.addAttribute("afortunado", "El afortunado es Periko el de los palotes");

		return "index";
	}

	/**
	 * Crar usuario
	 * 
	 * @param locale
	 *            idioma del navegador
	 * @param model
	 *            atributos para la vista
	 * @return vista de inicio
	 */
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String crearUsuario(Locale locale, Model model) {
		logger.info("Lanzar dado");

		model.addAttribute("afortunado", "El afortunado es Periko el de los palotes");

		return "index";
	}

}
