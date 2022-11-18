package br.com.dragonfly.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.dragonfly.bo.ContatoFuncionarioBO;
import br.com.dragonfly.to.ContatoFuncionarioTO;

@Path("/contatofuncionario")
public class ContatoFuncionarioResource {
private ContatoFuncionarioBO contBO = new ContatoFuncionarioBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ContatoFuncionarioTO> buscaContatos() {
		return contBO.listaContatos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ContatoFuncionarioTO buscaContato(@PathParam("id") int id) {
		return contBO.listaContato(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ContatoFuncionarioTO cont, @Context UriInfo uriInfo) {
		String resp = contBO.cadastraContato(cont);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(cont.getIdContFunc()));
			return Response.created(builder.build()).build();
		} else {
			return Response.status(405).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(ContatoFuncionarioTO cont, @PathParam("id") int id) {
		String resp = contBO.alteraContato(cont);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		contBO.excluiContato(id);
	}
}
