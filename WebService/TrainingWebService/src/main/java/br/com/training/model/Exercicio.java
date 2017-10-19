package br.com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")
public class Exercicio extends GenericDomain{
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 400)
	private String descricao;
	
	@Column(length = 200)
	private String linkVideo;
	
	@Column(length = 400)
	private String musculo;
	
	@Column(length = 400)
	private String equipamento;
	
	@ManyToOne
	private Professor professor;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getMusculo() {
		return musculo;
	}

	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
