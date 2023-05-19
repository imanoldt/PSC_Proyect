package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.server.jdo.CompraJdo;
import es.deusto.spq.server.jdo.Libro;


public class CompraJdoTest {

	private Libro libro;
	private String usuario;

	private CompraJdo compra;

	@Before
	public void setUp() {
		usuario = "usuario1";
		compra = new CompraJdo(libro, usuario);
	}

	@Test
	public void testBui() {
		assertNotNull(new  CompraJdo());
	}
	
	@Test
	public void testGetLibro() {
		assertEquals(libro, compra.getLibro());
	}

	@Test
	public void testSetLibro() {
		Libro libroMock2 = mock(Libro.class);
		compra.setLibro(libroMock2);
		assertEquals(libroMock2, compra.getLibro());
	}

	@Test
	public void testGetUsuario() {
		assertEquals(usuario, compra.getUsuario());
	}

	@Test
	public void testSetUsuario() {
		String usuarioMock2 = "usuario2";
		compra.setUsuario(usuarioMock2);
		assertEquals(usuarioMock2, compra.getUsuario());
	}

	@Test
	public void testGetBookK() {
		compra.setBookKey((long)1);
		assertEquals((long)1, compra.getBookKey());
	}

	@Test
	public void testSetBookK() {
		compra.setBookKey((long)1);
		assertEquals((long)1, compra.getBookKey());
	}
//	@Test
//	public void testGetPrecio() {
//		assertEquals(precioMock, compra.getPrecio(), 0);
//	}
//
//	@Test
//	public void testSetPrecio() {
//		float precioMock2 = 20.0f;
//		compra.setPrecio(precioMock2);
//		assertEquals(precioMock2, compra.getPrecio(), 0);
//	}
}
