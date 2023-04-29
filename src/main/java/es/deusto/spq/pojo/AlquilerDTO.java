package es.deusto.spq.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class AlquilerDTO {
	
	LibroDTO libro;
	private String usuario;
	private Date fecha_compra;
	
	
	
	/**
	 * constructor vacio
	 */
	public AlquilerDTO() {
		
	}
	
	/**
	 * constructor con parametros
	 * @param libro
	 * @param usuario
	 * @param fecha
	 */
	public AlquilerDTO(LibroDTO libro, String usuario, Date fecha) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fecha_compra = fecha;
	}
	
	public LibroDTO getLibro() {
		return libro;
	}
	public void setLibro(LibroDTO libro) {
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
