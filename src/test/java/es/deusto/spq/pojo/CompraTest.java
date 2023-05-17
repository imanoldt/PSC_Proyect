package es.deusto.spq.pojo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class CompraTest {

    private LibroDTO libro;

    private Compra compra;

    @Before
    public void setUp() {
    	libro = new LibroDTO();
        compra = new Compra(libro, "usuario");
    }
    @Test
    public void testCompra() {
        compra = new Compra();
        assertNotNull(compra);
    }
    @Test
    public void testGetLibro() {
        assertEquals(libro, compra.getLibro());
    }

    @Test
    public void testSetLibro() {
        LibroDTO nuevoLibro = new LibroDTO("Libro1","Desc1",10,"Tipe1");
        compra.setLibro(nuevoLibro);
        assertEquals(nuevoLibro, compra.getLibro());
    }

    @Test
    public void testGetUsuario() {
        assertEquals("usuario", compra.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        compra.setUsuario("otro_usuario");
        assertEquals("otro_usuario", compra.getUsuario());
    }
    @Test
    public void testToString() {
        assertEquals("Compra [libro=" + compra.getLibro() + ", usuario=" + compra.getUsuario() + "]", compra.toString());
    }

//    @Test
//    public void testGetPrecio() {
//        assertEquals(10.0f, compra.getPrecio(), 0.0f);
//    }
//
//    @Test
//    public void testSetPrecio() {
//        compra.setPrecio(20.0f);
//        assertEquals(20.0f, compra.getPrecio(), 0.0f);
//    }
}
