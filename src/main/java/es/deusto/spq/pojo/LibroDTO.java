package es.deusto.spq.pojo;


public class LibroDTO {


	private String nombre;
	private String descripccion;
	private float precio;
	private String tipo;
//	private Categoria categoria;
//	private Seccion seccion;

	/**
	 * constructor vacio
	 */
	public LibroDTO() {

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
	public LibroDTO(String nombre, String descripccion, float precio,String tipo) {
		super();
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.precio = precio;
		this.tipo=tipo;
//		this.categoria = categoria;
//		this.seccion = seccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
//
//	public Seccion getSeccion() {
//		return seccion;
//	}
//
//	public void setSeccion(Seccion seccion) {
//		this.seccion = seccion;
//	}
	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", descripccion=" + descripccion + ", precio=" + precio + "]";
	}
}
