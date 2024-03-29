package es.deusto.spq.server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.User;
import es.deusto.spq.pojo.AlquilerDTO;

import es.deusto.spq.pojo.UserData;
import es.deusto.spq.pojo.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import es.deusto.spq.server.jdo.Libro;
import es.deusto.spq.server.jdo.Alquiler;
import es.deusto.spq.server.jdo.CompraJdo;
import es.deusto.spq.pojo.Compra;
import es.deusto.spq.pojo.LibroDTO;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

	protected static final Logger logger = LogManager.getLogger();

	private int cont = 0;
	private PersistenceManager pm = null;
	private Transaction tx = null;

	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction(); 
	}

	/*
	 * @POST
	 * 
	 * @Path("/register") public Response registerUser(UserData userData) {
	 * if(LudoFunAccountService.getInstance().registerUser(userData)) { return
	 * Response.ok().build(); } else { //Este es el error especifico 409 return
	 * Response.serverError().status(Response.Status.CONFLICT).build(); } }
	 */
	@POST
	@Path("/anadirLibro")
	public Response anadirLibro(Libro libro) {
		if (LudoFunBooksService.getInstance().AddLibro(libro)) {
			return Response.ok().build();
		} else {
			return Response.serverError().build();
		}
	}

	@POST
	@Path("/login")
	public Response loginUser(UserData userData) {
		try {
			tx.begin();
			logger.info("Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
				if (!user.getPassword().equals(userData.getPassword())) {
					return Response.serverError().build();
				}
			} else {
				return Response.serverError().build();
			}
			tx.commit();

			return Response.ok().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@POST
	@Path("/register")
	public Response registerUser(UserData userData) {
		if (LudoFunAccountService.getInstance().registerUser(userData)) {
			if (getBooks().isEmpty()) {
				LudoFunBooksService.getInstance().populateDB();
			}
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}

	
	@GET
	@Path("/getBooks")
	public List<Libro> getBooks() {
		// obtener lista de los libros de la bbdd
		List<Libro> books = null;
		try {
			Query query = pm.newQuery(Libro.class);
			query.setFilter("tipo == 'alquiler' || tipo == 'compra'");
			books = (List<Libro>) query.execute();
		} finally {
			pm.close();
		}
		
		return books;
	}

	@GET
	@Path("/librosAlquiler")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getBooksAlquiler() {
		// obtener lista de los libros de la bbdd
		List<Libro> books = null;
		try {
			Query query = pm.newQuery(Libro.class);
			query.setFilter("tipo == 'alquiler'");
			books = (List<Libro>) query.execute();
		} finally {
			pm.close();
		}
		return books;
	}

	@GET
	@Path("/librosCompra")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getBooksCompra() {
		// obtener lista de los libros de la bbdd
		List<Libro> books = null;
		try {
			Query query = pm.newQuery(Libro.class);
			query.setFilter("tipo == 'compra'");
			books = (List<Libro>) query.execute();
		} finally {
			pm.close();
		}
		return books;
	}

	@POST
	@Path("/ComprarLibro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response compraLibros(Compra c) {

		if (LudoFunAccountService.getInstance().registerCompra(c)) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}

	/**
	 * metodo coger libros que tiene un usuario especifico comprados
	 * 
	 * @param usuario
	 * @return
	 */
	@POST
	@Path("/librosCompraU")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getBooksCompraUsuario(String usuario) {

		List<Libro> books = new ArrayList();
		List<Long> ids = new ArrayList();

		// coger ids de los libros que hay en la tabla compra con ese usuario
		try {
			// System.out.println("ENTRA");
			Query query = pm.newQuery(CompraJdo.class);
			//System.out.println("QUERY:" + query);
			query.setResult("bookKey");
			query.setFilter("usuario == '" + usuario + "'");
			//System.out.println("QUERY2:" + query);
			ids = (List<Long>) query.execute();

		} finally {

		}

		// buscar los libros que tiene esos ids
		try {
			List<Libro> libros = new ArrayList();
			for (int i = 0; i < ids.size(); i++) {

				Query query = pm.newQuery(Libro.class);
				//System.out.println("QUERY3:" + query);
				query.setFilter("id ==" + ids.get(i));
				//System.out.println("QUERY4:" + query);
				libros = (List<Libro>) query.execute();
				books.addAll(libros);
			}

		} finally {
			pm.close();
		}

		return books;
	}

	
	@POST
	@Path("/librosAlquilarU")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getBooksAlquilarUsuario(String usuario) {

		List<Libro> books = new ArrayList();
		List<String> titulos = new ArrayList();

		// coger ids de los libros que hay en la tabla compra con ese usuario
		try {
			// System.out.println("ENTRA");
			Query query = pm.newQuery(Alquiler.class);
			query.setResult("libro");
			query.setFilter("usuario == '" + usuario + "'");
			System.out.println("QUERY2:" + query);
			titulos = (List<String>) query.execute();
			System.out.println("LONGITUD: "+ titulos.size());

		} finally {

		}

		// buscar los libros que tiene esos ids
		try {
			List<Libro> libros = new ArrayList();
			for (int i = 0; i < titulos.size(); i++) {
				System.out.println("entra");
				Query query = pm.newQuery(Libro.class);
				System.out.println("QUERY3:" + query);
				query.setFilter("nombre == '" + titulos.get(i)+"'");
				System.out.println("QUERY4:" + query);
				libros = (List<Libro>) query.execute();
				books.addAll(libros);
			}

		} finally {
			pm.close();
		}

		return books;
	}

	
	
	

	@POST
	@Path("alquilarLibros")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLibrosAlquiladosUsuario(ArrayList<AlquilerDTO> alquileres) {
		logger.info("Recibidos alquileres:");
		for (AlquilerDTO alquiler : alquileres) {
			logger.info(" " + alquiler.getUsuario() + ": " + alquiler.getLibro() + " - " + alquiler.getFecha_compra());
			LudoFunAccountService.getInstance().alquilarLibro(alquiler);
		}

		return Response.ok("//TODO ALQUILAR LIBROS").build();

	}

	
	@POST
	@Path("/DevolverLibro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DevolvreLibro(AlquilerDTO a) {

		 try {
		        tx.begin();

		        // Busca la tupla en la tabla Alquiler que coincida con el título de libro y el nombre de usuario
		        Query query = pm.newQuery(Alquiler.class, "libro =='"+a.getLibro()+"' && usuario =='"+a.getUsuario()+"'");
		        query.setUnique(true);
		        Alquiler alquiler = (Alquiler) query.execute(a.getLibro(),a.getUsuario());

		        // Si se encuentra la tupla, se elimina de la tabla Alquiler
		        if (alquiler != null) {
		            pm.deletePersistent(alquiler);
		            logger.info("Tupla eliminada de la tabla Alquiler: {}", alquiler);
		        } else {
		            logger.warn("No se encontró ninguna tupla en la tabla Alquiler que coincida con el título de libro {} y el nombre de usuario {}", a.getLibro(), a.getUsuario());
		        }

		        tx.commit();
		        return Response.ok().build();
		    } catch (Exception e) {
		        logger.error("Error en DevolverLibro", e);
		        if (tx.isActive()) {
		            tx.rollback();
		        }
		        return Response.serverError().build();
		    } finally {
		        pm.close();
		    }

	}
	
	/**
	 * Actualizar libro comprado a vendido
	 */
	@POST
	@Path("/ActualizarLibroComprado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarLibrosComprado(LibroDTO libro) {

		try {
			tx.begin();
			Libro l = null;

			l = pm.getObjectById(Libro.class, libro.getId());
			l.setTipo("vendido");
			pm.makePersistent(l);
			logger.info("Libro actualizado: {}", l);
			tx.commit();

			return Response.ok().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}
	
	@POST
	@Path("/ActualizarLibroAlquilado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarLibrosAlquilado(ArrayList<LibroDTO> result) {


		try {
			tx.begin();
			Libro l = null;
			for(LibroDTO li:result) {
				l = pm.getObjectById(Libro.class, li.getId());
				l.setTipo("alquilado");
				pm.makePersistent(l);
				logger.info("Libro actualizado: {}", l);
				
			}
			
			tx.commit();

			return Response.ok().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}


	}

	
	@POST
	@Path("/ActualizarLibroDevuelto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarLibrosDevuelto(long id) {

		try {
			tx.begin();
			Libro l = null;

			l = pm.getObjectById(Libro.class, id);
			l.setTipo("alquiler");
			pm.makePersistent(l);
			logger.info("Libro actualizado: {}", l);
			tx.commit();

			return Response.ok().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}


	@POST
	@Path("/BorrarLibro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response EliminarLibro(long id) {
	    try {
	        tx.begin();
	        Libro l = pm.getObjectById(Libro.class, id);

	        // Verifica si se encontró el objeto Libro en la base de datos
	        if (l != null) {
	            pm.deletePersistent(l);
	            logger.info("Libro eliminado: {}", l);
	            tx.commit();
	            return Response.ok().build();
	        } else {
	        	return Response.serverError().build(); }
	    } finally {
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	        pm.close();
	    }
	}
}
