package br.com.training.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.training.dao.CidadeDAO;
import br.com.training.model.Cidade;

@Path("cidade")
public class CidadeService {
	@GET
	public Response listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades = cidadeDAO.listar("nome");

		Gson gson = new Gson();
		String json = gson.toJson(cidades);

		return Response.ok().entity(json).type("Aplication/json").build();
	}
	
	@GET
	@Path("{estado}")
	public Response listarPorEstado(@PathParam("estado") Long estado){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades = cidadeDAO.buscarPorEstado(estado);

		Gson gson = new Gson();
		String json = gson.toJson(cidades);

		return Response.ok().entity(json).type("Aplication/json").build();
	}
}
