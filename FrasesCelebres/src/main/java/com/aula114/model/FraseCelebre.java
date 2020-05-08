package com.aula114.model;
import java.io.Serializable;
import com.aula114.model.Autor;

public class FraseCelebre implements Serializable {
	private String frase;
	private Autor autor;

	public FraseCelebre() {
		super();
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
