package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.ClientController;
import es.deusto.spq.server.jdo.Libro;

public class LudoFunBooksServiceTest {

	private LudoFunBooksService lfb;
	private LudoFunBooksService lfb2;
	
	@Before
	public void setUp() throws Exception {
		lfb = LudoFunBooksService.getInstance();
		lfb2 = LudoFunBooksService.getInstance(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInst() {
		lfb = LudoFunBooksService.getInstance();
		assertEquals(lfb2, lfb);
	}

	@Test
	public void testInstError() {
		lfb = null;
		lfb = LudoFunBooksService.getInstance();
		assertEquals(lfb2, lfb);
	}
	
	@Test
	public void testPopu() {
		Libro l1 = new Libro("El capital", "Obra de Karl Marx y Engels en la que bla bla bla", (float) 10.0, "alquiler");
		ArrayList<Libro> bks = new ArrayList<Libro>();
//		lfb.populateDB();
		bks.add(l1);
		assertEquals(l1 ,bks.get(0));
	} 

}
