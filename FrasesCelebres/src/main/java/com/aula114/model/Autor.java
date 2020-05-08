package com.aula114.model;
import java.io.Serializable;
import java.util.Date;

public class Autor implements Serializable {
	private String nombre;
	private Date fechaNac;

	public Autor() {
		super();
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
