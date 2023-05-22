package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.ClientController;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class UserDAOTest {

	private UserDAO userDAO;
	private PersistenceManager pm;
	private Transaction tx;

	private UserDAO userDAO1;
	private UserDAO u1;
	private UserDAO u2;
	private User user;

	@Before
	public void setUp() {
		userDAO = new UserDAO(); // Crear una instancia del DAO
		// Inicializar la base de datos o configurar las dependencias necesarias
		u1 = UserDAO.getInstance();
		u2 = UserDAO.getInstance();
		user = new User("login", "pass");
	}

	@Test
	public void testDSave() {
		UserDAO userDAO = new UserDAO();
		User alquiler = new User();
		alquiler.setPassword("pass");
		boolean result = userDAO.Save(alquiler);
		assertEquals(false, result);
		
		userDAO = UserDAO.getInstance();
        pm = mock(PersistenceManager.class);
        tx = mock(Transaction.class);
        userDAO.setPersistenceManager(pm);
	}

	@Test
	public void testInst() {
		u1 = UserDAO.getInstance();
		assertEquals(u2, u1);
	}

	@Test
	public void testInstError() {
		u1 = null;
		u1 = UserDAO.getInstance();
		assertEquals(u2, u1);
	}

    @Test
    public void testDel() {
    	UserDAO userDAO = new UserDAO();
        User user = new User();

        userDAO.delete(user);

        User deletedLibro = null;
        assertNull(deletedLibro);
    } 

}
