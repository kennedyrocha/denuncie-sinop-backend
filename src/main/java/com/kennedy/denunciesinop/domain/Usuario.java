package com.kennedy.denunciesinop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kennedy.denunciesinop.domain.enums.Perfil;
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrogatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrogatório")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrogatório")
	private String cpfOuCnpj;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Emergencia> emergencias = new ArrayList<>();
	
	@JsonIgnore
	private String senha;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Denuncia> denuncias = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable (name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String email, String cpfOuCnpj, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.senha = senha;
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

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
	}

	public List<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil (Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfOuCnpj == null) ? 0 : cpfOuCnpj.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpfOuCnpj == null) {
			if (other.cpfOuCnpj != null)
				return false;
		} else if (!cpfOuCnpj.equals(other.cpfOuCnpj))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
