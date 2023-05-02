package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.deusto.spq.server.jdo.Libro;

public class LibroDTOTest {
	@Mock
	Libro lib;
	
	 @Before
	    public void setUp() {
	        lib = new Libro();
	        lib.setId((long)1);
	        lib.setPrecio(15);
	        lib.setDescripccion("desc");
	        lib.setTipo("tipo");
	    }
	 
    @Test
    public void testLibro() {
        Libro libroMock = mock(Libro.class);

        when(libroMock.getNombre()).thenReturn("El Quijote");
        when(libroMock.getDescripccion()).thenReturn("La historia del hidalgo Alonso Quijano");
        when(libroMock.getPrecio()).thenReturn(15.99f);
        when(libroMock.getTipo()).thenReturn("Novela");

        assertEquals("El Quijote", libroMock.getNombre());
        assertEquals("La historia del hidalgo Alonso Quijano", libroMock.getDescripccion());
        assertEquals(15.99f, libroMock.getPrecio(), 0.001);
        assertEquals("Novela", libroMock.getTipo());
    }
    
    @Test
    public void testGetId() {
    	assertEquals((long)1, lib.getId(), 0.1);
    }
    
    @Test
    public void testGetPrecio() {
    	assertEquals(15, lib.getPrecio(), 0.1);
    }
    
    @Test
    public void testSetPrecio() {
    	lib.setPrecio(10);
    	assertEquals(10, lib.getPrecio(), 0.1);
    }
    
    @Test
    public void testGetDesc() {
    	assertEquals("desc", lib.getDescripccion());
    }
    
    @Test
    public void testGetTipo() {
    	assertEquals("tipo", lib.getTipo());
    }
    @Test
    public void testSetTipo() {
    	lib.setTipo("tipo1");
    	assertEquals("tipo1", lib.getTipo());
    }

    @Test
    public void testSetDesc() {
    	lib.setDescripccion("desc1");
    	assertEquals("desc1", lib.getDescripccion());
    }
    
    @Test
    public void testToString() {
    	assertEquals("Libro [id=" + lib.getId() + ", nombre=" + lib.getNombre() + ", descripccion=" + lib.getDescripccion() + ", precio=" + lib.getPrecio()
				+ ", tipo=" + lib.getTipo() + "]", lib.toString());
    }
    
}
