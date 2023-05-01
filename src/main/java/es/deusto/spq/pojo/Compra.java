package es.deusto.spq.pojo;

public class Compra {
	
	private Libro libro;
	private String usuario;
	//private float precio;
	
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
	public Compra(Libro libro, String usuario/*, float precio*/) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		//this.precio = precio;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public String getUsuario() {
		return usuario;
	}
	@Override
	public String toString() {
		return "Compra [libro=" + libro + ", usuario=" + usuario + "]";
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
//	public float getPrecio() {
//		return precio;
//	}
//	public void setPrecio(float precio) {
//		this.precio = precio;
//	}

	
}
