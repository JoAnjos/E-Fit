package br.com.efit.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario{


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@NotBlank
	@Size(min = 8, max = 50, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 50)
	private String senha;
	
	@NotBlank
	@Size(min = 8, max = 50, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 50)
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 10, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 10)
	private String cep;
	
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 50)
	private String cidade;
	
	@NotBlank
	@Size(min = 2, max = 50, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 50)
	private String estado;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id_user, String nome, String senha, String email, String cep, String cidade, String estado) {
		super();
		this.id_user = id_user;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
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
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		return true;
	}	

}
