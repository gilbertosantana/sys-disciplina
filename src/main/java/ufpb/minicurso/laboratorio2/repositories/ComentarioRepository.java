package ufpb.minicurso.laboratorio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ufpb.minicurso.laboratorio2.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
