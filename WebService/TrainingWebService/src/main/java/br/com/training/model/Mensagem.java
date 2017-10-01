package br.com.training.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Mensagem extends GenericDomain implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(nullable = true)
	public Aluno aluno;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	public Professor professor;
	
	@Column(length=255)
	public String mensagem;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario enviadoPor;

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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public TipoUsuario getEnviadoPor() {
		return enviadoPor;
	}

	public void setEnviadoPor(TipoUsuario enviadoPor) {
		this.enviadoPor = enviadoPor;
	}
}
