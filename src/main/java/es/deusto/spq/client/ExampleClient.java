package es.deusto.spq.client;

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

import es.deusto.spq.pojo.DirectMessage;
import es.deusto.spq.pojo.Libro;
import es.deusto.spq.pojo.MessageData;
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

	public void registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly registered");
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
	
	public List<Libro> getBooks() {
	    WebTarget booksWebTarget = webTarget.path("libros");
	    Invocation.Builder invocationBuilder = booksWebTarget.request(MediaType.APPLICATION_JSON);

	    Response response = invocationBuilder.get();
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        return null;
	    } else {
	        List<Libro> books = response.readEntity(new GenericType<List<Libro>>() {});
	        logger.info("Books correctly obtained");
	        return books;
	    }
	}
	public void sayMessage(String login, String password, String message) {
		WebTarget sayHelloWebTarget = webTarget.path("sayMessage");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);

		DirectMessage directMessage = new DirectMessage();
		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);

		directMessage.setUserData(userData);

		MessageData messageData = new MessageData();
		messageData.setMessage(message);
		directMessage.setMessageData(messageData);

		Response response = invocationBuilder.post(Entity.entity(directMessage, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			String responseMessage = response.readEntity(String.class);
			logger.info("* Message coming from the server: '{}'", responseMessage);
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
}