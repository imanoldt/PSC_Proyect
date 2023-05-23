package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import categories.IntegrationTest;
import es.deusto.spq.client.ClientController;
import es.deusto.spq.server.jdo.Libro;

@Category({ IntegrationTest.class, PerformanceTest.class })
public class LudoFunBooksServicePerfTest {

	private LudoFunBooksService lfb;
	private LudoFunBooksService lfb2;
	
	@Rule 
	public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
	
	@Before
	public void setUp() throws Exception {
		lfb = LudoFunBooksService.getInstance();
		lfb2 = LudoFunBooksService.getInstance(); 
	}


	@Test
    @JUnitPerfTest(threads = 20, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 400)
	public void testInst() {
		lfb = LudoFunBooksService.getInstance();
		assertEquals(lfb2, lfb);
	}

	@Test
    @JUnitPerfTest(threads = 1, durationMs = 5000)
	@JUnitPerfTestRequirement(meanLatency = 400)
	public void testInstError() {
		lfb = null;
		lfb = LudoFunBooksService.getInstance();
		assertEquals(lfb2, lfb);
	}
	@Test
    @JUnitPerfTest(threads = 20, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 400)
	public void testPopu() {
		Libro l1 = new Libro("El capital", "Obra de Karl Marx y Engels en la que bla bla bla", (float) 10.0, "alquiler");
		ArrayList<Libro> bks = new ArrayList<Libro>();
		lfb.populateDB();
		bks.add(l1);
		assertEquals(l1 ,bks.get(0));
	} 

}
