package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import ufpb.minicurso.laboratorio2.entities.Disciplina;
import ufpb.minicurso.laboratorio2.entities.Tag;

public class TagResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Set<Tag> tags = new HashSet<>();
	
	public TagResponseDTO(Disciplina disciplina) {
		id = disciplina.getId();
		nome = disciplina.getNome();
		tags = disciplina.getTags();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Tag> getTags() {
		return tags;
	}	
}
