package es.deusto.spq.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.deusto.spq.client.gui.VentanaLoginN;
import es.deusto.spq.client.gui.VentanaMenuN;
import es.deusto.spq.pojo.Usuario;


public class VentanaMenuNTest {
	@Mock
	Usuario u;
	@Mock
	VentanaMenuN vm;
	
	@Before
	public void setUp() {
		u = new Usuario();
		u.setName("user");
		u.setPassword("pass");
		}
	@Test
	public void test() {
		try {
			VentanaMenuN vm = new VentanaMenuN(u.getName(),u.getPassword());
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	

}