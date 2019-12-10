package com.Cyntia.Casos.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
	
	@Entity
	public class Login implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long codigo;
		
		
		private Boolean adm;
		
		@NotEmpty
		private String email;
		@NotEmpty
		private String senha;
		public long getCodigo() {
			return codigo;
		}
		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public Boolean getAdm() {
			return adm;
		}
		public void setAdm(Boolean adm) {
			this.adm = adm;
		}
		

}
