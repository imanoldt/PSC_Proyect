package es.deusto.spq.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.GenericType;

import javax.ws.rs.client.Client;

import es.deusto.spq.client.gui.VentanaLoginN;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.pojo.Compra;
import es.deusto.spq.pojo.AlquilerDTO;
import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.pojo.UserData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleClient {

	protected static final Logger logger = LogManager.getLogger();
	private static String hostname;
	private static String port;
	private static String user;
	private static String password;
//	private static final String USER = "dipina";
//	private static final String PASSWORD = "dipina";

	private Client client;
	WebTarget webTarget;
	// TODO Implementar el patron singleton
	public static ExampleClient instance;

	public ExampleClient(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));

	}
	

	public static ExampleClient getInstance() {
		if (instance == null) {
			logger.error("Error: No hay Instance de ExampleClient");
		}
		return instance;
	}


	public boolean registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("User correctly registered");
			return true;
		}
	}
	
	public boolean loginUser(String name, String password) {
		WebTarget loginUserWebTarget = webTarget.path("login");
		Invocation.Builder invocationBuilder = loginUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setLogin(name);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("User correctly logged");
			return true;
		}
	}

	public boolean anadirLibro(LibroDTO lib) {
		WebTarget booksWebTarget = webTarget.path("anadirLibro");
		Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(lib, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error anadiendo el libro. Code : {}", response.getStatus());
			return false;
		} else {
			logger.info("Libros anadidos correctamente");
			return true;
		}
	}

	public List<LibroDTO> getBooksAlquiler() {
		WebTarget booksWebTarget = webTarget.path("librosAlquiler");
		Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return null;
		} else {
			List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {
			});
			logger.info("Books correctly obtained");
			return books;
		}
	}

	public List<LibroDTO> getAllBooks() {
		WebTarget booksWebTarget = webTarget.path("getBooks");
		Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return null;
		} else {
			List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {
			});
			logger.info("Books correctly obtained");
			return books;
		}
	}

	public List<LibroDTO> getBooksCompra() {
		WebTarget booksWebTarget = webTarget.path("librosCompra");
		Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return null;
		} else {
			List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {
			});
			logger.info("Books correctly obtained");
			return books;
		}
	}

	/**
	 * Metodo para cger los libros que un cliente ha comprado
	 * 
	 * @param usuario
	 * @return
	 */
	public List<LibroDTO> getBooksCompraUsuario(String usuario) {
		WebTarget booksWebTarget = webTarget.path("librosCompraU");
		Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(usuario, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return null;
		} else {
			List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {
			});
			logger.info("Books correctly obtained");
			return books;
		}
	}

	public List<LibroDTO> getBooksUsuarioUsuario(String usuario) {
		WebTarget booksWebTarget = webTarget.path("librosAlquilarU");
		Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(usuario, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return null;
		} else {
			List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {
			});
			logger.info("Books correctly obtained");
			return books;
		}
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		hostname = args[0];
		port = args[1];
		instance = new ExampleClient(hostname, port);

		VentanaLoginN vent = new VentanaLoginN();


	}
	/**
	 * Metodo para alquilar un libro y añadirlo a la tabla de alquilados 
	 * Realiza una solicitud HTTP POST al servidor 
	 * @param id id del libro
	 * @param titulo titulo del libro
	 * @param descrip la descripcion del libro
	 * @param precio precio del libro
	 * @param tipo estado ddel libro si es comprar o vendido
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si el alquiler se realizó correctamente, false en caso contrario
	 */
	public boolean alquilarLibros(ArrayList<LibroDTO> libros, String usuario) {
		WebTarget registerUserWebTarget = webTarget.path("alquilarLibros");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		// convierte un array de libros x usuario en un array de Alquiler.

		ArrayList<AlquilerDTO> alquileres = new ArrayList<AlquilerDTO>();
		if (!libros.isEmpty()) {
			for (LibroDTO libro : libros) {
				alquileres.add(new AlquilerDTO(libro.getNombre(), usuario, new Date().toString()));
			}
			Response response = invocationBuilder.post(Entity.entity(alquileres, MediaType.APPLICATION_JSON));
			if (response.getStatus() != Status.OK.getStatusCode()) {
				logger.error("Error connecting with the server. Code: {}", response.getStatus());
				return false;
			} else {
				logger.info("Libros Alquilados Correctamente");
				return true;
			}
		} else {
			return false;
		}

	}
	
	/**
	 * Metodo para comprar un libro y añadirlo a la tabla de compras 
	 * Realiza una solicitud HTTP POST al servidor 
	 * @param id id del libro
	 * @param titulo titulo del libro
	 * @param descrip la descripcion del libro
	 * @param precio precio del libro
	 * @param tipo estado ddel libro si es comprar o vendido
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si el alquiler se realizó correctamente, false en caso contrario
	 */
	public boolean comprarLibro(long id, String titulo, String descrip, float precio, String tipo, String usuario) {

		WebTarget registerUserWebTarget = webTarget.path("ComprarLibro");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		LibroDTO l = new LibroDTO(titulo, descrip, precio, tipo);
		l.setId(id);
		Compra compra = new Compra(l, usuario);
		Response response = invocationBuilder.post(Entity.entity(compra, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("User correctly logged");
			return true;
		}
	}

	/**
	 * Metodo para actualizar un libro ya alquilado a "alquilado"
	 * @param result lista de libros alquilados
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si la actualizacion se realizó correctamente, false en caso contrario
	 */
	public boolean actualizarLibroAlquilado(ArrayList<LibroDTO> result, String usuario) {

		WebTarget registerUserWebTarget = webTarget.path("ActualizarLibroAlquilado");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(result, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error al actualizar estado del libro alquilado. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("Estado del libro alquilado actualizado");
			return true;
		}

	}

	/**
	 * Metodo para actulizar un libro ya alquilado a "alquilado"
	 * @param result lista de libros alquilados
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si la actualizacion se realizó correctamente, false en caso contrario
	 */
	public boolean actualizarLibroCommprado(long id, String titulo, String descrip, float precio, String tipo,
			String usuario) {
		WebTarget registerUserWebTarget = webTarget.path("ActualizarLibroComprado");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		LibroDTO l = new LibroDTO(titulo, descrip, precio, tipo);
		l.setId(id);
		Response response = invocationBuilder.post(Entity.entity(l, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error al actualizar estado del libro comprado. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("Estado del libro comprado actualizado");
			return true;
		}

	}
	
	/**
	 *Metodo para Devolver un libro y eliminar de la tabla alquilado
	 *Realiza una solicitud HTTP POST al servidor 
	 * @param result lista de libros alquilados
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si la devolución se realizó correctamente, false en caso contrario
	 */
	public boolean DevolverLibro( String titulo, String usuario) {
		WebTarget registerUserWebTarget = webTarget.path("DevolverLibro");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		AlquilerDTO alquiler = new AlquilerDTO(titulo, usuario,"");
		Response response = invocationBuilder.post(Entity.entity(alquiler, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error al devolver un libro. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("Libro devuelto");
			return true;
		}
		
	}

	/**
	 * Metodo para actulizar un libro que ha sifo devuelto a "alquiler"
	 * @param result lista de libros alquilados
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si se actualizó correctamente, false en caso contrario
	 */
	public Boolean actualizarLibroDevueto(Long id) {
		
		WebTarget registerUserWebTarget = webTarget.path("ActualizarLibroDevuelto");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		
		Response response = invocationBuilder.post(Entity.entity(id, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error al actualzar el estado de un libro devuleto. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("Libro devuelto actualizado");
			return true;
		}
	}
	
	

	/**
	 * Metodo para borrar un libro 
	 * @param result lista de libros alquilados
	 * @param usuario nombre del usuario que ha comprado el libro
	 * @return Devuelve true si el borrado se realizó correctamente, false en caso contrario
	 */
	public Boolean borrarLibro(Long id) {
		WebTarget registerUserWebTarget = webTarget.path("BorrarLibro");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		
		Response response = invocationBuilder.post(Entity.entity(id, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error al actualzar el estado de un libro devuleto. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("Libro devuelto actualizado");
			return true;
		}
		
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		ExampleClient.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ExampleClient.password = password;
	}


	
}