package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class LibroTest {

    Libro libro;

    @Before
    public void setUp() {
        libro = new Libro("El Quijote", "Libro de aventuras", 20.5f, "Literatura");
        libro.setId((long)2);
    }

    @Test
    public void testGetNombre() {
        assertEquals("El Quijote", libro.getNombre());
    }

    @Test
    public void testSetNombre() {
        libro.setNombre("Don Juan Tenorio");
        assertEquals("Don Juan Tenorio", libro.getNombre());
    }

    @Test
    public void testGetDescripccion() {
        assertEquals("Libro de aventuras", libro.getDescripccion());
    }

    @Test
    public void testSetDescripccion() {
        libro.setDescripccion("Libro de terror");
        assertEquals("Libro de terror", libro.getDescripccion());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(20.5f, libro.getPrecio(), 0.01);
    }

    @Test
    public void testSetPrecio() {
        libro.setPrecio(25.5f);
        assertEquals(25.5f, libro.getPrecio(), 0.01);
    }

    @Test
    public void testGetTipo() {
        assertEquals("Literatura", libro.getTipo());
    }

    @Test
    public void testSetTipo() {
        libro.setTipo("Ciencia ficción");
        assertEquals("Ciencia ficción", libro.getTipo());
    }
    @Test
    public void testGetId() {
        assertEquals((long)2, libro.getId(), 1);
    }

    @Test
    public void testSetId() {
        libro.setId((long) 1);
        assertEquals((long)1, libro.getId(), 1);
    }
    
    @Test
    public void testStr() {
        assertEquals("Libro [id=" + libro.getId() + ", nombre=" + libro.getNombre() + ", descripccion=" + libro.getDescripccion() + ", precio=" + libro.getPrecio()
				+ ", tipo=" + libro.getTipo() + "]", libro.toString());
    }
}
