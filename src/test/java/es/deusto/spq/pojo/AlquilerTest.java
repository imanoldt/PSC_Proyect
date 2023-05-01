package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AlquilerTest {

    private Alquiler alquiler;
    private Libro libro;
    private String usuario;
    private String fecha;

    @Before
    public void setUp() {
        libro = mock(Libro.class);
        when(libro.getNombre()).thenReturn("Libro 1");

        usuario = "usuario1";
        fecha = "2023-04-30";
        alquiler = new Alquiler(libro, usuario, fecha);
    }
    
    @Test
    public void testConstructV() {
        assertNotNull(alquiler = new Alquiler());
    }
    
    @Test
    public void testGetLibro() {
        assertEquals(libro, alquiler.getLibro());
    }
    
    @Test
    public void testSetLibro() {
    	libro = new Libro();
    	libro.setNombre("l2");
    	alquiler.setLibro(libro);
        assertEquals("l2", alquiler.getLibro().getNombre());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuario, alquiler.getUsuario());
    }

    @Test
    public void testGetFechaCompra() {
        assertEquals(fecha, alquiler.getFecha_compra());
    }
    
    @Test
    public void testSetFechaCompra() {
    	alquiler.setFecha_compra("2023-05-30");
        assertEquals("2023-05-30", alquiler.getFecha_compra());
    }
    
    @Test
    public void testSetUsuario() {
    	alquiler.setUsuario("Usu10");
        assertEquals("Usu10", alquiler.getUsuario());
    }
}
