package com.Cyntia.Casos.repository;

import org.springframework.data.repository.CrudRepository;

import com.Cyntia.Casos.models.Caso;
	
	public interface CasoRepository extends CrudRepository<Caso, String> {
		Caso findByCodigo(long codigo);
		
}
