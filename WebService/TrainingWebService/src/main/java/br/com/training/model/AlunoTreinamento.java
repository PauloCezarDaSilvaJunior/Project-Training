package br.com.training.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunoTreinamento")
public class AlunoTreinamento extends GenericDomain{

	private static final long serialVersionUID = 1L;
	
	public AlunoTreinamento(){
		
	}
	public AlunoTreinamento(Aluno aluno, Treinamento treinamento){
		this.aluno = aluno;
		this.treinamento = treinamento;
	}

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Treinamento treinamento;
	
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}
	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}
}
