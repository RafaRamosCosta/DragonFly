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

import br.com.dragonfly.bo.ItemPedidoBO;
import br.com.dragonfly.to.ItemPedidoTO;

@Path("/itempedido")
public class ItemPedidoResource {
	ItemPedidoBO iPBO = new ItemPedidoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ItemPedidoTO> buscaItens() {
		return iPBO.listaItens();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ItemPedidoTO buscaItem(@PathParam("id") int id) {
		return iPBO.listaItem(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastraItem(ItemPedidoTO item, @Context UriInfo uriInfo) {
		String resp = iPBO.cadastraItem(item);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(item.getIdItemPedido()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizaItem(ItemPedidoTO item, @PathParam("id") int id) {
		String resp = iPBO.alteraItem(item);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletaItem(@PathParam("id") int id) {
		iPBO.excluiItem(id);
	}
}
