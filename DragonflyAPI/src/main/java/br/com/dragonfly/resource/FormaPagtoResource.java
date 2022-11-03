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

import br.com.dragonfly.bo.FormaPagtoBO;
import br.com.dragonfly.to.FormaPagtoTO;

@Path("/formapagto")
public class FormaPagtoResource {
	private FormaPagtoBO formaBO = new FormaPagtoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FormaPagtoTO> buscaFormas() {
		return formaBO.listaFormasPagto();
		
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public FormaPagtoTO buscaForma(@PathParam("id") int id) {
		return formaBO.listaFormaPagto(id);
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(FormaPagtoTO forma, @Context UriInfo uriInfo) {
		String resp = formaBO.cadastraFormaPagto(forma);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(forma.getIdFormaPagto()));
		} 
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(FormaPagtoTO forma, @PathParam("id") int id) {
		forma.setIdFormaPagto(id);
		String resp = formaBO.alteraFormaPagto(forma);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		formaBO.excluiFormaPagto(id);
	}
}
