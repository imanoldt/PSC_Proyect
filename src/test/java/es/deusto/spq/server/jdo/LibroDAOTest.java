//package es.deusto.spq.server.jdo;
//
//import static org.junit.Assert.*;
//
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import javax.jdo.PersistenceManager;
//import javax.jdo.PersistenceManagerFactory;
//import javax.jdo.Transaction;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import es.deusto.spq.client.ExampleClient;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class LibroDAOTest {
//
//    private ExampleClient libroService;
//    private PersistenceManagerFactory pmf;
//    private PersistenceManager pm;
//    private Transaction tx;
//	
//	@Before
//    public void setup() {
//        pmf = mock(PersistenceManagerFactory.class);
//        libroService = new ExampleClient(pmf);
//
//        pm = mock(PersistenceManager.class);
//        tx = mock(Transaction.class);
//
//        when(pmf.getPersistenceManager()).thenReturn(pm);
//        when(pm.currentTransaction()).thenReturn(tx);
//    }
//
//    @Test
//    public void testGetAll() {
//        List<Libro> expectedLibros = Arrays.asList(new Libro("Libro 1"), new Libro("Libro 2"));
//
//        // Configurar el comportamiento simulado del MockTransaction
//        when(tx.isActive()).thenReturn(true);
//        when(pm.getExtent(Libro.class, true)).thenReturn(expectedLibros);
//
//        // Llamar al método getAll()
//        List<Libro> actualLibros = libroService.getAll();
//
//        // Verificar que se hayan realizado las llamadas adecuadas a los métodos
//        verify(pmf).getPersistenceManager();
//        verify(pm).currentTransaction();
//        verify(tx).begin();
//        verify(tx).commit();
//        verify(tx, never()).rollback();
//        verify(pm).close();
//
//        // Verificar que la lista de Libros devuelta sea correcta
//        Assert.assertEquals(expectedLibros, actualLibros);
//    } 
//
//}
