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

import br.com.training.dao.TreinamentoDAO;
import br.com.training.model.Treinamento;

public class TreinamentoService {
	@GET
	public Response listar(){
		TreinamentoDAO treinamentoDAO = new TreinamentoDAO();
		List<Treinamento> treinamentos = treinamentoDAO.listar();

		Gson gson = new Gson();
		String json = gson.toJson(treinamentos);

		return Response.ok().entity(json).type("aplication/json").build();
	}
	
	@GET
	@Path("{codigo}")
	public Response findById(@PathParam("codigo") Long codigo){
		TreinamentoDAO treinamentoDAO = new TreinamentoDAO();
		Treinamento treinamento = treinamentoDAO.findById(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(treinamento);

		return Response.ok().entity(json).type("aplication/json").build();
	}
	
	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Treinamento treinamento = gson.fromJson(json, Treinamento.class);
		
		TreinamentoDAO treinamentoDAO = new TreinamentoDAO();
		treinamento = treinamentoDAO.findById(treinamento.getCodigo());
		treinamentoDAO.delete(treinamento);
		
		return Response.ok().entity(gson.toJson(treinamento)).type("aplication/json").build();
	}
	
	@POST
	public Response salvar(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Treinamento treinamento = gson.fromJson(json, Treinamento.class);
		
		TreinamentoDAO exercicioDAO = new TreinamentoDAO();
		exercicioDAO.merge(treinamento);
		
		return Response.ok().entity(json).type("aplication/json").build();		
	}
	

}
