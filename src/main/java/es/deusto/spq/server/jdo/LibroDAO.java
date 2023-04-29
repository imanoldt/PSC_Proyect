package es.deusto.spq.server.jdo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class LibroDAO extends DataAccessObjectBase implements IDataAccessObject<Libro>{
	private static LibroDAO instance;
	
	public static LibroDAO getInstance() {
		if (instance == null) {
			instance = new LibroDAO();
		}
		return instance;
	}
	@Override
	public void Save(Libro object) {
		logger.info("Saving Libro :" + object.getNombre() + " With DAO");
		super.saveObject(object);
		
	}

	@Override
	public void delete(Libro object) {
		super.deleteObject(object);
		
	}

	@Override
	public List<Libro> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Libro> Libroes = new ArrayList<>();
		
		try {
			tx.begin();
			Extent<Libro> extent = pm.getExtent(Libro.class, true);
			
			for (Libro category : extent) {
				Libroes.add(category);
			}
			tx.commit();
			
		}catch(Exception e) {
			logger.error("Error retrieving all the Libroes :" + e.getMessage());
		}finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();	
		}
		return Libroes;
	}

	public Libro find(String nombre) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Libro result = null;
		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE nombre == '" + nombre + "'");
			query.setUnique(true);
			result = (Libro) query.execute();
		}catch(Exception e) {
			logger.error("Error querying an Libro : "+ e.getMessage());
		}finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();	
		}
		return result;
	}

	@Override
	public void update(Libro object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception e) {
			logger.error("Error updating object: " + e.getMessage());
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		pm.close();
	}

}