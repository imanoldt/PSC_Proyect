package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
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
	public void testDelete() {
		// Verificar que el resultado es null
		alq.delete(null);
		
	}

	@Test
	public void testGetAll() {
		
		List<Alquiler> actual = alq.getAll();
		// Verificar que el resultado es null
		assertEquals(null, actual);
	}

	@Test
	public void testUpdate() {
		// Verificar que el resultado es null
		alq.update(null);
		
	}

	@Test
	public void testFindParam() {
	
		Alquiler actual = alq.find(null);
		// Verificar que el resultado es null
		assertEquals(null, actual);
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
		assertNull(alq.find("usu", "lib"));
	}
	
	@Test
	public void testSave() {
		AlquilerDAO alquilerDAO = new AlquilerDAO();
		Alquiler alquiler = new Alquiler();
		alquiler.setUsuario("John Doe");
		alquiler.setLibro("The Great Gatsby");
		boolean result = alquilerDAO.Save(alquiler);
		assertEquals(false, result);  


	}

}