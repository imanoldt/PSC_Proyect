package es.deusto.spq.client.gui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;


public class VentanaMenuNTest {
	@Mock
	String usuario;
	@Mock
	String contraseña;
	@Mock
	VentanaRegistro vm;
	
	@Test
	public void test() {
		try {
			VentanaMenuN vm = new VentanaMenuN(usuario,contraseña);
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	

}