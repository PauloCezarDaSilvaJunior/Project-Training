package br.com.training.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.training.dao.AlunoDAO;
import br.com.training.model.Aluno;

@Path("cadastroAluno")
public class CadastroAlunoService {
	@POST
	public String salvar(String json){
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		Aluno aluno = gson.fromJson(json, Aluno.class);
		
		SimpleHash hash = new SimpleHash("sha-256",aluno.getSenha());
		aluno.setSenha(hash.toHex());
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.merge(aluno);
		
		return gson.toJson(aluno);
	}
}
