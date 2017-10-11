package br.com.training.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.OrdemTreinoDAO;
import br.com.training.model.OrdemTreino;

public class OrdemTreinoService {
	@GET
	public Response listar(){
		OrdemTreinoDAO oredemTreinoDAO = new OrdemTreinoDAO();
		List<OrdemTreino> ordemTreinos = oredemTreinoDAO.listar();

		Gson gson = new Gson();
		String json = gson.toJson(ordemTreinos);

		return Response.ok().entity(json).type("application/json").build();
	}
	
	@GET
	@Path("{codigo}")
	public Response findById(@PathParam("codigo") Long codigo){
		OrdemTreinoDAO oredemTreinoDAO = new OrdemTreinoDAO();
		OrdemTreino ordemTreino = oredemTreinoDAO.findById(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(ordemTreino);

		return Response.ok().entity(json).type("application/json").build();
	}
	
	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		OrdemTreino ordemTreino = gson.fromJson(json, OrdemTreino.class);
		
		OrdemTreinoDAO oredemTreinoDAO = new OrdemTreinoDAO();
		ordemTreino = oredemTreinoDAO.findById(ordemTreino.getCodigo());
		oredemTreinoDAO.delete(ordemTreino);
		
		return Response.ok().entity(gson.toJson(ordemTreino)).type("application/json").build();
	}
	
	@POST
	public Response salvar(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		OrdemTreino ordemTreino = gson.fromJson(json, OrdemTreino.class);
		
		OrdemTreinoDAO oredemTreinoDAO = new OrdemTreinoDAO();
		oredemTreinoDAO.merge(ordemTreino);
		
		return Response.ok().entity(json).type("application/json").build();		
	}
}
