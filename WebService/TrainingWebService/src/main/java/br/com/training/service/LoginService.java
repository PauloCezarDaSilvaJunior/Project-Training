package br.com.training.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

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
		Usuario usuarioRetorno = usuarioDAO.logar(usuario);
		
		if(usuarioRetorno != null){
	        String token = JWTUtil.create(usuario.getEmail());
	        JsonElement jsonElement = gson.toJsonTree(usuarioRetorno);
	        jsonElement.getAsJsonObject().addProperty("Authentication", token);
	        String jsonRetorno = gson.toJson(jsonElement);
	        return Response.ok().header("Authentication", token).entity(jsonRetorno).type("aplication/json").build();
		}else{
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}
