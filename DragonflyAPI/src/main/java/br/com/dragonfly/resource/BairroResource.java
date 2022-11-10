package br.com.dragonfly.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dragonfly.bo.BairroBO;
import br.com.dragonfly.to.BairroTO;

@Path("/bairro")
public class BairroResource {
	private BairroBO bBO = new BairroBO();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BairroTO> buscaContatos() {
		return bBO.listaBairros();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public BairroTO buscaContato(@PathParam("id") int id) {
		return bBO.listaBairro(id);
	}
}
