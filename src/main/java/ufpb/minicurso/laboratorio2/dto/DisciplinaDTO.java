package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import ufpb.minicurso.laboratorio2.entities.Disciplina;

public class DisciplinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public DisciplinaDTO() {
	}
	
	public DisciplinaDTO(Disciplina disciplina) {
		BeanUtils.copyProperties(disciplina, this);
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
}
