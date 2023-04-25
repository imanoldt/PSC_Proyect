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

	
	public void populateDB() {
//		Book b1 = new Book("El capital","Obra de Karl Marx y Engels en la que bla bla bla",(float) 10.0,"alquiler");
//		Book b2 = new Book("Teo va al parque", "En esta aventura para los mas jovenes bla bla",(float)5.95,"compra");
//		Book b3 = new Book("Harry Potter y la piedra","Clasico de la JK en la que un chaval bla bla",(float)9.95,"compra");
//		Book b4 = new Book("La biblia","El libro sagrado del cristianismo que bla bla bla",(float) 13.95,"alquiler");

		Book b1 = new Book("Cien años de soledad",
				"Obra de Gabriel García Márquez en la que narra la historia de la familia Buendía", (float) 9.5,
				"compra");
		Book b2 = new Book("El Quijote",
				"Obra de Miguel de Cervantes que cuenta las aventuras de un caballero y su escudero", (float) 8.2,
				"alquiler");
		Book b3 = new Book("La Odisea",
				"Obra de Homero que narra el regreso de Ulises a su hogar tras la Guerra de Troya", (float) 7.8,
				"compra");
		Book b4 = new Book("El gran Gatsby",
				"Obra de F. Scott Fitzgerald que describe la vida de la alta sociedad estadounidense en la década de 1920",
				(float) 9.0, "compra");
		Book b5 = new Book("1984", "Obra de George Orwell que retrata una sociedad totalitaria y opresiva", (float) 8.5,
				"alquiler");
		Book b6 = new Book("La Divina Comedia",
				"Obra de Dante Alighieri que describe el viaje del protagonista a través del Infierno, el Purgatorio y el Paraíso",
				(float) 9.3, "compra");
		Book b7 = new Book("Matar a un ruiseñor",
				"Obra de Harper Lee que trata sobre la discriminación racial en la América de los años 30", (float) 8.8,
				"alquiler");
		Book b8 = new Book("Don Juan Tenorio", "Obra de José Zorrilla que relata la historia del famoso seductor",
				(float) 7.5, "compra");
		Book b9 = new Book("La naranja mecánica",
				"Obra de Anthony Burgess que describe la violencia y la psicología criminal", (float) 8.0, "alquiler");
		Book b10 = new Book("La metamorfosis",
				"Obra de Franz Kafka en la que el protagonista se transforma en un insecto gigante", (float) 7.2,
				"compra");
		Book b11 = new Book("El perfume",
				"Obra de Patrick Süskind que describe la obsesión de un asesino por el aroma de las mujeres",
				(float) 8.7, "compra");
		Book b12 = new Book("El retrato de Dorian Gray",
				"Obra de Oscar Wilde que cuenta la historia de un joven que desea la eterna juventud", (float) 9.1,
				"alquiler");
		Book b13 = new Book("El código Da Vinci",
				"Obra de Dan Brown que narra la búsqueda del Santo Grial por parte del profesor Robert Langdon",
				(float) 6.8, "compra");
		Book b14 = new Book("La isla del tesoro",
				"Obra de Robert Louis Stevenson que relata la búsqueda del tesoro del Capitán Flint", (float) 8.3,
				"alquiler");
		Book b15 = new Book("El señor de las moscas",
				"Obra de William Golding que describe la lucha por el poder entre un grupo de niños varados en una isla desierta",
				(float) 7.9, "compra");
		Book b16 = new Book("El nombre de la rosa",
				"Obra de Umberto Eco que cuenta la investigación de una serie de misteriosos asesinatos en una abadía medieval",
				(float) 8.9, "compra");
		Book b17 = new Book("La conjura de los necios",
				"Obra de John Kennedy Toole que narra las desventuras de Ignatius J. Reilly en Nueva Orleans",
				(float) 7.6, "alquiler");
		Book b18 = new Book("El laberinto de la soledad",
				"Obra de Octavio Paz que reflexiona sobre la identidad del mexicano", (float) 9.2, "compra");
		Book b19 = new Book("Moby Dick",
				"Obra de Herman Melville que relata la obsesión del capitán Ahab por capturar a la ballena blanca",
				(float) 8.4, "alquiler");
		Book b20 = new Book("Los Miserables",
				"Obra de Victor Hugo que describe la vida de Jean Valjean y su lucha por la redención", (float) 9.5,
				"compra");
		Book b21 = new Book("La casa de los espíritus",
				"Obra de Isabel Allende que relata la historia de tres generaciones de la familia Trueba en Chile",
				(float) 8.1, "alquiler");
		Book b22 = new Book("La historia interminable",
				"Obra de Michael Ende que narra la aventura de Bastian Balthazar Bux en el mundo de Fantasía",
				(float) 7.3, "compra");
		Book b23 = new Book("Crónicas marcianas",
				"Obra de Ray Bradbury que describe la colonización de Marte por parte de los humanos", (float) 8.7,
				"alquiler");
		Book b24 = new Book("El alquimista",
				"Obra de Paulo Coelho que narra el viaje de Santiago en busca de su tesoro personal", (float) 6.9,
				"compra");
		Book b25 = new Book("El club de la lucha",
				"Obra de Chuck Palahniuk que describe la formación de un grupo de hombres que se reúnen para pelear a puñetazos",
				(float) 8.6, "alquiler");
		Book b26 = new Book("Cien años de soledad",
				"Obra de Gabriel García Márquez que narra la historia de la familia Buendía en Macondo", (float) 9.8,
				"compra");
		Book b27 = new Book("1984",
				"Obra de George Orwell que describe una sociedad totalitaria en la que se controla todo", (float) 9.3,
				"alquiler");
		Book b28 = new Book("La odisea",
				"Obra de Homero que relata el viaje de Ulises de vuelta a casa tras la Guerra de Troya", (float) 8.5,
				"compra");
		Book b29 = new Book("El gran Gatsby",
				"Obra de F. Scott Fitzgerald que describe la vida de los ricos en los años 20 en Nueva York",
				(float) 7.9, "alquiler");
		Book b30 = new Book("El retrato de una dama",
				"Obra de Henry James que cuenta la historia de Isabel Archer y su lucha por la independencia",
				(float) 8.2, "compra");

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
			pm.makePersistent(b16);
			pm.makePersistent(b17);
			pm.makePersistent(b18);
			pm.makePersistent(b19);
			pm.makePersistent(b20);
			pm.makePersistent(b21);
			pm.makePersistent(b22);
			pm.makePersistent(b23);
			pm.makePersistent(b24);
			pm.makePersistent(b25);
			pm.makePersistent(b26);
			pm.makePersistent(b27);
			pm.makePersistent(b28);
			pm.makePersistent(b29);
			pm.makePersistent(b30);

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
