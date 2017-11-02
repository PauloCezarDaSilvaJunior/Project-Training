package br.com.training.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.AlunoTreinamentoDAO;
import br.com.training.model.Aluno;
import br.com.training.model.AlunoTreinamento;
import br.com.training.model.Treinamento;

@Path("alunoTreinamento")
public class AlunoTreinamentoService {
	@GET
	@Path("{codAluno}")
	public Response listar(@PathParam("codAluno") Long codAluno){
		AlunoTreinamentoDAO alunoTreinamentoDAO = new AlunoTreinamentoDAO();
		List<AlunoTreinamento> alunoTreinamentos = alunoTreinamentoDAO.listarPorAlunoETreinamento(codAluno);


		List<Treinamento> treinamentos = new ArrayList<>();
		for(AlunoTreinamento alunoTreinamento: alunoTreinamentos){
			treinamentos.add(alunoTreinamento.getTreinamento());
		}

		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		String json = gson.toJson(treinamentos);

		return Response.ok().entity(json).type("application/json").build();
	}

	@DELETE
	public Response delete(String json){
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		AlunoTreinamento alunoTreinamento = gson.fromJson(json, AlunoTreinamento.class);
		
		AlunoTreinamentoDAO alunoTreinamentoDAO = new AlunoTreinamentoDAO();
		alunoTreinamento = alunoTreinamentoDAO.findById(alunoTreinamento.getCodigo());
		alunoTreinamentoDAO.delete(alunoTreinamento);
		
		return Response.ok().entity(gson.toJson(alunoTreinamento)).type("application/json").build();
	}
	
	@POST
	@Path("{codAluno}")
	public Response salvar(String json, @PathParam("codAluno") Long codAluno){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Treinamento[] treinamentos = gson.fromJson(json, Treinamento[].class);
		Aluno aluno = new Aluno(codAluno);
		AlunoTreinamentoDAO alunoTreinamentoDAO = new AlunoTreinamentoDAO();
		for(int i = 0; i < treinamentos.length; i++){
			alunoTreinamentoDAO.merge(new AlunoTreinamento(aluno, treinamentos[i]));
		}
		
		return Response.ok().entity(json).type("application/json").build();		
	}
}
