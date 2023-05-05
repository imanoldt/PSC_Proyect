package es.deusto.spq.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.deusto.spq.client.gui.AnadirLibroOptionPane;
import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.server.LudoFunAccountService;

public class ClientController {
	public static ClientController instance;
	protected static final Logger logger = LogManager.getLogger();
	
	public static ClientController getInstance() {
		if (instance == null) {
			instance = new ClientController();
		}
		return instance;
	}
	
	public ClientController() {
	}
	
	
	public boolean adminSaveBook(LibroDTO Lib) {
		return ExampleClient.getInstance().anadirLibro(Lib);
		
	}
}
