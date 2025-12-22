package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;
import java.util.List;

import ufpb.minicurso.laboratorio2.entities.Disciplina;

public class NotaResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Double media;
	
	public NotaResponseDTO() {
	}
	
	public NotaResponseDTO(Disciplina disciplina) {
		id = disciplina.getId();
		nome = disciplina.getNome();
		media = calculaMedia(disciplina.getNotas());
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

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
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
