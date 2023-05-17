package es.deusto.spq.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class RolTest {

	Rol rol;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		assertNotNull(rol.CLIENTE);
		assertNotNull(rol.ADMINISTRADOR);
	}

}
