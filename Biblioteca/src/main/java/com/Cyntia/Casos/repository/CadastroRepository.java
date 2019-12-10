package com.Cyntia.Casos.repository;

import org.springframework.data.repository.CrudRepository;

import com.Cyntia.Casos.models.Cadastro;

	public interface CadastroRepository extends CrudRepository<Cadastro, String> {
		Cadastro findByCodigo(long codigo);

}
