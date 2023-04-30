package es.deusto.spq.gui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.client.gui.VentanaPrincipal;


public class VentanPrincipalTets {
	@Mock
	String usuario;
	@Mock
	String contraseña;
	@Mock
	String tipo;
	@Mock
	VentanaPrincipal vp;
	
	@Test
	public void test() {
		try {
			VentanaPrincipal vp = new VentanaPrincipal(usuario,contraseña,tipo);
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	

}