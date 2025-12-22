package ufpb.minicurso.laboratorio2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.minicurso.laboratorio2.dto.ComentarioRequestDTO;
import ufpb.minicurso.laboratorio2.dto.ComentarioResponseDTO;
import ufpb.minicurso.laboratorio2.dto.DisciplinaDTO;
import ufpb.minicurso.laboratorio2.dto.DisciplinaResponseDTO;
import ufpb.minicurso.laboratorio2.dto.LikeResponseDTO;
import ufpb.minicurso.laboratorio2.dto.NotaRequestDTO;
import ufpb.minicurso.laboratorio2.dto.NotaResponseDTO;
import ufpb.minicurso.laboratorio2.dto.TagRequestDTO;
import ufpb.minicurso.laboratorio2.dto.TagResponseDTO;
import ufpb.minicurso.laboratorio2.entities.Disciplina;
import ufpb.minicurso.laboratorio2.services.DisciplinaService;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> findAll() {
		List<DisciplinaDTO> disciplinas = disciplinaService.findAll();
		return ResponseEntity.ok().body(disciplinas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DisciplinaResponseDTO> findById(@PathVariable Long id) {
		Disciplina disciplina = disciplinaService.findById(id);
		DisciplinaResponseDTO disciplinaDTO = new DisciplinaResponseDTO(disciplina);
		
		return ResponseEntity.ok().body(disciplinaDTO);
	}
	@PatchMapping("/likes/{id}")
	public ResponseEntity<LikeResponseDTO> addLike(@PathVariable Long id) {
		LikeResponseDTO disciplinaDTO = disciplinaService.addLike(id);
		return ResponseEntity.ok().body(disciplinaDTO);
	}
	
	@PatchMapping("/nota/{id}")
	public ResponseEntity<NotaResponseDTO> addNota(@PathVariable Long id, @RequestBody NotaRequestDTO nota) {
		NotaResponseDTO disciplina =  disciplinaService.addNota(id, nota);
		return ResponseEntity.ok().body(disciplina);
	}
	
	@PostMapping("/{id}/comentarios")
	public ResponseEntity<ComentarioResponseDTO> addComentario(@PathVariable Long id, @RequestBody ComentarioRequestDTO comentario) {
		ComentarioResponseDTO disciplina = disciplinaService.addComentario(id, comentario);
		
		return ResponseEntity.ok().body(disciplina);
	}
	
	@GetMapping("/{id}/comentarios")
	public ResponseEntity<ComentarioResponseDTO> findByIdDisciplinas(@PathVariable Long id, @RequestParam(required = false) String filtro) {
		ComentarioResponseDTO disciplinaDTO = disciplinaService.findByIdDisciplinas(id, filtro);
		
		return ResponseEntity.ok().body(disciplinaDTO);
		
	}
	
	@PostMapping("/{id}/tags")
	public ResponseEntity<TagResponseDTO> addTag(@PathVariable Long id, @RequestBody TagRequestDTO tag) {
		TagResponseDTO disciplinaTag = disciplinaService.addTag(id, tag);
		return ResponseEntity.ok().body(disciplinaTag);
	}
	
	@GetMapping("/ranking/notas")
	public ResponseEntity<List<NotaResponseDTO>> findAllOrderByNotas() {
		List<NotaResponseDTO> list = disciplinaService.findAllOrderByNotas();
		
		return ResponseEntity.ok().body(list);
	}
}
