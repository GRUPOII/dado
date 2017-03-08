package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.ServiceUsuario;

/**
 * Contolador para el admin
 * 
 * @author curso
 *
 */
@Controller()
public class AdminController {

  private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

  @Autowired()
  private ServiceUsuario serviceUsuario;

  /**
   * Listar usuarios
   * 
   * @param model
   *          atributos
   * @return listado de usuarios
   */
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String listar(Model model) {
    LOG.info("listar");

    model.addAttribute("usuarios", this.serviceUsuario.listar());

    return "usuario/index";
  }

  /**
   * Eliminar usuarios
   * 
   * @param id
   *          selecciona el id del usuario a eliminar
   * @param model
   *          atributos
   * @return a la vista de usuarios con el usuario eliminado
   */
  @RequestMapping(value = "/admin/usuario/delete/{id}", method = RequestMethod.GET)
  public String eliminar(@PathVariable() int id, Model model) {

    LOG.info("eliminar usuario " + id);
    String msg = "Usuario no eliminado";

    try {
      if (this.serviceUsuario.eliminar(id)) {
        msg = "Usuario Eliminada con exito";
      }
    } catch (DataIntegrityViolationException e) {
      LOG.error("Integridad de datos violada en eliminar usuario", e);

    }
    model.addAttribute("msg", msg);
    model.addAttribute("usuarios", this.serviceUsuario.listar());

    return "usuario/index";
  }

  /**
   * Da de baja a un usuario
   * 
   * @param id
   *          del usuario
   * @param model
   *          atributos para la JSP
   * @return vista de la lista de usuarios actuialñizada
   */
  @RequestMapping(value = "/admin/usuario/baja/{id}", method = RequestMethod.GET)
  public String darDeBaja(@PathVariable() int id, Model model) {

    LOG.info("dar de baja usuario " + id);
    String msg = "Usuario no dado de baja";

    try {
      if (this.serviceUsuario.darBaja(id)) {
        msg = "Usuario dado de baja con exito";
      }
    } catch (DataIntegrityViolationException e) {
      LOG.error("Integridad de datos violada en baja usuario", e);

    }
    model.addAttribute("msg", msg);
    model.addAttribute("usuarios", this.serviceUsuario.listar());

    return "usuario/index";
  }

  /**
   * Da de alta a un usuario dado de baja
   * 
   * @param id
   *          del usuario
   * @param model
   *          atributos de la JSP
   * @return Lista de usuarios actiualizada
   */
  @RequestMapping(value = "/admin/usuario/alta/{id}", method = RequestMethod.GET)
  public String darDeAlta(@PathVariable() int id, Model model) {

    LOG.info("dar de alta usuario " + id);
    String msg = "Usuario no dado de alta";

    try {
      if (this.serviceUsuario.darAlta(id)) {
        msg = "Usuario dado de alta con exito";
      }
    } catch (DataIntegrityViolationException e) {
      LOG.error("Integridad de datos violada al dar de alta a un usuario", e);
      msg = e.getMessage();
    }
    model.addAttribute("msg", msg);
    model.addAttribute("usuarios", this.serviceUsuario.listar());

    return "usuario/index";
  }

  /**
   * Editamos un usuario, ya sea mofiicar o crear
   * 
   * @param model
   *          atributos que tenemos en la JSP
   * @return vista del formulario de usuarios
   */

  @RequestMapping(value = "/admin/usuario/edit", method = RequestMethod.GET)
  public String irFormularioNuevo(Model model) {

    model.addAttribute("usuario", new Usuario());
    return "usuario/form";
  }

  /**
   * Detalle de un usuario concreto
   * 
   * @param id
   *          del usuario
   * @param model
   *          atributos de la JSP
   * @return vista del detalle de ese usuario
   */
  @RequestMapping(value = "/admin/usuario/edit/{id}", method = RequestMethod.GET)
  public String irFormularioEditar(@PathVariable() int id, Model model) {

    Usuario usuario = this.serviceUsuario.buscarPorId(id);

    model.addAttribute("usuario", usuario);
    return "usuario/form";
  }

  /**
   * Crear usuario
   * 
   * @param usuario
   *          parametro para nuevo usuario
   * @param bindingResult
   *          conexion
   * @param model
   *          modelo
   * @return devuelve el listado con un usuario nuevo
   */
  @RequestMapping(value = "/admin/usuario/crear", method = RequestMethod.POST)
  public String crear(@Validated() Usuario usuario, BindingResult bindingResult, Model model) {

    LOG.info("recibimos datos del formulario " + usuario);
    String msg = null;

    // validar datos del formulario
    if (!bindingResult.hasErrors()) {

      if (usuario.getId() == -1) {

        this.serviceUsuario.crear(usuario);
        msg = "Creado nuevo Usuario";

      } else {

        this.serviceUsuario.modificar(usuario);
        msg = "Modificado Usuario";

      }

    } else {

      LOG.info("formulario con datos no validos");

    }

    model.addAttribute("msg", msg);
    model.addAttribute("usuarios", this.serviceUsuario.listar());
    return "usuario/index";

  }
}
