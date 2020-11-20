package br.unip.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.springboottest.model.Usuario;
import br.unip.springboottest.repository.UsuarioRepository;

@Service
public class LoginService {
	@Autowired
	private UsuarioRepository usuarioRepo;

	public boolean logar(Usuario usuario) {
		return usuarioRepo.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha()) != null;
	}
}