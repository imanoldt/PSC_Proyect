package es.deusto.spq.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.deusto.spq.pojo.Compra;
import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.CompraJdo;

import es.deusto.spq.pojo.AlquilerDTO;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.Alquiler;
import es.deusto.spq.server.jdo.AlquilerDAO;
import es.deusto.spq.server.jdo.Libro;
import es.deusto.spq.server.jdo.LibroDAO;

import es.deusto.spq.server.jdo.User;
import es.deusto.spq.server.jdo.UserDAO;
import es.deusto.spq.pojo.UserData;

public class LudoFunAccountService {

	private PersistenceManager pm = null;
	private Transaction tx = null;
	protected static final Logger logger = LogManager.getLogger();
	private static LudoFunAccountService instance;
	/**
	 * @brief Devuelve la instancia única de LudoFunAccountService utilizando el patrón Singleton.
	 * @details Si la instancia aún no ha sido creada, se crea una nueva instancia y se devuelve.
	 * @return La instancia única de LudoFunAccountService.
	 */
	public static LudoFunAccountService getInstance() {
		if (instance == null) {
			instance = new LudoFunAccountService();
		}
		return instance; 
	}
	/**
	 * @brief Constructor de la clase LudoFunAccountService.
	 * @details Crea una instancia de LudoFunAccountService y establece el PersistenceManager y la Transaction.
	 */
	public LudoFunAccountService() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction(); 
	}
	/**
	 * Alquila un libro.
	 *
	 * @param alquiler Objeto AlquilerDTO que contiene la información del alquiler.
	 */
	public void alquilarLibro(AlquilerDTO alquiler) {

		Alquiler a = new Alquiler();
//		User u = UserDAO.getInstance().find(alquiler.getUsuario());
		Libro l = LibroDAO.getInstance().find(alquiler.getLibro());
		l.setTipo("ALQUILADO");
		logger.debug("AccountService: A punto de alquilar el siguiente libro: " + l.toString());
		LibroDAO.getInstance().update(l);

		a.setFecha_compra(alquiler.getFecha_compra());
		a.setLibro(l.getNombre());
		a.setUsuario(alquiler.getUsuario());

		AlquilerDAO.getInstance().Save(a);

	}
	/**
	 * Registra un nuevo usuario.
	 *
	 * @param userData Datos del usuario a registrar.
	 * @return True si el registro es exitoso, False si el usuario ya existe.
	 */
	public boolean registerUser(UserData userData) {
		try {
			tx.begin();
			logger.info("Register : Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
			} catch (Exception e) {
				// e.printStackTrace();
				logger.error("Exception launched: {}", e.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
				logger.info("User already exists");
				return false;
			} else {
				logger.info("Creating user: {}", user);
				user = new User(userData.getLogin(), userData.getPassword());
				pm.makePersistent(user);
				logger.info("User created: {}", user);
			}
			tx.commit();
			return true;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}
	/**
	 * Autentica a un usuario.
	 *
	 * @param userData Datos del usuario para la autenticación.
	 * @return True si la autenticación es exitosa, False en caso contrario.
	 */
	public boolean loginUser(UserData userData) {
		try {
			tx.begin();
			logger.info("Login : Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception launched: {}", e.getMessage());
			}
			if (user == null) {
				logger.info("Login : User does not exist");
				return false;

			} else {
				if (user.getPassword() == userData.getPassword()) {
					logger.info("Login: User Does Exist");
					return true;
				} else {
					logger.info("Login: User and Password Do Not Match");
					return false;
				}
			}

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}
	/**
	 * Registra una compra.
	 *
	 * @param c Objeto Compra que contiene los detalles de la compra.
	 * @return True si el registro es exitoso, False en caso contrario.
	 */
	public boolean registerCompra(Compra c) {

		Libro l = new Libro(c.getLibro().getNombre(), c.getLibro().getDescripccion(), c.getLibro().getPrecio(),
				c.getLibro().getTipo());
		l.setId(c.getLibro().getId());
		CompraJdo compra = new CompraJdo(l, c.getUsuario());
		compra.setBookKey(l.getId());
		try {
			tx.begin();
			// logger.info("AÑADIENDO LIBRO: ",compra.getLibro().getId(),
			// compra.getLibro().getNombre(),compra.getUsuario());
			pm.makePersistent(compra);
			logger.info("Purchase added: {}", compra);
			tx.commit();
			return true;
		} catch (Exception e) {
			logger.error("Exception thrown while adding purchase: {}", e.getMessage());
			if (tx.isActive()) {
				tx.rollback();
			}
			return false;
		}
	}

}
