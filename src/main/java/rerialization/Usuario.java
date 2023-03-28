package pruebaprueba;

public class Usuario {
	private String name;
	private String Nickname;
	private String password;
	private Rol rol;
	
	
	
	public Usuario() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Constructor con parametros
	 * @param name
	 * @param nickname
	 * @param password
	 * @param rol
	 */
	public Usuario(String name, String nickname, String password, Rol rol) {
		super();
		this.name = name;
		Nickname = nickname;
		this.password = password;
		this.rol = rol;
	}
}
