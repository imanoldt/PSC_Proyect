package es.deusto.spq.server.jdo;

import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.pojo.LibroDTO;
import es.deusto.spq.pojo.Usuario;

@PersistenceCapable(detachable="true")
public class Alquiler {

	@PrimaryKey
	@ForeignKey
	private Libro libro;
	@PrimaryKey
	@ForeignKey
	private String usuario; 
	@Persistent(defaultFetchGroup = "true")
	private Date fecha_compra;
	
	
	
	/**
	 * constructor vacio
	 */
	public Alquiler() {
		
	}
	
	public Alquiler(Libro libro, String usuario, Date fecha_compra) {
		super();
		this.libro = libro;
//		this.usuario = usuario;
		this.fecha_compra = fecha_compra;
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
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
}
