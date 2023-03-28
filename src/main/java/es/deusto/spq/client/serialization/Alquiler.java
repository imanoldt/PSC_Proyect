package es.deusto.spq.client.serialization;

import java.util.Date;

public class Alquiler {
	
	private Libro libro;
	private Usuario usuario;
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
	public Alquiler(Libro libro, Usuario usuario, Date fecha_compra) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fecha_compra = fecha_compra;
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
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	
}
