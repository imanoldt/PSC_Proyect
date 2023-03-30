package es.deusto.spq.pojo;

public class Usuario {
	private String name;
	private String password;

	public Usuario() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param name
	 * @param nickname
	 * @param password
	 * @param rol
	 */
	public Usuario(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
}
