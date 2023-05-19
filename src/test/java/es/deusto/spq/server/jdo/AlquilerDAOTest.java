package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import es.deusto.spq.client.ClientController;

public class AlquilerDAOTest {

	private AlquilerDAO alq;
	private AlquilerDAO alq1;
	
	@Before
	public void setUp() throws Exception {
		alq = AlquilerDAO.getInstance();
		alq1 = AlquilerDAO.getInstance();
	}

	@Test
	public void testInst() {
		alq = AlquilerDAO.getInstance(); 
		assertEquals(alq1, alq);
	}

	@Test
	public void testInstError() {
		alq = null;
		alq = AlquilerDAO.getInstance();
		assertEquals(alq1, alq);
	}

	@Test
	public void testFind() {
		assertNull(alq.find("param")); 
	}

}
