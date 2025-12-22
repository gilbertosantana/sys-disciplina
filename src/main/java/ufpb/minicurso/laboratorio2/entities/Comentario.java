package ufpb.minicurso.laboratorio2.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataDoComentario;
	private String texto;
	private boolean removido;
	
	@ManyToOne
	private Disciplina disciplina;
	
	public Comentario() {
	}

	public Comentario(Long id, LocalDateTime dataDoComentario, String texto, boolean removido, Disciplina disciplina) {
		this.id = id;
		this.dataDoComentario = dataDoComentario;
		this.texto = texto;
		this.removido = removido;
		this.disciplina = disciplina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataDoComentario() {
		return dataDoComentario;
	}

	public void setDataDoComentario(LocalDateTime dataDoComentario) {
		this.dataDoComentario = dataDoComentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isRemovido() {
		return removido;
	}

	public void setRemovido(boolean removido) {
		this.removido = removido;
	}
	
	@JsonIgnore
	public Disciplina getDiciplina() {
		return disciplina;
	}

	public void setDiciplina(Disciplina diciplina) {
		this.disciplina = diciplina;
	}
}
