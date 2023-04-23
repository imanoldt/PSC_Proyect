package es.deusto.spq.server.jdo;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.pojo.Libro;
import es.deusto.spq.pojo.Usuario;

@PersistenceCapable
public class Alquiler {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long id;
	@Persistent(defaultFetchGroup = "true")
	private Book libro;
	private String usuario;
	private Date fecha_compra;
	
	
	
	/**
	 * constructor vacio
	 */
	public Alquiler() {
		
	}
	
	/**
	 * constructor con parametros
	 * @param libro
	 * @param usuario
	 * @param fecha_compra
	 */
	public Alquiler(Book libro, String usuario, Date fecha_compra) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fecha_compra = fecha_compra;
	}
	
	public Book getLibro() {
		return libro;
	}
	public void setLibro(Book libro) {
		this.libro = libro;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
}
