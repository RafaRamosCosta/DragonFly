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

import br.com.dragonfly.bo.PedidoBO;
import br.com.dragonfly.to.PedidoTO;

@Path("/pedido")
public class PedidoResource {
	
	private PedidoBO pBO = new PedidoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PedidoTO> buscaPedidos() {
		return pBO.listaPedidos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public PedidoTO buscaPedido(@PathParam("id") int id) {
		return pBO.listaPedido(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(PedidoTO pedido, @Context UriInfo uriInfo) {
		String resp = pBO.cadastraPedido(pedido);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(pedido.getIdPedido()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizaar(PedidoTO pedido, @PathParam("id") int id) {
		String resp = pBO.alteraPedido(pedido);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		pBO.excluiPedido(id);
	}
}
