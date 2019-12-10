package com.Cyntia.Casos.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.Cyntia.Casos.models.Usuario;
import com.Cyntia.Casos.repository.UsuarioRepository;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = ur.findByNomeUsuario(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}

		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
}