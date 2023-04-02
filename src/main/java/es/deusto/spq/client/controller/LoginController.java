package es.deusto.spq.client.controller;


import javax.swing.JLabel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import es.deusto.spq.client.gui.VentanaLoginN;
import es.deusto.spq.pojo.Usuario;


public class LoginController {
	
	
	private WebTarget webTarget;
	private Usuario user;
	
	public LoginController(WebTarget webTarget, Usuario user) {
		super();
		this.webTarget = webTarget;
		this.user = user;
	}
	
	public boolean logIn(String email, String password, VentanaLoginN vl) {
		try {
			WebTarget webTarget=this.webTarget.path("/ludofun/logIn");
			
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			
			Usuario usu=new Usuario();
			usu.setName(email);
			usu.setPassword(password);
			
			System.out.println(webTarget.getUri());
			
			//PETICION POST EN FORMA JSON PARA EL SERVIDOR
			Response response = invocationBuilder.post(Entity.entity(usu, MediaType.APPLICATION_JSON));

			if (response.getStatus() != Status.OK.getStatusCode()) {
				System.out.println("ERROR EN EL POST DEL SERVIDOR");
			}
			
			
			boolean logIn=response.readEntity(boolean.class);
			
			if (!logIn) {
				System.out.println("PARAMETROS INTRODUCIDOS ERROR!!");	
			}
			
			return logIn;
			
		}catch(Exception e) {
			System.out.println("Algo ha fallado al realizar el LogIn");
			vl.pack();
			vl.setLocationRelativeTo(null);
			return false;
		}
	}
	
	
	
	
	
	

}
