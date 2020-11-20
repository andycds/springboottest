package br.unip.springboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unip.springboottest.model.Aluno;
import br.unip.springboottest.service.AlunoService;

@Controller
public class AlunoController {
//	@Autowired
//	private AlunoRepository alunoRepo;

//	@Autowired
//	public AlunoController(AlunoRepository alunoRepo) {
//		this.alunoRepo = alunoRepo;
//	}

//	@Autowired
//	public void setAlunoRepo(AlunoRepository alunoRepo) {
//		this.alunoRepo = alunoRepo;
//	}

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/alunos")
	public ModelAndView listarAlunos() {
		ModelAndView mv = new ModelAndView("lista_alunos");
		List<Aluno> alunos = alunoService.listarTodos();
		mv.addObject("alunos", alunos);
		mv.addObject(new Aluno());
		return mv;
	}

	@PostMapping("/alunos")
	public String salvar(Aluno aluno) {
		alunoService.salvar(aluno);
		return "redirect:/alunos";
	}
}
