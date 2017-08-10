package br.com.training.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.AlunoDAO;
import br.com.training.model.Aluno;
import br.com.training.model.TipoUsuario;
import br.com.training.util.JWTUtil;

@Path("cadastroAluno")
public class CadastroAlunoService {
	@POST
	public Response salvar(String json){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Aluno aluno = gson.fromJson(json, Aluno.class);
		aluno.setTipoUsuario(TipoUsuario.ALUNO);
		SimpleHash hash = new SimpleHash("sha-256",aluno.getSenha());
		aluno.setSenha(hash.toHex());
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.merge(aluno);
		
        String token = JWTUtil.create(aluno.getEmail());
        return Response.ok().header("Authentication", token).entity( gson.toJson(aluno)).type("aplication/json").build();
	}
}
