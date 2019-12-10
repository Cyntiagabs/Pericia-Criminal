package com.Cyntia.Casos.repository;

import org.springframework.data.repository.CrudRepository;

import com.Cyntia.Casos.models.Login;

public interface LoginRepository extends CrudRepository<Login, String> {
	Login findByCodigo(long codigo);
}
