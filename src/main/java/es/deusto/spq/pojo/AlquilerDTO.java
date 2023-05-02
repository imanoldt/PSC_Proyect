package es.deusto.spq.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class AlquilerDTO {
	
	private String libro;
	private String usuario;
	private String fecha_compra;
	
	
	
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
	public AlquilerDTO(String libro, String usuario, String fecha) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fecha_compra = fecha;
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
