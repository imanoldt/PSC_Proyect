package es.deusto.spq.server.jdo;

import java.awt.RenderingHints.Key;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.identity.*;


@PersistenceCapable
public class CompraJdo {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long id;



	@Persistent
	private long bookKey;

	@NotPersistent
	private Libro libro;

	private String usuario;
	//private float precio;
	
	/**
	 * constructor vacio
	 */
	public CompraJdo() {
		
	}
	
	/**
	 * constructor con los siguientes parametros
	 * @param libro
	 * @param usuario
	 * @param precio
	 */
	public CompraJdo(Libro libro, String usuario/*, float precio*/) {
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
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
//	public float getPrecio() {
//		return precio;
//	}
//	public void setPrecio(float precio) {
//		this.precio = precio;
//	}
	public void setBookKey(long bookKey) {
		this.bookKey = bookKey;
	}

	public long getBookKey() {
		return bookKey;
	}
	
}
