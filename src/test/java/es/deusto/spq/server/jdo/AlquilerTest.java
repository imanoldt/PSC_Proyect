package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class AlquilerTest {

    private Alquiler alquiler;

    @Mock
    private Book mockBook;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        alquiler = new Alquiler(mockBook, "usuarioPrueba", new Date());
    }

    @Test
    public void testGetLibro() {
        assertEquals(mockBook, alquiler.getLibro());
    }

    @Test
    public void testSetLibro() {
        Book newMockBook = Mockito.mock(Book.class);
        alquiler.setLibro(newMockBook);
        assertEquals(newMockBook, alquiler.getLibro());
    }

    @Test
    public void testGetUsuario() {
        assertEquals("usuarioPrueba", alquiler.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        alquiler.setUsuario("otroUsuarioPrueba");
        assertEquals("otroUsuarioPrueba", alquiler.getUsuario());
    }

    @Test
    public void testGetFecha_compra() {
        Date fechaCompra = new Date();
        Alquiler alquilerConFecha = new Alquiler(mockBook, "usuarioPrueba", fechaCompra);
        assertEquals(fechaCompra, alquilerConFecha.getFecha_compra());
    }

    @Test
    public void testSetFecha_compra() {
        Date nuevaFechaCompra = new Date();
        alquiler.setFecha_compra(nuevaFechaCompra);
        assertEquals(nuevaFechaCompra, alquiler.getFecha_compra());
    }
}
