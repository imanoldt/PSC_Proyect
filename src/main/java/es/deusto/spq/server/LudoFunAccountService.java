package es.deusto.spq.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LudoFunAccountService {
	
	protected static final Logger logger = LogManager.getLogger();
	private static LudoFunAccountService instance;
	
	public static LudoFunAccountService getInstance() {
		if (instance == null) {
		instance = new LudoFunAccountService();
		}
	return instance;
	}

	
}
