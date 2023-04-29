package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class BookTest {

    @Mock
    Book mockedBook;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockedBook = new Book("El Quijote", "Libro de aventuras", 20.5f, "Literatura");
    }

    @Test
    public void testGetNombre() {
        assertEquals("El Quijote", mockedBook.getNombre());
    }

    @Test
    public void testSetNombre() {
        mockedBook.setNombre("Don Juan Tenorio");
        assertEquals("Don Juan Tenorio", mockedBook.getNombre());
    }

    @Test
    public void testGetDescripccion() {
        assertEquals("Libro de aventuras", mockedBook.getDescripccion());
    }

    @Test
    public void testSetDescripccion() {
        mockedBook.setDescripccion("Libro de terror");
        assertEquals("Libro de terror", mockedBook.getDescripccion());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(20.5f, mockedBook.getPrecio(), 0.01);
    }

    @Test
    public void testSetPrecio() {
        mockedBook.setPrecio(25.5f);
        assertEquals(25.5f, mockedBook.getPrecio(), 0.01);
    }

    @Test
    public void testGetTipo() {
        assertEquals("Literatura", mockedBook.getTipo());
    }

    @Test
    public void testSetTipo() {
        mockedBook.setTipo("Ciencia ficción");
        assertEquals("Ciencia ficción", mockedBook.getTipo());
    }
}
