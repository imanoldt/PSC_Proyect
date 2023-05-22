package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.ExampleClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LibroDAOTest {

    private ExampleClient libroService;
    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    private Transaction tx;
    private LibroDAO lb;
	
	@Before
    public void setup() {
        pmf = mock(PersistenceManagerFactory.class);

        pm = mock(PersistenceManager.class);
        tx = mock(Transaction.class);

        when(pmf.getPersistenceManager()).thenReturn(pm);
        when(pm.currentTransaction()).thenReturn(tx);
        
        lb = new LibroDAO();
    }

    @Test
    public void testGetAll() {
        assertNull(lb.getAll());
    } 

    @Test
    public void testDel() {
    	LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();

        libroDAO.delete(libro);

        Libro deletedLibro = null;
        assertNull(deletedLibro);
    } 
    
    @Test
    public void testUp() {
    	LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();

        libroDAO.update(libro);

        Libro deletedLibro = null;
        assertNull(deletedLibro);
    } 
    
//    @Test
//    public void testFind() {
//    	String nombreLibro = "Nombre del libro existente";
//
//        LibroDAO libroDAO = new LibroDAO();
//
//        assertNull(libroDAO.find(nombreLibro));
//    } 

}
