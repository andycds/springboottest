package br.unip.springboottest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.springboottest.model.Aluno;
import br.unip.springboottest.model.Calculadora;
import br.unip.springboottest.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepo;

	@Autowired
	private Calculadora calculadora;

	public void salvar(Aluno aluno) {
		alunoRepo.save(aluno);
	}

	public List<Aluno> listarTodos() {
		List<Aluno> alunos = alunoRepo.findAll();
		for (Aluno aluno : alunos) {
			aluno.setMediaFinal(calculadora.calculaMedia(aluno.getNota1(), aluno.getNota2()));
		}
		return alunos;
	}
}