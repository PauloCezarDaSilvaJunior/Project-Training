package br.com.training.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.MensagemDAO;
import br.com.training.model.Mensagem;

public class MensagemService {
	@GET
	public Response listar(@PathParam("codigoAluno") Long codigoAluno, @PathParam("codigoProfessor") Long codigoProfessor){
		MensagemDAO mensagem = new MensagemDAO();
		List<Mensagem> mensagens = mensagem.listarPorAlunoEProfessor(codigoAluno, codigoProfessor);

		Gson gson = new Gson();
		String json = gson.toJson(mensagens);

		return Response.ok().entity(json).type("Aplication/json").build();
	}
	@POST
	public Response salvar(String json){
		Gson gson = new Gson();
		Mensagem mensagem = gson.fromJson(json, Mensagem.class);
		
		MensagemDAO mensagemDAO = new MensagemDAO();
		mensagemDAO.merge(mensagem);
		
		return Response.ok().entity(json).type("aplication/json").build();		
	}
	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().create();
		Mensagem mensagem = gson.fromJson(json, Mensagem.class);
		
		MensagemDAO mensagemDAO = new MensagemDAO();
		Mensagem mensagemExcluir = mensagemDAO.findById(mensagem.getCodigo());
		mensagemDAO.delete(mensagemExcluir);
		
		return Response.ok().entity(gson.toJson(mensagem)).type("Aplication/json").build();
	}
}
