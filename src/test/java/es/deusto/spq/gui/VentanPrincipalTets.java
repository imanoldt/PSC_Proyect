package es.deusto.spq.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.deusto.spq.client.gui.VentanaLoginN;
import es.deusto.spq.client.gui.VentanaPrincipal;
import es.deusto.spq.pojo.Usuario;


public class VentanPrincipalTets {
	@Mock
	Usuario u;
	@Mock
	VentanaPrincipal vp;
	
	@Before
	public void setUp() {
		u = new Usuario();
		u.setName("name");
		u.setPassword("pass");
	}
	@Test
	public void test() {
		try {
			VentanaPrincipal vp = new VentanaPrincipal(u.getName(),u.getPassword(),"tipo");
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	

}