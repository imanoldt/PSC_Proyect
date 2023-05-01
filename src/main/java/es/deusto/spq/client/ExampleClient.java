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
import es.deusto.spq.pojo.Libro;
import es.deusto.spq.pojo.AlquilerDTO;
import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.pojo.UserData;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleClient {

	protected static final Logger logger = LogManager.getLogger();

//	private static final String USER = "dipina";
//	private static final String PASSWORD = "dipina";

	private Client client;
	private WebTarget webTarget;

	public ExampleClient(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
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
		WebTarget registerUserWebTarget = webTarget.path("login");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
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
	
	public List<LibroDTO> getBooksAlquiler() {
	    WebTarget booksWebTarget = webTarget.path("librosAlquiler");
	    Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

	    Response response = invocationBuilder.get();
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        return null;
	    } else {
	        List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {});
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
	        List<LibroDTO> books = response.readEntity(new GenericType<List<LibroDTO>>() {});
	        logger.info("Books correctly obtained");
	        return books;
	    }
	}


	public static void main(String[] args) {
		
		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];
		ExampleClient exampleClient = new ExampleClient(hostname, port);
		
		VentanaLoginN vent = new VentanaLoginN(exampleClient);

		
//		exampleClient.registerUser(USER, PASSWORD);
//		exampleClient.sayMessage(USER, PASSWORD, "This is a test!...");
	}
	public boolean alquilarLibros(ArrayList<LibroDTO> libros,String usuario) {
		WebTarget registerUserWebTarget = webTarget.path("alquilarLibros");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		//convierte un array de libros x usuario en un array de Alquiler.
		
		DateFormat dateFormat = new SimpleDateFormat("d:MMM:yyyy");
		ArrayList<AlquilerDTO> alquileres = new ArrayList<AlquilerDTO>();
		for (LibroDTO libro : libros) {
			alquileres.add(new AlquilerDTO(libro,usuario,new Date()));
		}
		
		
		
		Response response = invocationBuilder.post(Entity.entity(alquileres, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("Libros Alquilados Correctamente");
			return true;
		}
//		for (int i = 0; i < libros.size(); i++) {
//			logger.info("Intentando mandar: [" + libros.get(i)+"] "+ libros.get(i).getNombre());
//		} 
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			logger.error("Error connecting with the server. Code: {}", response.getStatus());
//		} else {
//			logger.info("Libros Alquilados Correctamente");
//		}
//		

	public boolean comprarLibro(long id, String titulo, String descrip, float precio, String tipo, String usuario) {
		System.out.println("EXAMPLE-CLIENT");
		WebTarget registerUserWebTarget = webTarget.path("ComprarLibro");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		Libro l=new Libro(titulo,descrip,precio,tipo);
		l.setId(id);
		Compra compra=new Compra(l,usuario);
		Response response = invocationBuilder.post(Entity.entity(compra, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("User correctly logged");
			return true;
		}
	}
}