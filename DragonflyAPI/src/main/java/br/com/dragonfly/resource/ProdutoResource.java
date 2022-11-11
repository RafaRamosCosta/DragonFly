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

import br.com.dragonfly.bo.ProdutoBO;
import br.com.dragonfly.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {
	
	ProdutoBO prodBO = new ProdutoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProdutoTO> buscaProds() {
		return prodBO.listaProdutos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ProdutoTO buscaProd(@PathParam("id") int id) {
		return prodBO.listaProduto(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO prodTO, @Context UriInfo uriInfo) {
		String resp = prodBO.cadastraProduto(prodTO);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(prodTO.getIdProduto()));
			return Response.created(builder.build()).build();
		} else {
			return Response.status(405).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(ProdutoTO prodTO, @PathParam("id") int id) {
		prodTO.setIdProduto(id);
		String resp = prodBO.alteraProduto(prodTO);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		prodBO.excluiProduto(id);
	}
}
