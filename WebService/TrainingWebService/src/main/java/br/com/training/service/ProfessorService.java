package br.com.training.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.training.dao.ProfessorDAO;
import br.com.training.model.Aluno;

@Path("professor")
public class ProfessorService {
	@GET
	@Path("{codigo}")
	public Response getAlunosDoProfessor(@PathParam("codigo") Long codigo){
		ProfessorDAO professorDAO = new ProfessorDAO();
		List<Aluno> alunos = professorDAO.buscarAlunoPorProfessor(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(alunos);

		return Response.ok().entity(json).type("Aplication/json").build();
	}
	
}
