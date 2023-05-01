package es.deusto.spq.server.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Libro {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long id;
	String nombre;
	String descripccion;
	float precio;
	String tipo;
	
	public Libro() {

	}
	public Libro(String nombre, String descripccion, float precio,String tipo) {
		super();
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.precio = precio;
		this.tipo=tipo;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", descripccion=" + descripccion + ", precio=" + precio
				+ ", tipo=" + tipo + "]";
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
