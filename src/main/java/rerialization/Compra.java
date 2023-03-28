package pruebaprueba;

public class Compra {
	
	private Libro libro;
	private Usuario usuario;
	private float precio;
	
	/**
	 * constructor vacio
	 */
	public Compra() {
		
	}
	
	/**
	 * constructor con los siguientes parametros
	 * @param libro
	 * @param usuario
	 * @param precio
	 */
	public Compra(Libro libro, Usuario usuario, float precio) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.precio = precio;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}
