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

import br.com.dragonfly.bo.EmpresaBO;
import br.com.dragonfly.to.EmpresaTO;

@Path("/empresa")
public class EmpresaResource {
	
	EmpresaBO empBO = new EmpresaBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EmpresaTO> buscaEmps() {
		return empBO.listaEmpresas();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public EmpresaTO buscaEmp(@PathParam("id")int id) {
		return empBO.listaEmpresa(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EmpresaTO empTO, @Context UriInfo uriInfo) {
		String resp = empBO.cadastraEmpresa(empTO);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		if (resp.equals("Inserido com sucesso!")) {
			builder.path(Integer.toString(empTO.getIdEmpresa()));
		}
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(EmpresaTO empTO, @PathParam("id") int id) {
		empTO.setIdEmpresa(id);
		String resp = empBO.alteraEmpresa(empTO);
		if (resp.equals("Alterado com sucesso!")) {
			return Response.ok().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int id) {
		empBO.excluiEmpresa(id);
	}
}
