package es.deusto.spq.server.jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.datanucleus.exceptions.NucleusDataStoreException;

public class DataAccessObjectBase  {
	protected static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	protected static final Logger logger = LogManager.getLogger();
	public void deleteObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			pm.deletePersistent(object);
			tx.commit();
		} catch (Exception e){
			logger.error("$Error deleting an object: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	public void saveObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
		}catch (NucleusDataStoreException e) {
			logger.error("NucleusDataStoreException : " + e.getMessage());
			tx.rollback();
		}
		catch (Exception e) {
			logger.error("Error storing object: " + e.getMessage());
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		pm.close();
	}
}