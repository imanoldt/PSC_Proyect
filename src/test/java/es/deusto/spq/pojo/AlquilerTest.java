package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
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
        // Crear objeto Libro simulado con Mockito
        libro = mock(Libro.class);
        when(libro.getNombre()).thenReturn("Libro 1");

        // Crear objeto Alquiler
        usuario = "usuario1";
        fecha = "2023-04-30";
        alquiler = new Alquiler(libro, usuario, fecha);
    }

    @Test
    public void testGetLibro() {
        // Comprobar que el objeto Alquiler devuelve el Libro simulado con Mockito
        assertEquals(libro, alquiler.getLibro());
    }

    @Test
    public void testGetUsuario() {
        // Comprobar que el objeto Alquiler devuelve el usuario correcto
        assertEquals(usuario, alquiler.getUsuario());
    }

    @Test
    public void testGetFechaCompra() {
        // Comprobar que el objeto Alquiler devuelve la fecha correcta
        assertEquals(fecha, alquiler.getFecha_compra());
    }
}
