package br.com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="codigo")
@Table(name = "aluno")
public class Aluno extends Usuario{

	private static final long serialVersionUID = 1L;
	
	@Column
	private Double peso;
	@Column
	private Double altura;
	@ManyToOne
	@JoinColumn(nullable = true)
	private Professor professor;
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
}
