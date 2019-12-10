package com.Cyntia.Casos.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Caso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	
	@NotEmpty
	private String nomevitima;
	@NotEmpty
	private String sexo;
	@NotEmpty
	private String possivelmorte;
	@NotEmpty
	private String dataocorrencia;
	@NotEmpty
	private String relatoriofinal;
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRelatoriofinal() {
		return relatoriofinal;
	}
	public void setRelatoriofinal(String relatoriofinal) {
		this.relatoriofinal = relatoriofinal;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNomevitima() {
		return nomevitima;
	}
	public void setNomevitima(String nomevitima) {
		this.nomevitima = nomevitima;
	}
	public String getPossivelmorte() {
		return possivelmorte;
	}
	public void setPossivelmorte(String possivelmorte) {
		this.possivelmorte = possivelmorte;
	}
	public String getDataocorrencia() {
		return dataocorrencia;
	}
	public void setDataocorrencia(String dataocorrencia) {
		this.dataocorrencia = dataocorrencia;
	}
	
	
}