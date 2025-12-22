package ufpb.minicurso.laboratorio2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import ufpb.minicurso.laboratorio2.dto.NotaRequestDTO;

@Entity
public class Disciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer likes = 0;
	
	private List<Double> notas = new ArrayList<>();
	
	@OneToMany(mappedBy = "disciplina")
	private List<Comentario> comentarios = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
		name = "disciplina_tag",
		joinColumns = @JoinColumn(name = "disciplina_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();
	
	public Disciplina() {
	}

	public Disciplina(Long id, String nome, Integer likes) {
		this.id = id;
		this.nome = nome;
		this.likes = likes;
	}
	
	public Disciplina(NotaRequestDTO nota) {
		notas.add(nota.getNota());
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

	public int getLikes() {
		return likes;
	}

	public List<Double> getNotas() {
		return notas;
	}
	
	public void addNota(Double nota) {
		notas.add(nota);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public Set<Tag> getTags() {
		return tags;
	}
	
	public void addLike() {
		likes +=1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(nome, other.nome);
	}	
}
