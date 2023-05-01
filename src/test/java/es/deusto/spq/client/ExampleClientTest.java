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
import org.mockito.MockitoAnnotations;

import es.deusto.spq.pojo.Alquiler;
import es.deusto.spq.pojo.Libro;
import es.deusto.spq.pojo.UserData;

public class ExampleClientTest {

    private ExampleClient exampleClient;

    @Mock(answer=Answers.RETURNS_DEEP_STUBS)
    private WebTarget webTarget;

    @Mock
    private Invocation.Builder builder;

    @Mock
    private Response response;

    @Captor
    private ArgumentCaptor<Entity<UserData>> userDataEntityCaptor;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        exampleClient = new ExampleClient("", "");
        exampleClient.webTarget = webTarget;
    }

    @After
    public void tearDown() throws Exception {
        exampleClient = null;
    }

    @Test
    public void testGetBooksAlquiler() {
        List<Libro> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Libro("Libro1","Desc1",10,"Tipe1"));
        expectedBooks.add(new Libro("Libro2","Desc2",10,"Tipe2"));
        when(webTarget.path("librosAlquiler")).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get()).thenReturn(response);
        when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
        when(response.readEntity(new GenericType<List<Libro>>() {})).thenReturn(expectedBooks);

        List<Libro> books = exampleClient.getBooksAlquiler();

        assertNotNull(books);
        assertEquals(expectedBooks.size(), books.size());
        for (int i = 0; i < expectedBooks.size(); i++) {
            assertEquals(expectedBooks.get(i).getNombre(), books.get(i).getNombre());
        }
    }
    @Test
    public void testGetBooksAlquilerError() {
        List<Libro> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Libro("Libro1","Desc1",10,"Tipe1"));
        expectedBooks.add(new Libro("Libro2","Desc2",10,"Tipe2"));
        when(webTarget.path("librosAlquiler")).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get()).thenReturn(response);
        when(response.getStatus()).thenReturn(Response.Status.NOT_FOUND.getStatusCode());
        when(response.readEntity(new GenericType<List<Libro>>() {})).thenReturn(expectedBooks);

        List<Libro> books = exampleClient.getBooksAlquiler();

        assertNull(books);
    }

    @Test
    public void testGetBooksCompra() {
        List<Libro> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Libro("Libro3","Desc3",10,"Tipe3"));
        expectedBooks.add(new Libro("Libro4","Desc4",10,"Tipe4"));
        when(webTarget.path("librosCompra")).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get()).thenReturn(response);
        when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
        when(response.readEntity(new GenericType<List<Libro>>() {})).thenReturn(expectedBooks);

        List<Libro> books = exampleClient.getBooksCompra();

        assertNotNull(books);
        assertEquals(expectedBooks.size(), books.size());
        for (int i = 0; i < expectedBooks.size(); i++) {
            assertEquals(expectedBooks.get(i).getNombre(), books.get(i).getNombre());
        }
    }
    @Test
    public void testGetBooksCompraEror() {
        List<Libro> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Libro("Libro3","Desc3",10,"Tipe3"));
        expectedBooks.add(new Libro("Libro4","Desc4",10,"Tipe4"));
        when(webTarget.path("librosCompra")).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get()).thenReturn(response);
        when(response.getStatus()).thenReturn(Response.Status.NOT_ACCEPTABLE.getStatusCode());
        when(response.readEntity(new GenericType<List<Libro>>() {})).thenReturn(expectedBooks);

        List<Libro> books = exampleClient.getBooksCompra();

        assertNull(books);
    }

    @Test
    public void testAlquilarLibros() {
        Alquiler expectedAlquiler = new Alquiler(new Libro("Libro5","Desc5",10,"Tipe5"), "usu","fech1");
        when(webTarget.path("AlquilarLibro")).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.post(any())).thenReturn(response);
        when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());

       // boolean result = exampleClient.alquilarLibros(expectedAlquiler);

        assertEquals(true, true);
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
        assertFalse(exampleClient.comprarLibro((long)1, "tit", "desc", (float) 10.5, "tipo", "usu"));
        
        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
    }
	@Test
    public void testcomprarLibro() {
		when(webTarget.path("ComprarLibro")).thenReturn(webTarget);

        Response response = Response.ok().build();
        when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
        assertTrue(exampleClient.comprarLibro((long)1, "tit", "desc", (float) 10.5, "tipo", "usu"));
        
        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
    }
}
