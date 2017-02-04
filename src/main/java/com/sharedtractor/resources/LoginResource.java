package com.sharedtractor.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sharedtractor.business.LoginBusiness;
import com.sharedtractor.models.DadosLogin;
import com.sharedtractor.models.Usuario;


@Path("/login")
public class LoginResource implements IResource{

	@GET
	@Path("/user={username}&password={passwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogin(@PathParam("username") String user,@PathParam("passwd") String passwd){
		DadosLogin dados =new DadosLogin();
		dados.setUsername(user);
		dados.setPassword(passwd);
		Usuario usuario = new LoginBusiness().efetuarLogin(dados); 
		return Response.status(200).entity(usuario.toString()).build();
	}
	
	
}
