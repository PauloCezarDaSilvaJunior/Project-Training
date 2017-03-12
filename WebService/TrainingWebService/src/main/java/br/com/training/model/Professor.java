package br.com.training.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="codigo")
@Table(name = "professor")
public class Professor extends Usuario{

	private static final long serialVersionUID = 1L;

	private String confef;

	public String getConfef() {
		return confef;
	}

	public void setConfef(String confef) {
		this.confef = confef;
	}
	
	
}
