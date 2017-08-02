package br.com.training.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.training.dao.UsuarioDAO;
import br.com.training.model.Usuario;
import br.com.training.util.JWTUtil;

@Path("login")
public class LoginService {

	@POST
	public Response logar(String json){
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(usuarioDAO.logar(usuario)){
	        String token = JWTUtil.create(usuario.getEmail());
	        return Response.ok().header("Authentication", token).build();
		}else{
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}
