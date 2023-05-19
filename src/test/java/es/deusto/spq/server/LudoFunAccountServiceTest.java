package es.deusto.spq.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import es.deusto.spq.client.ClientController;
import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.server.jdo.User;

public class LudoFunAccountServiceTest {

	private LudoFunAccountService lf;
	private LudoFunAccountService lf2;

	private static final PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");


	private WebTarget target;

//	@Rule
//	public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
//
//	@BeforeClass
//	public static void prepareTests() throws Exception {
//		// start the server
//		server = Main.startServer();
//
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		try {
//			tx.begin();
//			pm.makePersistent(new User("john", "1234"));
//			tx.commit();
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}

//	@Before
//	public void setUp() {
//		// create the client
//		Client c = ClientBuilder.newClient();
//		target = c.target(Main.BASE_URI).path("resource");
//	}
//
//	@AfterClass
//	public static void tearDownServer() throws Exception {
//		server.shutdown();
//
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		try {
//			tx.begin();
//			pm.newQuery(User.class).deletePersistentAll();
//			pm.newQuery(Message.class).deletePersistentAll();
//			tx.commit();
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}

//	@Before
//	public void setUp() throws Exception {
//		lf2 = LudoFunAccountService.getInstance();
//	}
	@Before
	public void setUp() {
		lf = LudoFunAccountService.getInstance();
		lf2 = LudoFunAccountService.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInst() {
		lf = LudoFunAccountService.getInstance();
		assertEquals(lf2, lf);
	}

	@Test
	public void testInstError() {
		lf = null;
		lf = LudoFunAccountService.getInstance();
		assertEquals(lf2, lf);
	}

}
