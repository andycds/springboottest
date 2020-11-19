package br.unip.springboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unip.springboottest.model.Aluno;
import br.unip.springboottest.repository.AlunoRepository;

@Controller
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepo;

//	@Autowired
//	public AlunoController(AlunoRepository alunoRepo) {
//		this.alunoRepo = alunoRepo;
//	}

//	@Autowired
//	public void setAlunoRepo(AlunoRepository alunoRepo) {
//		this.alunoRepo = alunoRepo;
//	}

	@GetMapping("/alunos")
	public ModelAndView listarAlunos() {
		ModelAndView mv = new ModelAndView("lista_alunos");
		List<Aluno> alunos = alunoRepo.findAll();
		mv.addObject("alunos", alunos);
		mv.addObject(new Aluno());
		return mv;
	}

	@PostMapping("/alunos")
	public String salvar(Aluno aluno) {
		alunoRepo.save(aluno);
		return "redirect:/alunos";
	}
}
