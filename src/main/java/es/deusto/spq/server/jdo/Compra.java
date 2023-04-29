package es.deusto.spq.server.jdo;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.pojo.LibroDTO;


@PersistenceCapable
public class Compra {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long id;
	@Persistent(defaultFetchGroup = "true")
	private Libro libro;
	private String usuario;
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
	public Compra(Libro libro, String usuario, float precio) {
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}
