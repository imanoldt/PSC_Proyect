package es.deusto.spq.gui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.client.gui.VentanaRegistro;


public class VentanaRegistroTest {
	@Mock
	VentanaRegistro vr;
	
	@Test
	public void test() {
		try {
			VentanaRegistro vr = new VentanaRegistro();
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	

}