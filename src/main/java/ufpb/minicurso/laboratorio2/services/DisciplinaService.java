package ufpb.minicurso.laboratorio2.services;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import ufpb.minicurso.laboratorio2.dto.ComentarioRequestDTO;
import ufpb.minicurso.laboratorio2.dto.ComentarioResponseDTO;
import ufpb.minicurso.laboratorio2.dto.DisciplinaDTO;
import ufpb.minicurso.laboratorio2.dto.LikeResponseDTO;
import ufpb.minicurso.laboratorio2.dto.NotaRequestDTO;
import ufpb.minicurso.laboratorio2.dto.NotaResponseDTO;
import ufpb.minicurso.laboratorio2.dto.TagRequestDTO;
import ufpb.minicurso.laboratorio2.dto.TagResponseDTO;
import ufpb.minicurso.laboratorio2.entities.Comentario;
import ufpb.minicurso.laboratorio2.entities.Disciplina;
import ufpb.minicurso.laboratorio2.entities.Tag;
import ufpb.minicurso.laboratorio2.repositories.ComentarioRepository;
import ufpb.minicurso.laboratorio2.repositories.DisciplinaRepository;
import ufpb.minicurso.laboratorio2.repositories.TagRepository;
import ufpb.minicurso.laboratorio2.services.exceptions.ResourceNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@PostConstruct
	public void initAlunos() {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinasSI.json");
		TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {};
		try {
			List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
			
			this.disciplinaRepository.saveAll(disciplinas);
			System.out.println("Disciplinas Salvas no BD!");
		}
		catch(IOException e) {
			System.out.println("Não foi possível salvar os alunos: " + e.getMessage());
		}
		
	}
	
	public List<DisciplinaDTO> findAll() {
		List<Disciplina> disciplinas = disciplinaRepository.findAll();
		List<DisciplinaDTO> disciplinasDTO = disciplinas.stream().map(x -> new DisciplinaDTO(x)).collect(Collectors.toList());
		return  disciplinasDTO;
	}

	public Disciplina findById(Long id) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		return disciplina.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public LikeResponseDTO addLike(Long id) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		if(!disciplina.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		disciplina.get().addLike();
		disciplinaRepository.save(disciplina.get());
		
		LikeResponseDTO likeResponse = new LikeResponseDTO(disciplina.get());
		
		return likeResponse;
	}
	
	public NotaResponseDTO addNota(Long id, NotaRequestDTO nota) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		if(!disciplina.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		disciplina.get().getNotas().add(nota.getNota());
		disciplinaRepository.save(disciplina.get());
		
		NotaResponseDTO disciplinaDTO = new NotaResponseDTO(disciplina.get());
		
		return disciplinaDTO;
	}
	
	public ComentarioResponseDTO addComentario(Long id, ComentarioRequestDTO comentario) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		if(!disciplina.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		Comentario c = new Comentario(null, LocalDateTime.now(), comentario.getComentario(), false, disciplina.get());
		comentarioRepository.save(c);
		
		ComentarioResponseDTO disciplinaDTO = new ComentarioResponseDTO(disciplina.get());
		return disciplinaDTO;
	}
	
	public ComentarioResponseDTO findByIdDisciplinas(Long id, String filtro) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		if(!disciplina.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		ComentarioResponseDTO disciplinaDTO;
		
		if(filtro == null) {
			disciplinaDTO = new ComentarioResponseDTO(disciplina.get());
			return disciplinaDTO;
		}
		List<Comentario> comentarios =  disciplina.get().getComentarios().stream().filter(x -> x.getTexto().contains(filtro)).collect(Collectors.toList());
		disciplina.get().getComentarios().clear();
		disciplina.get().getComentarios().addAll(comentarios);
		disciplinaDTO = new ComentarioResponseDTO(disciplina.get());
		return disciplinaDTO;
	}

	public TagResponseDTO addTag(Long id, TagRequestDTO tagDTO) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		if(!disciplina.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		Tag tag = tagRepository.findByNome(tagDTO.getNome());
		if(tag == null) {
			tag = new Tag();
			tag.setNome(tagDTO.getNome());
			tagRepository.save(tag);
		}
		disciplina.get().getTags().add(tag);
		disciplinaRepository.save(disciplina.get());
		
		return new TagResponseDTO(disciplina.get());
	}

	public List<NotaResponseDTO> findAllOrderByNotas() {
		List<Disciplina> list = disciplinaRepository.findAll();
		List<NotaResponseDTO> listDTO = list.stream().map(x -> new NotaResponseDTO(x)).collect(Collectors.toList());
		return listDTO.stream().sorted(Comparator.comparingDouble(NotaResponseDTO::getMedia).reversed()).collect(Collectors.toList());	
	}
	
	public List<LikeResponseDTO> findAllOrderByLikes() {
		List<Disciplina> list = disciplinaRepository.findAll();
		List<LikeResponseDTO> listDTO = list.stream().map(x -> new LikeResponseDTO(x)).collect(Collectors.toList());
		return listDTO.stream().sorted(Comparator.comparingInt(LikeResponseDTO::getLikes).reversed()).collect(Collectors.toList());	
	}

	public List<Tag> findByTagId(Long id) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		List<Tag> tags = disciplina.get().getTags().stream().map(x -> new Tag(x.getId(), x.getNome())).collect(Collectors.toList());
		return tags;
	}

	public List<DisciplinaDTO> findByDisciplinaAssociadaPorTag(String str) {
		Tag tag = tagRepository.findByNome(str);
		List<Disciplina> disciplina = disciplinaRepository.findAll();
		List<DisciplinaDTO> disciplinaDTO = new ArrayList<>();
		
		for (Disciplina d : disciplina) {
			if(d.getTags().contains(tag)) {
				disciplinaDTO.add(new DisciplinaDTO(d));
			}
		}
		return disciplinaDTO;
	}
}
