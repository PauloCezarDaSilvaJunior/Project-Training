package br.com.training.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.AlunoDAO;
import br.com.training.model.Aluno;

@Path("aluno")
public class AlunoService {
	@GET
	public String listar(){
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> alunos = alunoDAO.listar();

		Gson gson = new Gson();
		String json = gson.toJson(alunos);

		return json;
	}
	
	@GET
	@Path("{codigo}")
	public String findById(@PathParam("codigo") Long codigo){
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.findById(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(aluno);

		return json;
	}
	
	@DELETE
	public String delete(String json){
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		Aluno aluno = gson.fromJson(json, Aluno.class);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		aluno = alunoDAO.findById(aluno.getCodigo());
		alunoDAO.delete(aluno);
		
		return gson.toJson(aluno);
	}
}
