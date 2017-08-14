package br.com.training.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.MusculoDAO;
import br.com.training.model.Musculo;

public class MusculoService {
	@GET
	public Response listar(){
		MusculoDAO musculoDAO = new MusculoDAO();
		List<Musculo> musculos = musculoDAO.listar();

		Gson gson = new Gson();
		String json = gson.toJson(musculos);

		return Response.ok().entity(json).type("Aplication/json").build();
	}
	
	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().create();
		Musculo musculo = gson.fromJson(json, Musculo.class);
		
		MusculoDAO musculoDAO = new MusculoDAO();
		musculo = musculoDAO.findById(musculo.getCodigo());
		musculoDAO.delete(musculo);
		
		return Response.ok().entity(gson.toJson(musculo)).type("Aplication/json").build();
	}
}
