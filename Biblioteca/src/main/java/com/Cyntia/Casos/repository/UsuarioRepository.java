package com.Cyntia.Casos.repository;

import org.springframework.data.repository.CrudRepository;

import com.Cyntia.Casos.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
		Usuario findByNomeUsuario(String nomeUsuario);
	}


