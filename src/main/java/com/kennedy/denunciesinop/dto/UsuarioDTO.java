package com.kennedy.denunciesinop.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.kennedy.denunciesinop.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String cpfOuCnpj;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpfOuCnpj = obj.getCpfOuCnpj();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
