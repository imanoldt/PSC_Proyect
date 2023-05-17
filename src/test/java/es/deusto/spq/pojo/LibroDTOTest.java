package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.jdo.Libro;

public class LibroDTOTest {

	LibroDTO lib;

	@Before
	public void setUp() {
		Long num = (long) 1;
		lib = new LibroDTO();
		lib.setId(num);
		lib.setPrecio(20);
		lib.setDescripccion("desc");
		lib.setTipo("Novela");
		lib.setDescripccion("La historia del hidalgo Alonso Quijano");
		lib.setNombre("El Quijote");

	}

	@Test
	public void testGetNombre() {

		assertEquals("El Quijote", lib.getNombre());
	}

	@Test
	public void testSetNombre() {
		lib.setNombre("nom");
		assertEquals("nom", lib.getNombre());
	}
	
	@Test
	public void testToString() {
		assertEquals("Libro [nombre=" + lib.getNombre() + ", descripccion=" + lib.getDescripccion() + ", precio=" + lib.getPrecio() + "]",
				lib.toString());
	}

}
