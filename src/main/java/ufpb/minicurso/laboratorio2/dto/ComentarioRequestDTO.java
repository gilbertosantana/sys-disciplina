package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import ufpb.minicurso.laboratorio2.entities.Comentario;

public class ComentarioRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String comentario;
	
	public ComentarioRequestDTO() {
	}

	public ComentarioRequestDTO(Comentario comentario) {
		BeanUtils.copyProperties(comentario, this);
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
