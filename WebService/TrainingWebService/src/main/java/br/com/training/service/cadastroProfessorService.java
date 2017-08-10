package br.com.training.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.ProfessorDAO;
import br.com.training.model.Professor;
import br.com.training.model.TipoUsuario;
import br.com.training.util.JWTUtil;

@Path("cadastroProfessor")
public class cadastroProfessorService {
	
	@POST
	public Response salvar(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Professor professor = gson.fromJson(json, Professor.class);
		professor.setTipoUsuario(TipoUsuario.PROFESSOR);
		SimpleHash hash = new SimpleHash("sha-256",professor.getSenha());
		professor.setSenha(hash.toHex());
		
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.merge(professor);
		
        String token = JWTUtil.create(professor.getEmail());
        return Response.ok().header("Authentication", token).entity( gson.toJson(professor)).type("aplication/json").build();
	}
}
