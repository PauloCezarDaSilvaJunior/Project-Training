package br.com.training.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.training.dao.UsuarioDAO;
import br.com.training.model.Usuario;

@Path("usuario")
public class UsuarioService {
	//Salvar e deletar atravez do AlunoService ou do ProfessorService
	@GET
	public String listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.listar("nome");

		Gson gson = new Gson();
		String json = gson.toJson(usuarios);

		return json;
	}
	
	@GET
	@Path("{codigo}")
	public String findById(@PathParam("codigo") Long codigo){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.findById(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(usuario);

		return json;
	}
}
