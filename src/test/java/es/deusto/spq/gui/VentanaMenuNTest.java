package es.deusto.spq.gui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.client.gui.VentanaMenuN;


public class VentanaMenuNTest {
	@Mock
	String usuario;
	@Mock
	String contraseña;
	@Mock
	VentanaMenuN vm;
	
	@Test
	public void test() {
		try {
			VentanaMenuN vm = new VentanaMenuN(usuario,contraseña);
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	

}