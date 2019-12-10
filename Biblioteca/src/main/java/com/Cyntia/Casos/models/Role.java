package com.Cyntia.Casos.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 3633542200799190087L;

	@Id
	private String nomeRole;

	@ManyToMany
	private List<Usuario> usuarios;

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	@Override
	public String getAuthority() {
		return nomeRole;
	}
}