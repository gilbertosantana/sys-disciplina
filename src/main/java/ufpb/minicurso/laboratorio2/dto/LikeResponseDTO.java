package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;

import ufpb.minicurso.laboratorio2.entities.Disciplina;

public class LikeResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Integer likes;
	
	public LikeResponseDTO() {
	}
	
	public LikeResponseDTO(Disciplina disciplina) {
		id = disciplina.getId();
		nome = disciplina.getNome();
		likes = disciplina.getLikes();
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

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
}
