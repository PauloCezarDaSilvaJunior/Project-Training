package br.com.training.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.ExercicioDAO;
import br.com.training.model.Exercicio;

@Path("exercicio")
public class ExercicioService {
	@GET
	public Response listar(){
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		List<Exercicio> exercicios = exercicioDAO.listar();

		Gson gson = new Gson();
		String json = gson.toJson(exercicios);

		return Response.ok().entity(json).type("aplication/json").build();
	}
	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		Exercicio exercicio = gson.fromJson(json, Exercicio.class);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		exercicio = exercicioDAO.findById(exercicio.getCodigo());
		exercicioDAO.delete(exercicio);
		
		return Response.ok().entity(gson.toJson(exercicio)).type("aplication/json").build();
	}
	
	@POST
	public Response salvar(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Exercicio exercicio = gson.fromJson(json, Exercicio.class);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		exercicioDAO.merge(exercicio);
		
		return Response.ok().entity(json).type("aplication/json").build();		
	}
	
	@PUT
	public Response update(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Exercicio exercicio = gson.fromJson(json, Exercicio.class);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		exercicioDAO.update(exercicio);
		
		return Response.ok().entity(json).type("aplication/json").build();		
	}
}
