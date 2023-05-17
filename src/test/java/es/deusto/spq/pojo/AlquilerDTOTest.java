package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AlquilerDTOTest {

    AlquilerDTO alquiler;
    LibroDTO libro;
    String usuario;
    String fecha;

    @Before
    public void setUp() {
        libro = new LibroDTO();
        
        alquiler = new AlquilerDTO();
        alquiler.setLibro("lib");
        alquiler.setUsuario("usu");
        alquiler.setFecha_compra("2023-04-30");

        usuario = "usuario1";
        fecha = "2023-04-30";
        //TODO alquiler = new AlquilerDTO(libro, usuario, fecha);
    }
    
    @Test
    public void testConstructV() {
        assertNotNull(alquiler);
    }
    
    @Test
    public void testGetLibro() {
        assertEquals("lib", alquiler.getLibro());
    }
    
    @Test
    public void testSetLibro() {
    	alquiler = new AlquilerDTO();
    	alquiler.setLibro("l2");
        assertEquals("l2", alquiler.getLibro());
    }

    @Test
    public void testGetUsuario() {
        assertEquals("usu", alquiler.getUsuario());
    }

    @Test
    public void testGetFechaCompra() {
        assertEquals("2023-04-30", alquiler.getFecha_compra());
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
