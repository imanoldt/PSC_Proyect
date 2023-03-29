package es.deusto.spq.client.serialization;

public class Libro {
	private String nombre;
	private String descripccion;
	private float precio;
	private Categoria categoria;
	private Seccion seccion;

	/**
	 * constructor vacio
	 */
	public Libro() {

	}

	/**
	 * constructor con parametros
	 * 
	 * @param nombre
	 * @param descripccion
	 * @param precio
	 * @param categoria
	 * @param seccion
	 */
	public Libro(String nombre, String descripccion, float precio, Categoria categoria, Seccion seccion) {
		super();
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.precio = precio;
		this.categoria = categoria;
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripccion() {
		return descripccion;
	}

	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

}
