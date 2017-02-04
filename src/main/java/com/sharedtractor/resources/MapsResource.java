package com.sharedtractor.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/mapa")
public class MapsResource {

	public String getDirections(){
		/*
		 Client client = Client.create();		
		 WebResource webResource = client.resource(Constantes.GEOCODE_API);
		  /*MultivaluedMap formData = new MultivaluedMapImpl();
		  formData.add("name1", "val1");
		  formData.add("name2", "val2");
		  return webResource.get(String.class);
		  */
		  return null;
	}
	@GET
	@Path("/teste")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCEP(){
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://viacep.com.br/ws/01001000/json/").request().get();
		
		if(response.getStatus() != 200){
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}
		
		return response.readEntity(String.class);
		/*		
		Form form = new Form();
		form.param("x", "foo");
		form.param("y", "bar");
		*/

	}
	
}
