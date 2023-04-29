package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class LibroTest {

    @Test
    public void testLibro() {
        // create a mock object of Libro
        Libro libroMock = mock(Libro.class);

        // set up the behavior of the mock object
        when(libroMock.getNombre()).thenReturn("El Quijote");
        when(libroMock.getDescripccion()).thenReturn("La historia del hidalgo Alonso Quijano");
        when(libroMock.getPrecio()).thenReturn(15.99f);
        when(libroMock.getTipo()).thenReturn("Novela");

        // verify the behavior of the mock object
        assertEquals("El Quijote", libroMock.getNombre());
        assertEquals("La historia del hidalgo Alonso Quijano", libroMock.getDescripccion());
        assertEquals(15.99f, libroMock.getPrecio(), 0.001);
        assertEquals("Novela", libroMock.getTipo());
    }

}
