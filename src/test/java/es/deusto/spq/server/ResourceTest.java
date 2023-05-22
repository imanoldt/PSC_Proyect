package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.pojo.Compra;
import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.Libro;

import java.util.List;

import javax.ws.rs.core.Response;

public class ResourceTest {

	private Resource resource;

	@Before
	public void setUp() {
		resource = new Resource();
	}

	@Test
	public void testGetBooks() {
		List<Libro> books = resource.getBooks();
		assertNotNull(books);
	}

	@Test
	public void testAnadirLibro() {
		Libro libro = new Libro();
		Response response = resource.anadirLibro(libro);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			assertTrue(response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL));
		} else {
			assertTrue(response.getStatusInfo().getFamily().equals(Response.Status.Family.SERVER_ERROR));
		}
	}

}
