package ufpb.minicurso.laboratorio2.dto;

import java.io.Serializable;

public class NotaRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double nota;

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
}
