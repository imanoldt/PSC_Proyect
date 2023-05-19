package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mysql.cj.log.Log;

import ch.qos.logback.classic.spi.LoggingEvent;
import es.deusto.spq.pojo.AlquilerDTO;
import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.pojo.Usuario;
import es.deusto.spq.server.jdo.Libro;

public class ExampleClientTest {

	ExampleClient exampleClient;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private WebTarget webTarget;
	@Mock
	private Invocation.Builder builder;

	@Mock
	private Response response;
	
	@Mock
	private Logger logger;

	@Captor
	private ArgumentCaptor<Entity<UserData>> userDataEntityCaptor;
	
	@Captor
	private ArgumentCaptor<Entity<LoggingEvent>> loginEventCaptor;

	Libro lib;
	AlquilerDTO alquiler;
	Usuario usu;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		exampleClient = new ExampleClient("", "");
		exampleClient.webTarget = webTarget;
		exampleClient.setPassword("123");
		exampleClient.setUser("user");
		lib = new Libro();
		lib.setId((long) 1);
		alquiler = new AlquilerDTO(lib.getNombre(), "usu", "fech");
		usu = new Usuario("usu", "pass");
	}

	@After
	public void tearDown() throws Exception {
		exampleClient = null;
	}

	@Test
	public void testGetBooksAlquiler() {
		List<LibroDTO> expectedBooks = new ArrayList<>();
		expectedBooks.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		expectedBooks.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosAlquiler")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(expectedBooks);

		List<LibroDTO> books = exampleClient.getBooksAlquiler();

		assertNotNull(books);
		assertEquals(expectedBooks.size(), books.size());
		for (int i = 0; i < expectedBooks.size(); i++) {
			assertEquals(expectedBooks.get(i).getNombre(), books.get(i).getNombre());
		}
	}

	@Test
	public void testGetBooksAlquilerError() {
		List<LibroDTO> expectedBooks = new ArrayList<>();
		expectedBooks.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		expectedBooks.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosAlquiler")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.NOT_FOUND.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(expectedBooks);

		List<LibroDTO> books = exampleClient.getBooksAlquiler();

		assertNull(books);
	}

	@Test
	public void testGetBooksCompra() {
		List<LibroDTO> expectedBooks = new ArrayList<>();
		expectedBooks.add(new LibroDTO("Libro3", "Desc3", 10, "Tipe3"));
		expectedBooks.add(new LibroDTO("Libro4", "Desc4", 10, "Tipe4"));
		when(webTarget.path("librosCompra")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(expectedBooks);

		List<LibroDTO> books = exampleClient.getBooksCompra();

		assertNotNull(books);
		assertEquals(expectedBooks.size(), books.size());
		for (int i = 0; i < expectedBooks.size(); i++) {
			assertEquals(expectedBooks.get(i).getNombre(), books.get(i).getNombre());
		}
	}

	@Test
	public void testGetBooksCompraEror() {
		List<LibroDTO> expectedBooks = new ArrayList<>();
		expectedBooks.add(new LibroDTO("Libro3", "Desc3", 10, "Tipe3"));
		expectedBooks.add(new LibroDTO("Libro4", "Desc4", 10, "Tipe4"));
		when(webTarget.path("librosCompra")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.NOT_ACCEPTABLE.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(expectedBooks);

		List<LibroDTO> books = exampleClient.getBooksCompra();

		assertNull(books);
	}

	@Test
	public void testGetCompUsu() {
		List<LibroDTO> books = new ArrayList<>();
		books.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		books.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosCompraU")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.post(Entity.entity(usu.getName(), MediaType.APPLICATION_JSON))).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(books);

		books = exampleClient.getBooksCompraUsuario(usu.getName());

		assertNotNull(books);
	}

	@Test
	public void testGetCompUsuError() {
		List<LibroDTO> books = new ArrayList<>();
		books.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		books.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosCompraU")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.post(Entity.entity(usu.getName(), MediaType.APPLICATION_JSON))).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.NOT_FOUND.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(books);

		books = exampleClient.getBooksCompraUsuario(usu.getName());

		assertNull(books);
	}

	@Test
	public void testAlquilarLibros() {
		ArrayList<LibroDTO> lb = new ArrayList<>();
		LibroDTO lib = new LibroDTO();
		lb.add(lib);
		when(webTarget.path("alquilarLibros")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.alquilarLibros(lb, "usu"));
		assertNotNull(alquiler);
		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testAlquilarLibrosErrorALV() {
		ArrayList<LibroDTO> al = new ArrayList<>();
		when(webTarget.path("alquilarLibros")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.alquilarLibros(new ArrayList<>(), "usu"));

		assertFalse(exampleClient.alquilarLibros(al, "usu"));

	}

	@Test
	public void testAlquilarLibrosErrorServeC() {

		ArrayList<LibroDTO> lb = new ArrayList<>();
		LibroDTO lib = new LibroDTO();
		lb.add(lib);
		when(webTarget.path("alquilarLibros")).thenReturn(webTarget);
		if (!lb.isEmpty()) {
			Response response = Response.serverError().build();
			when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
//            assertTrue(exampleClient.alquilarLibros(lb, "usu"));
			assertFalse(exampleClient.alquilarLibros(lb, "usu"));
//            verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
		}

	}

	@Test
	public void testRegisterUser() {
		when(webTarget.path("register")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.registerUser("test-login", "passwd"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
		assertEquals("test-login", userDataEntityCaptor.getValue().getEntity().getLogin());
		assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getPassword());
	}

	@Test
	public void testNotRegisterUser() {
		when(webTarget.path("register")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.registerUser("test-login", "passwd"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
		assertNotEquals("test-login1", userDataEntityCaptor.getValue().getEntity().getLogin());
		assertNotEquals("passwd1", userDataEntityCaptor.getValue().getEntity().getPassword());
	}

	@Test
	public void testLogUser() {
		when(webTarget.path("login")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.loginUser("test-login", "passwd"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
		assertEquals("test-login", userDataEntityCaptor.getValue().getEntity().getLogin());
		assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getPassword());
	}

	@Test
	public void testLogUserWithError() {
		when(webTarget.path("login")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.loginUser("test-login", "passwd"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
		assertEquals("test-login", userDataEntityCaptor.getValue().getEntity().getLogin());
		assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getPassword());
	}

	@Test
	public void testcomprarLibroError() {
		when(webTarget.path("ComprarLibro")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.comprarLibro((long) 1, "tit", "desc", (float) 10.5, "tipo", "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testcomprarLibro() {
		when(webTarget.path("ComprarLibro")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.comprarLibro((long) 1, "tit", "desc", (float) 10.5, "tipo", "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testGetPass() {
		assertEquals("123", exampleClient.getPassword());
	}

	@Test
	public void testGetUs() {
		assertEquals("user", exampleClient.getUser());
	}

	@Test
	public void testInst() {
		ExampleClient exampleClient1 = ExampleClient.getInstance();
		ExampleClient exampleClient2 = null;
		exampleClient2 = ExampleClient.getInstance();
		assertEquals(exampleClient1, exampleClient2);
	}

	@Test
	public void testInstError() {
//		ExampleClient exampleClient = ExampleClient.getInstance();
//        
//        assertNull(exampleClient);
//        verify(loginEventCaptor.capture());
//        //assertEquals("Error: No hay Instance de ExampleClient", loginEventCaptor.getValue().getEntity().getLoggerName());
    }

	@Test
	public void testAanadirLib() {
		when(webTarget.path("anadirLibro")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.anadirLibro(new LibroDTO()));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testAanadirLibError() {
		when(webTarget.path("anadirLibro")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.anadirLibro(new LibroDTO()));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testActLibDevError() {
		when(webTarget.path("ActualizarLibroDevuelto")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.actualizarLibroDevueto((long) 10));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testActLibDev() {
		when(webTarget.path("ActualizarLibroDevuelto")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.actualizarLibroDevueto((long) 10));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testBorrLib() {
		when(webTarget.path("BorrarLibro")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.borrarLibro((long) 10));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testBorrLibError() {
		when(webTarget.path("BorrarLibro")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.borrarLibro((long) 10));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());

	}

	@Test
	public void testDevLib() {
		when(webTarget.path("DevolverLibro")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.DevolverLibro("titulo", "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testDevLibError() {
		when(webTarget.path("DevolverLibro")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.DevolverLibro("titulo", "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testActLibComp() {
		when(webTarget.path("ActualizarLibroComprado")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.actualizarLibroCommprado((long) 1, "tit", "des", 10, "tipo", "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testActLibCompError() {
		when(webTarget.path("ActualizarLibroComprado")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.actualizarLibroCommprado((long) 1, "tit", "des", 10, "tipo", "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testActLibAlq() {
		ArrayList<LibroDTO> expectedBooks = new ArrayList<>();
		LibroDTO lib = new LibroDTO();
		expectedBooks.add(lib);
		when(webTarget.path("ActualizarLibroAlquilado")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertTrue(exampleClient.actualizarLibroAlquilado(expectedBooks, "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testActLibAlqError() {
		ArrayList<LibroDTO> expectedBooks = new ArrayList<>();
		LibroDTO lib = new LibroDTO();
		expectedBooks.add(lib);
		when(webTarget.path("ActualizarLibroAlquilado")).thenReturn(webTarget);

		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.actualizarLibroAlquilado(expectedBooks, "usu"));

		verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
	}

	@Test
	public void testGetUsuUsuError() {
		List<LibroDTO> books = new ArrayList<>();
		books.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		books.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosAlquilarU")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.post(Entity.entity(usu.getName(), MediaType.APPLICATION_JSON))).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.NOT_FOUND.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(books);

		books = exampleClient.getBooksUsuarioUsuario(usu.getName());

		assertNull(books);
	}

	@Test
	public void testGetBookUsu() {
		List<LibroDTO> books = new ArrayList<>();
		books.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		books.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosAlquilarU")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.post(Entity.entity(usu.getName(), MediaType.APPLICATION_JSON))).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(books);

		books = exampleClient.getBooksUsuarioUsuario(usu.getName());

		assertNotNull(books);
	}

	@Test
	public void testGetBookUsuError() {
		List<LibroDTO> books = new ArrayList<>();
		books.add(new LibroDTO("Libro1", "Desc1", 10, "Tipe1"));
		books.add(new LibroDTO("Libro2", "Desc2", 10, "Tipe2"));
		when(webTarget.path("librosAlquilarU")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.NOT_FOUND.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(books);

	}

	@Test
	public void testGetAllBook() {
		List<LibroDTO> expectedBooks = new ArrayList<>();
		expectedBooks.add(new LibroDTO("Libro3", "Desc3", 10, "Tipe3"));
		expectedBooks.add(new LibroDTO("Libro4", "Desc4", 10, "Tipe4"));
		when(webTarget.path("getBooks")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(expectedBooks);

		List<LibroDTO> books = exampleClient.getAllBooks();

		assertNotNull(books);
		assertEquals(expectedBooks.size(), books.size());
		for (int i = 0; i < expectedBooks.size(); i++) {
			assertEquals(expectedBooks.get(i).getNombre(), books.get(i).getNombre());
		}
	}

	@Test
	public void testGetAllBookError() {
		List<LibroDTO> expectedBooks = new ArrayList<>();
		expectedBooks.add(new LibroDTO("Libro3", "Desc3", 10, "Tipe3"));
		expectedBooks.add(new LibroDTO("Libro4", "Desc4", 10, "Tipe4"));
		when(webTarget.path("getBooks")).thenReturn(webTarget);
		when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		when(builder.get()).thenReturn(response);
		when(response.getStatus()).thenReturn(Response.Status.NOT_ACCEPTABLE.getStatusCode());
		when(response.readEntity(new GenericType<List<LibroDTO>>() {
		})).thenReturn(expectedBooks);

		List<LibroDTO> books = exampleClient.getAllBooks();

		assertNull(books);
	}
}
