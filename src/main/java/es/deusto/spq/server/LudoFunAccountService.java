package es.deusto.spq.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.User;
import es.deusto.spq.pojo.UserData;


public class LudoFunAccountService {
	
	private PersistenceManager pm=null;
	private Transaction tx=null;
	protected static final Logger logger = LogManager.getLogger();
	private static LudoFunAccountService instance;
	
	public static LudoFunAccountService getInstance() {
		if (instance == null) {
		instance = new LudoFunAccountService();
		}
	return instance;
	}
	private LudoFunAccountService(){
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}

	public boolean registerUser(UserData userData){
		try {
			tx.begin();
			logger.info("Register : Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception launched: {}", e.getMessage());
			}
			logger.info("User: {}", user);
				if(user != null) {
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
	
	public boolean loginUser(UserData userData) {
		try {
			tx.begin();
			logger.info("Login : Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception launched: {}", e.getMessage());
			}if(user == null) {
				logger.info("Login : User does not exist");
				return false;
				
		} else {
			if (user.getPassword() == userData.getPassword() ) {
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
}
