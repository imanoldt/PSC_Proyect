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
@Join
public class Alquiler {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long id;
	private String libro;
	private String usuario; 
	@Persistent(defaultFetchGroup = "true")
	private String fecha_compra;
	
	

	public Alquiler() {
		
	}
	
	public Alquiler(String libro, String usuario, String fecha_compra) {
		super();
		this.libro = libro;
//		this.usuario = usuario;
		this.fecha_compra = fecha_compra;
	}
	
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
}
