package br.com.efit.dao;

import java.util.List;

import br.com.efit.domain.Exercicio;

public interface ExercicioDao {
	
	void salvar(Exercicio exercicio);
	
	void editar(Exercicio exercicio);
	
	void excluir(Long id);
	
	Exercicio getId(Long id);
	
	List<Exercicio> getTodos();
}
