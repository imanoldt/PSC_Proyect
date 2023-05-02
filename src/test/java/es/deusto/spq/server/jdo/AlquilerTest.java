package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class AlquilerTest {
	@Mock
    private Alquiler alquiler;

    @Mock
    private Libro mockLibro;

    @Before
    public void setUp() {
    	mockLibro = new Libro("Libro de Prueba", "Libro Mock 01",(float) 5.1, "Alquiler");
        MockitoAnnotations.initMocks(this);
        alquiler = new Alquiler(mockLibro.getNombre(), "usuarioPrueba", new Date().toString());
    }

    @Test
    public void testGetLibro() {
        assertEquals(mockLibro, alquiler.getLibro());
    }

    @Test
    public void testSetLibro() {
        String newMockLibro = "MockLibro 02";
        alquiler.setLibro(newMockLibro);
        assertEquals(newMockLibro, alquiler.getLibro());
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
        String fechaCompra = new Date().toString();
        Alquiler alquilerConFecha = new Alquiler(mockLibro.getNombre(), "usuarioPrueba", fechaCompra);
        assertEquals(fechaCompra, alquilerConFecha.getFecha_compra());
    }

    @Test
    public void testSetFecha_compra() {
        String nuevaFechaCompra = new Date().toString();
        alquiler.setFecha_compra(nuevaFechaCompra);
        assertEquals(nuevaFechaCompra, alquiler.getFecha_compra());
    }
}
