package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ufpb.minicurso.laboratorio2.entities.Comentario;
import ufpb.minicurso.laboratorio2.entities.Disciplina;

public class ComentarioResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private List<Comentario> comentarios = new ArrayList<>();	
	
	public ComentarioResponseDTO() {
	}
	
	public ComentarioResponseDTO(Disciplina disciplina) {
		id = disciplina.getId();
		nome = disciplina.getNome();
		comentarios = disciplina.getComentarios();
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}
}
