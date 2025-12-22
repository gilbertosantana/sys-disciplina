package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ufpb.minicurso.laboratorio2.entities.Comentario;
import ufpb.minicurso.laboratorio2.entities.Disciplina;

public class DisciplinaResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Double nota;
	private Integer likes;
	
	private List<Comentario> comentarios = new ArrayList<>();
	
	public DisciplinaResponseDTO() {
	}
	
	public DisciplinaResponseDTO(Disciplina disciplina) {
		id = disciplina.getId();
		nome = disciplina.getNome();
		nota = calculaMedia(disciplina.getNotas());
		likes = disciplina.getLikes();
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNotaMedia() {
		return nota;
	}

	public void setNotaMedia(Double notaMedia) {
		this.nota = notaMedia;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	private Double calculaMedia(List<Double> notas) {
		double somaNotas = 0;
		for (Double n: notas) {
			somaNotas += n;
		}
		if (somaNotas != 0) {
			return somaNotas / notas.size();
		}
		return somaNotas;
	}
}
