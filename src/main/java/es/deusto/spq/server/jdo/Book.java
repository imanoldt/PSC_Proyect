package es.deusto.spq.server.jdo;

import java.awt.RenderingHints.Key;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.pojo.Categoria;
import es.deusto.spq.pojo.Seccion;

@PersistenceCapable
public class Book {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long id;
	String nombre=null;
	String descripccion=null;
	float precio=0;
	String tipo;

	/**
	 * constructor vacio
	 */

	public Book() {

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
	public Book(String nombre, String descripccion, float precio,String tipo) {
		super();
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.precio = precio;
		this.tipo=tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    


}
