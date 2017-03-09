package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test para el Pojo de Usuario
 * 
 * @author Curso
 *
 */
public class UsuarioTest {

  private static final int ID = 2;
  private static final String NOMBRE = "paco";
  private static Timestamp FECHA_ALTA;
  private static Timestamp FECHA_MODIFICACION;
  private static Timestamp FECHA_BAJA;
  private static Usuario usuario = null;

  /**
   * Despues de llamar a la clase
   * 
   * @throws Exception
   *           excepcion
   */
  @BeforeClass()
  public static void setUpBeforeClass() throws Exception {
    usuario = new Usuario();
  }

  /**
   * Antes de llamar a la clase
   * 
   * @throws Exception
   *           excepcion
   */
  @AfterClass()
  public static void tearDownAfterClass() throws Exception {
    usuario = null;
  }

  /**
   * Antes
   * 
   * @throws Exception
   *           excepcuion
   */
  @Before()
  public void setUp() throws Exception {
  }

  /**
   * Despues
   * 
   * @throws Exception
   *           excepcion
   */

  @After()
  public void tearDown() throws Exception {
  }

  /**
   * Test construcot
   */
  @Test()
  public void testConstructor() {

    assertEquals(-1, usuario.getId());

    assertEquals("", usuario.getNombre());

    usuario = null;

    usuario = new Usuario(ID, NOMBRE, FECHA_ALTA, FECHA_MODIFICACION, FECHA_BAJA);
    assertEquals(ID, usuario.getId());
    assertEquals(NOMBRE, usuario.getNombre());
    assertEquals(FECHA_ALTA, usuario.getFechaAlta());
    assertEquals(FECHA_MODIFICACION, usuario.getFechaModificacion());
    assertEquals(FECHA_BAJA, usuario.getFechaBaja());

  }

  /**
   * Test getter
   */

  @Test()
  public void testSetterGetter() {

    usuario.setId(ID);
    assertEquals(ID, usuario.getId());

    usuario.setNombre(NOMBRE);
    assertEquals(NOMBRE, usuario.getNombre());

    usuario.setFechaAlta((Timestamp) FECHA_ALTA);
    assertEquals(FECHA_ALTA, usuario.getFechaAlta());

    usuario.setFechaModificacion((Timestamp) FECHA_MODIFICACION);
    assertEquals(FECHA_MODIFICACION, usuario.getFechaModificacion());

    usuario.setFechaBaja((Timestamp) FECHA_BAJA);
    assertEquals(FECHA_BAJA, usuario.getFechaBaja());

  }

}
