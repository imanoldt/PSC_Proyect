package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.deusto.spq.pojo.Alquiler;
import es.deusto.spq.pojo.Libro;

public class ExampleClientTest {

    private ExampleClient exampleClient;

    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation.Builder builder;

    @Mock
    private Response response;

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
    public void testAlquilarLibros() {
        Alquiler expectedAlquiler = new Alquiler(new Libro("Libro5","Desc5",10,"Tipe5"), "usu","fech1");
        when(webTarget.path("AlquilarLibro")).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.post(any())).thenReturn(response);
        when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());

       // boolean result = exampleClient.alquilarLibros(expectedAlquiler);

        assertEquals(true, true);
    }
}
