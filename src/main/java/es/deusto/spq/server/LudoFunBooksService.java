package es.deusto.spq.server;

import es.deusto.spq.server.jdo.Book;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LudoFunBooksService {

	private PersistenceManager pm = null;
	private Transaction tx = null;
	protected static final Logger logger = LogManager.getLogger();
	private static LudoFunBooksService instance;

	public static LudoFunBooksService getInstance() {
		if (instance == null) {
			instance = new LudoFunBooksService();
		}
		return instance;
	}

	private LudoFunBooksService() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}
	
	//TODO hacer un step de Maven que sea "iniciar la BD"
	public void populateDB() {
		Book b1 = new Book("El capital","Obra de Karl Marx y Engels en la que bla bla bla",(float) 10.0);
		Book b2 = new Book("Teo va al parque", "En esta aventura para los mas jovenes bla bla",(float)5.95);
		Book b3 = new Book("Harry Potter y la piedra","Clasico de la JK en la que un chaval bla bla",(float)9.95);
		Book b4 = new Book("La biblia","El libro sagrado del cristianismo que bla bla bla",(float) 13.95);
		
		
		tx.begin();
		logger.info("InitDB: Introduciendo libros");
		
		try {
			pm.makePersistent(b1);
			pm.makePersistent(b2);
			pm.makePersistent(b3);
			pm.makePersistent(b4);
			
			tx.commit();
		} catch (Exception e) {
			
			logger.error(e.getMessage() + "Esto es normal si la BD ya existe.");
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}
}
