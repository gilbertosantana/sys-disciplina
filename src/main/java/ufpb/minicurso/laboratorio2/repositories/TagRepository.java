package ufpb.minicurso.laboratorio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ufpb.minicurso.laboratorio2.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

	Tag findByNome(String nome);
}
