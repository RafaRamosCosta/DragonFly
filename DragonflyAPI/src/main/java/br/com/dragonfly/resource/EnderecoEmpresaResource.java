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

import br.com.dragonfly.bo.EnderecoEmpresaBO;
import br.com.dragonfly.to.EnderecoEmpresaTO;

@Path("/enderecoempresa")
public class EnderecoEmpresaResource {

	private EnderecoEmpresaBO endBO = new EnderecoEmpresaBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EnderecoEmpresaTO> buscaEnderecos() {
		return endBO.listaEnderecos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public EnderecoEmpresaTO buscaEndereco(@PathParam("id") int id) {
		return endBO.listaEndereco(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EnderecoEmpresaTO end, @Context UriInfo uriInfo) {
		String resp = endBO.cadastraEndereco(end);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(end.getIdEndEmp()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(EnderecoEmpresaTO end, @PathParam("id") int id) {
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
