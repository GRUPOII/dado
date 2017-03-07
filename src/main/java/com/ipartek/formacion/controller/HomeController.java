package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.ServiceEstadistica;
import com.ipartek.formacion.service.ServiceTirada;
import com.ipartek.formacion.service.ServiceUsuario;

/**
 * Controlador de la vista de inicio
 * 
 * @author curso
 *
 */
@Controller()
public class HomeController {

	@Autowired()
	private ServiceUsuario serviceUsuario;

	@Autowired()
	private ServiceTirada serviceTirada;

	@Autowired()
	private ServiceEstadistica serviceEstadisticas;

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

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
		LOG.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("usuarios", this.serviceUsuario.ranking());

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
		LOG.info("Lanzar dado");

		Usuario afortunado = serviceUsuario.lanzarDado();
		Tirada t = new Tirada();
		t.setIdUsuario(afortunado.getId());

		serviceTirada.lanzarDado(t);
		model.addAttribute("afortunado", afortunado.getNombre());

		model.addAttribute("usuarios", this.serviceUsuario.ranking());
		return "index";
	}

	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public String listarEstadisticas(Model model) {
		LOG.info("estadisticas");

		model.addAttribute("estadisticas", this.serviceEstadisticas.lanzamientosTotales());

		return "estadisticas/index";
	}

}
