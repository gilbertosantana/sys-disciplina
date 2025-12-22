package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;

public class TagRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public TagRequestDTO() {
	}
	
	public TagRequestDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
