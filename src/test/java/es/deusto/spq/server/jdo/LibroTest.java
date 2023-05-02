package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class LibroTest {

    @Mock
    Libro mockedLibro;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockedLibro = new Libro("El Quijote", "Libro de aventuras", 20.5f, "Literatura");
        mockedLibro.setId((long)2);
    }

    @Test
    public void testGetNombre() {
        assertEquals("El Quijote", mockedLibro.getNombre());
    }

    @Test
    public void testSetNombre() {
        mockedLibro.setNombre("Don Juan Tenorio");
        assertEquals("Don Juan Tenorio", mockedLibro.getNombre());
    }

    @Test
    public void testGetDescripccion() {
        assertEquals("Libro de aventuras", mockedLibro.getDescripccion());
    }

    @Test
    public void testSetDescripccion() {
        mockedLibro.setDescripccion("Libro de terror");
        assertEquals("Libro de terror", mockedLibro.getDescripccion());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(20.5f, mockedLibro.getPrecio(), 0.01);
    }

    @Test
    public void testSetPrecio() {
        mockedLibro.setPrecio(25.5f);
        assertEquals(25.5f, mockedLibro.getPrecio(), 0.01);
    }

    @Test
    public void testGetTipo() {
        assertEquals("Literatura", mockedLibro.getTipo());
    }

    @Test
    public void testSetTipo() {
        mockedLibro.setTipo("Ciencia ficción");
        assertEquals("Ciencia ficción", mockedLibro.getTipo());
    }
    @Test
    public void testGetId() {
        assertEquals((long)2, mockedLibro.getId(), 1);
    }

    @Test
    public void testSetId() {
        mockedLibro.setId((long) 1);
        assertEquals((long)1, mockedLibro.getId(), 1);
    }
}
