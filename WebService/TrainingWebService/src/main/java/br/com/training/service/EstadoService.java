package br.com.training.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.training.dao.EstadoDAO;
import br.com.training.model.Estado;

@Path("estado")
public class EstadoService {
	@GET
	public Response listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> estados = estadoDAO.listar("nome");

		Gson gson = new Gson();
		String json = gson.toJson(estados);

		return Response.ok().entity(json).type("Aplication/json").build();
	}
}
