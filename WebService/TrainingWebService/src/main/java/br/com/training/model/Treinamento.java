package br.com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "treinamento")
public class Treinamento extends GenericDomain {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor professor;
	
	@ManyToOne
	private OrdemTreino ordemTreino;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public OrdemTreino getOrdemTreino() {
		return ordemTreino;
	}

	public void setOrdemTreino(OrdemTreino ordem) {
		this.ordemTreino = ordem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
