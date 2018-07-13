package br.com.efit.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Juncao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_junc;
	
	@OneToMany
	@JoinColumn(name="id_exer")
	private Exercicio exercicio;
	@OneToMany
	@JoinColumn(name="id_user")
	private Usuario usuario;
	
	
	public Long getId_junc() {
		return id_junc;
	}
	public void setId_junc(Long id_junc) {
		this.id_junc = id_junc;
	}
	public Exercicio getExercicio() {
		return exercicio;
	}
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
	
}
