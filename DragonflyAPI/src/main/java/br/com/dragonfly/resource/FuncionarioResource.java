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

import br.com.dragonfly.bo.FuncionarioBO;
import br.com.dragonfly.to.FuncionarioTO;

@Path("/funcionario")
public class FuncionarioResource {
	
	private FuncionarioBO fBO = new FuncionarioBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FuncionarioTO> buscaFuncionarios() {
		return fBO.listaFuncionarios();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public FuncionarioTO buscaFuncionario(@PathParam("id") int id) {
		return fBO.listaFuncionario(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(FuncionarioTO func, @Context UriInfo uriInfo) {
		String resp = fBO.cadastraFuncionario(func);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(func.getIdFunc()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(FuncionarioTO func, @PathParam("id") int id) {
		String resp = fBO.alteraFuncionario(func);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		fBO.excluirFuncionario(id);
	}
}
