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
//		Book b1 = new Book("El capital","Obra de Karl Marx y Engels en la que bla bla bla",(float) 10.0,"alquiler");
//		Book b2 = new Book("Teo va al parque", "En esta aventura para los mas jovenes bla bla",(float)5.95,"compra");
//		Book b3 = new Book("Harry Potter y la piedra","Clasico de la JK en la que un chaval bla bla",(float)9.95,"compra");
//		Book b4 = new Book("La biblia","El libro sagrado del cristianismo que bla bla bla",(float) 13.95,"alquiler");
		
		
		Book b1 = new Book("Cien años de soledad","Obra de Gabriel García Márquez en la que narra la historia de la familia Buendía",(float) 9.5,"compra");
		Book b2 = new Book("El Quijote","Obra de Miguel de Cervantes que cuenta las aventuras de un caballero y su escudero",(float) 8.2,"alquiler");
		Book b3 = new Book("La Odisea","Obra de Homero que narra el regreso de Ulises a su hogar tras la Guerra de Troya",(float) 7.8,"compra");
		Book b4 = new Book("El gran Gatsby","Obra de F. Scott Fitzgerald que describe la vida de la alta sociedad estadounidense en la década de 1920",(float) 9.0,"compra");
		Book b5 = new Book("1984","Obra de George Orwell que retrata una sociedad totalitaria y opresiva",(float) 8.5,"alquiler");
		Book b6 = new Book("La Divina Comedia","Obra de Dante Alighieri que describe el viaje del protagonista a través del Infierno, el Purgatorio y el Paraíso",(float) 9.3,"compra");
		Book b7 = new Book("Matar a un ruiseñor","Obra de Harper Lee que trata sobre la discriminación racial en la América de los años 30",(float) 8.8,"alquiler");
		Book b8 = new Book("Don Juan Tenorio","Obra de José Zorrilla que relata la historia del famoso seductor",(float) 7.5,"compra");
		Book b9 = new Book("La naranja mecánica","Obra de Anthony Burgess que describe la violencia y la psicología criminal",(float) 8.0,"alquiler");
		Book b10 = new Book("La metamorfosis","Obra de Franz Kafka en la que el protagonista se transforma en un insecto gigante",(float) 7.2,"compra");
		Book b11 = new Book("El perfume","Obra de Patrick Süskind que describe la obsesión de un asesino por el aroma de las mujeres",(float) 8.7,"compra");
		Book b12 = new Book("El retrato de Dorian Gray","Obra de Oscar Wilde que cuenta la historia de un joven que desea la eterna juventud",(float) 9.1,"alquiler");
		Book b13 = new Book("El código Da Vinci","Obra de Dan Brown que narra la búsqueda del Santo Grial por parte del profesor Robert Langdon",(float) 6.8,"compra");
		Book b14 = new Book("La isla del tesoro","Obra de Robert Louis Stevenson que relata la búsqueda del tesoro del Capitán Flint",(float) 8.3,"alquiler");
		Book b15 = new Book("El señor de las moscas","Obra de William Golding que describe la lucha por el poder entre un grupo de niños varados en una isla desierta",(float) 7.9,"compra");
		
		tx.begin();
		logger.info("InitDB: Introduciendo libros");
		
		try {
			pm.makePersistent(b1);
			pm.makePersistent(b2);
			pm.makePersistent(b3);
			pm.makePersistent(b4);
			pm.makePersistent(b5);
			pm.makePersistent(b6);
			pm.makePersistent(b7);
			pm.makePersistent(b8);
			pm.makePersistent(b9);
			pm.makePersistent(b10);
			pm.makePersistent(b11);
			pm.makePersistent(b12);
			pm.makePersistent(b13);
			pm.makePersistent(b14);
			pm.makePersistent(b15);
			
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
