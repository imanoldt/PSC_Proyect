package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.ClientController;

public class AlquilerDAOTest {

	AlquilerDAO alq;
	
	@Before
	public void setUp() throws Exception {
		alq = new AlquilerDAO();
	}

	@Test
	public void testInst() {
		AlquilerDAO alq = AlquilerDAO.getInstance();
		assertNotNull(alq);
	}

	@Test
	public void testInstError() {
		alq = null;
		AlquilerDAO alq = AlquilerDAO.getInstance();
		assertNotNull(alq);
	}

	@Test
	public void testFind() {
		assertNull(alq.find("param"));
	}

}
