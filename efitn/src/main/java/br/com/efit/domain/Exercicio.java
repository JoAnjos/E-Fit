package br.com.efit.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "exercicio")
public class Exercicio{



	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_exer;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 70)
	private String nome_exer;
	
	@NotBlank
	@Size(min = 1, max = 10, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 10)
	private String qtdExercicio;
	
	@NotBlank
	@Size(min = 1, max = 10, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 10)
	private String numSeries;
	
	@NotBlank
	@Size(min = 1, max = 10, message = "Campo requirido entre {min} e {max} caracteres.")
	@Column(nullable = false, length = 10)
	private String tempDescanso;
	
	
	
	public Exercicio() {
		
	}


	public Exercicio(Long id_exer, String nome_exer, String qtdExercicio, String numSeries, String tempDescanso) {
		super();
		this.id_exer = id_exer;
		this.nome_exer = nome_exer;
		this.qtdExercicio = qtdExercicio;
		this.numSeries = numSeries;
		this.tempDescanso = tempDescanso;
	}
	
	public Long getId_exer() {
		return id_exer;
	}



	public void setId_exer(Long id_exer) {
		this.id_exer = id_exer;
	}



	public String getNome_exer() {
		return nome_exer;
	}



	public void setNome_exer(String nome_exer) {
		this.nome_exer = nome_exer;
	}



	public String getQtdExercicio() {
		return qtdExercicio;
	}



	public void setQtdExercicio(String qtdExercicio) {
		this.qtdExercicio = qtdExercicio;
	}



	public String getNumSeries() {
		return numSeries;
	}



	public void setNumSeries(String numSeries) {
		this.numSeries = numSeries;
	}



	public String getTempDescanso() {
		return tempDescanso;
	}



	public void setTempDescanso(String tempDescanso) {
		this.tempDescanso = tempDescanso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_exer == null) ? 0 : id_exer.hashCode());
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
		Exercicio other = (Exercicio) obj;
		if (id_exer == null) {
			if (other.id_exer!= null)
				return false;
		} else if (!id_exer.equals(other.id_exer))
			return false;
		return true;
	}


}
