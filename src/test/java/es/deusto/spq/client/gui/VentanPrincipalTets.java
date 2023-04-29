package es.deusto.spq.client.gui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;


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
			assertTrue(false);
		}
	}
	

}