package br.com.rolesoft.ica_server_sample.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.rolesoft.ica_server.webservice.ImageAdapter;

@Path("/image")
public class ImageAdapterWS {
	
	@POST	@Path("/{numOfImages}/{imagesIds}")
	@Consumes("application/json")
	@Produces("application/json")
	public String sendImage(String json, @PathParam("numOfImages") int numOfImages, 
			@PathParam("imagesIds") String imagesIds){
		return ImageAdapter.getImage(json, numOfImages, imagesIds, "/home/ubuntu/Pictures/");
	}
}
