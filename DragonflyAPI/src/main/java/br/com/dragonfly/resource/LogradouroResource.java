package br.com.dragonfly.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dragonfly.bo.LogradouroBO;
import br.com.dragonfly.to.LogradouroTO;

@Path("/logradouro")
public class LogradouroResource {
	private LogradouroBO bBO = new LogradouroBO();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LogradouroTO> buscaLogradouros() {
		return bBO.listaLogradouros();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ArrayList<LogradouroTO> buscaLogradouros(@PathParam("id") int id) {
		return bBO.listaLogradouro(id);
	}
}
