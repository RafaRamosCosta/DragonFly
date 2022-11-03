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

import br.com.dragonfly.bo.PagamentoBO;
import br.com.dragonfly.to.PagamentoTO;

@Path("/pagamento")
public class PagamentoResource {
	private PagamentoBO pBO = new PagamentoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PagamentoTO> buscaPagamentos() {
		return pBO.listaPagamentos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public PagamentoTO buscaPagamento(@PathParam("id") int id) {
		return pBO.listaPagamento(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(PagamentoTO pagto, @Context UriInfo uriInfo) {
		String resp = pBO.cadastraPagamento(pagto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(pagto.getIdPagamento()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(PagamentoTO pagto, @PathParam("id") int id) {
		String resp = pBO.alteraPagamento(pagto);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		pBO.excluiPagamento(id);
	}
}
