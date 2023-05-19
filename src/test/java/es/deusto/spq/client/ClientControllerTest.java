package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import es.deusto.spq.pojo.LibroDTO;

public class ClientControllerTest {

	private ClientController controller;
	ExampleClient exampleClient1;
	private ClientController exampleClient;
	private ClientController exampleClient2;
	private ClientController exampleClient3;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private WebTarget webTarget;

	@Mock
	private Invocation.Builder builder;

	@Mock
	private Response response;

	@Mock
	private ClientController ex;
	
	@Mock
	private ExampleClient ec;

	@Before
	public void setUp() {
		exampleClient1 = new ExampleClient("", "");
		exampleClient1.webTarget = webTarget;
		controller = ClientController.getInstance();
		ex = mock(ClientController.class);
		ec = mock(ExampleClient.class);
		exampleClient = ClientController.getInstance();
		exampleClient2 = ClientController.getInstance();
	}

	@Test
	public void testBuild() {
		assertNotNull(new ClientController());
	}

	@Test
	public void testInst() {
		exampleClient = ClientController.getInstance();
		assertEquals(exampleClient2, exampleClient);
	}

	@Test
	public void testInstError() {
		exampleClient = null;
		exampleClient = ClientController.getInstance();
		assertEquals(exampleClient2, exampleClient);
	}

	@Test
	public void testAdminS() {
		assertFalse(ec.anadirLibro(new LibroDTO()));
	}
}
