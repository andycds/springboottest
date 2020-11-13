package br.unip.springboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unip.springboottest.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
