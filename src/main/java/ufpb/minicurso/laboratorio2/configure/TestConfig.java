package ufpb.minicurso.laboratorio2.configure;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ufpb.minicurso.laboratorio2.entities.Comentario;
import ufpb.minicurso.laboratorio2.entities.Disciplina;
import ufpb.minicurso.laboratorio2.repositories.ComentarioRepository;
import ufpb.minicurso.laboratorio2.repositories.DisciplinaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public void run(String... args) throws Exception {
		Disciplina d1  = disciplinaRepository.findById(1L).get();
		Disciplina d2  = disciplinaRepository.findById(2L).get();
		Disciplina d3  = disciplinaRepository.findById(3L).get();
		Disciplina d4  = disciplinaRepository.findById(4L).get();
		Disciplina d5  = disciplinaRepository.findById(5L).get();
		Disciplina d6  = disciplinaRepository.findById(6L).get();
		Disciplina d7  = disciplinaRepository.findById(7L).get();
		Disciplina d8  = disciplinaRepository.findById(8L).get();
		Disciplina d9  = disciplinaRepository.findById(9L).get();
		Disciplina d10 = disciplinaRepository.findById(10L).get();
		Disciplina d11 = disciplinaRepository.findById(11L).get();
		Disciplina d12 = disciplinaRepository.findById(12L).get();
		Disciplina d13 = disciplinaRepository.findById(13L).get();
		Disciplina d14 = disciplinaRepository.findById(14L).get();
		Disciplina d15 = disciplinaRepository.findById(15L).get();
		Disciplina d16 = disciplinaRepository.findById(16L).get();
		Disciplina d17 = disciplinaRepository.findById(17L).get();
		Disciplina d18 = disciplinaRepository.findById(18L).get();
		Disciplina d19 = disciplinaRepository.findById(19L).get();
		Disciplina d20 = disciplinaRepository.findById(20L).get();
		Disciplina d21 = disciplinaRepository.findById(21L).get();
		Disciplina d22 = disciplinaRepository.findById(22L).get();
		Disciplina d23 = disciplinaRepository.findById(23L).get();
		Disciplina d24 = disciplinaRepository.findById(24L).get();
		Disciplina d25 = disciplinaRepository.findById(25L).get();
		
		Comentario c1  = new Comentario(null, LocalDateTime.now(), "Disciplina horrível e professor pior ainda!!!", false, d1);
		Comentario c2  = new Comentario(null, LocalDateTime.now(), "Conteúdo muito confuso e mal explicado.", false, d2);
		Comentario c3  = new Comentario(null, LocalDateTime.now(), "Disciplina difícil, mas o professor tenta ajudar.", false, d3);
		Comentario c4  = new Comentario(null, LocalDateTime.now(), "Aulas longas e cansativas, pouco aprendizado.", false, d4);
		Comentario c5  = new Comentario(null, LocalDateTime.now(), "Boa disciplina, mas avaliação muito pesada.", false, d5);
		Comentario c6  = new Comentario(null, LocalDateTime.now(), "Professor explica bem, porém passa muitos trabalhos.", false, d6);
		Comentario c7  = new Comentario(null, LocalDateTime.now(), "Conteúdo interessante, aulas poderiam ser mais dinâmicas.", false, d7);
		Comentario c8  = new Comentario(null, LocalDateTime.now(), "Disciplina desorganizada e sem cronograma definido.", false, d8);
		Comentario c9  = new Comentario(null, LocalDateTime.now(), "Aprendi bastante, apesar da dificuldade.", false, d9);
		Comentario c10 = new Comentario(null, LocalDateTime.now(), "Professor muito rígido e pouco acessível.", false, d10);
		Comentario c11 = new Comentario(null, LocalDateTime.now(), "Boa didática, mas matéria muito extensa.", false, d11);
		Comentario c12 = new Comentario(null, LocalDateTime.now(), "Disciplina fundamental para o curso.", false, d12);
		Comentario c13 = new Comentario(null, LocalDateTime.now(), "Pouca aplicação prática do conteúdo.", false, d13);
		Comentario c14 = new Comentario(null, LocalDateTime.now(), "Aulas claras e bem estruturadas.", false, d14);
		Comentario c15 = new Comentario(null, LocalDateTime.now(), "Professor domina o assunto, porém explica rápido demais.", false, d15);
		Comentario c16 = new Comentario(null, LocalDateTime.now(), "Disciplina repetitiva e pouco motivadora.", false, d16);
		Comentario c17 = new Comentario(null, LocalDateTime.now(), "Bom equilíbrio entre teoria e prática.", false, d17);
		Comentario c18 = new Comentario(null, LocalDateTime.now(), "Avaliações justas e conteúdo relevante.", false, d18);
		Comentario c19 = new Comentario(null, LocalDateTime.now(), "Professor não demonstra interesse em ensinar.", false, d19);
		Comentario c20 = new Comentario(null, LocalDateTime.now(), "Disciplina complicada, exige muito estudo fora da sala.", false, d20);
		Comentario c21 = new Comentario(null, LocalDateTime.now(), "Conteúdo desatualizado em relação ao mercado.", false, d21);
		Comentario c22 = new Comentario(null, LocalDateTime.now(), "Disciplina interessante, mas mal organizada.", false, d22);
		Comentario c23 = new Comentario(null, LocalDateTime.now(), "Professor acessível e disposto a tirar dúvidas.", false, d23);
		Comentario c24 = new Comentario(null, LocalDateTime.now(), "Aulas teóricas demais e pouca prática.", false, d24);
		Comentario c25 = new Comentario(null, LocalDateTime.now(), "Uma das melhores disciplinas do curso.", false, d25);
		
		comentarioRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25));
		
		Random r = new Random();
		for(int i = 0; i < r.nextInt(30); i++) {
			d1.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d3.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d5.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d10.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d13.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d15.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d20.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d23.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d25.addLike();
		}
		for(int i = 0; i < r.nextInt(30); i++) {
			d7.addLike();
		}
		disciplinaRepository.saveAll(Arrays.asList(d1, d3, d5, d10, d13, d15, d20, d23, d25, d7));
		
		d1.addNota(10.0);
		d1.addNota(7.0);
		d5.addNota(10.0);
		d5.addNota(1.0);
		d10.addNota(10.0);
		d10.addNota(13.0);
		
		disciplinaRepository.saveAll(Arrays.asList(d1, d5, d10));
	}
	
	
}
