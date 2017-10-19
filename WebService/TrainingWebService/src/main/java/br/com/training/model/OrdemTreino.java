package br.com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordemTreinamento")
public class OrdemTreino extends GenericDomain{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 400)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Treinamento treinamento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Exercicio exercicio;
	
	@Column(length = 400)
	private String serie;
	
	@Column(length = 400)
	private String repeticao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(String repeticao) {
		this.repeticao = repeticao;
	}
}
