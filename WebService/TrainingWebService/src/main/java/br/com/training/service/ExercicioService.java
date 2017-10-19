package br.com.training.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.ExercicioDAO;
import br.com.training.model.Exercicio;
import br.com.training.model.Professor;

@Path("exercicio")
public class ExercicioService {
	@GET
	@Path("{codigo}")
	public Response listar(@PathParam("codigo") Long codPorfessor){
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		List<Exercicio> exercicios = exercicioDAO.listar(codPorfessor);

		Gson gson = new Gson();
		String json = gson.toJson(exercicios);

		return Response.ok().entity(json).type("application/json").build();
	}
	@GET
	@Path("find/{codigo}")
	public Response findById(@PathParam("codigo") Long codigo){
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		Exercicio exercicios = exercicioDAO.findById(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(exercicios);

		return Response.ok().entity(json).type("application/json").build();
	}
	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		Exercicio exercicio = gson.fromJson(json, Exercicio.class);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		exercicio = exercicioDAO.findById(exercicio.getCodigo());
		exercicioDAO.delete(exercicio);
		
		return Response.ok().entity(gson.toJson(exercicio)).type("application/json").build();
	}
	
	@POST
	@Path("{codigo}")
	public Response salvar(String json, @PathParam("codigo") Long codPorfessor){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Exercicio exercicio = gson.fromJson(json, Exercicio.class);
		Professor professor = new Professor();
		professor.setCodigo(codPorfessor);
		exercicio.setProfessor(professor);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		exercicioDAO.merge(exercicio);
		
		return Response.ok().entity(json).type("application/json").build();		
	}
	
	@PUT
	public Response update(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Exercicio exercicio = gson.fromJson(json, Exercicio.class);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		exercicioDAO.update(exercicio);
		
		return Response.ok().entity(json).type("application/json").build();		
	}
}
