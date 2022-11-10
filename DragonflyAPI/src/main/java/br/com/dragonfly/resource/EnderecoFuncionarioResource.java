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

import br.com.dragonfly.bo.EnderecoFuncionarioBO;
import br.com.dragonfly.to.EnderecoFuncionarioTO;

@Path("/enderecofuncionario")
public class EnderecoFuncionarioResource {
private EnderecoFuncionarioBO endBO = new EnderecoFuncionarioBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EnderecoFuncionarioTO> buscaEnderecos() {
		return endBO.listaEnderecos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public EnderecoFuncionarioTO buscaEndereco(@PathParam("id") int id) {
		return endBO.listaEndereco(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EnderecoFuncionarioTO end, @Context UriInfo uriInfo) {
		String resp = endBO.cadastraEndereco(end);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(end.getIdEndFunc()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(EnderecoFuncionarioTO end, @PathParam("id") int id) {
		String resp = endBO.alteraEndereco(end);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		endBO.excluiEndereco(id);
	}
}
