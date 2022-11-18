package br.com.dragonfly.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.dragonfly.bo.EmpresaBO;
import br.com.dragonfly.bo.FuncionarioBO;
import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.FuncionarioTO;

@Path("/login")
public class LoginResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/func")
	public Response loginFuncionario(FuncionarioTO func) {
		FuncionarioBO fBO = new FuncionarioBO();
		return Response
				.status(200)
				.entity(fBO.login(func))
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/emp")
	public Response loginEmpresa(EmpresaTO emp) {
		EmpresaBO empBO = new EmpresaBO();
		return Response
				.status(200)
				.entity(empBO.login(emp))
				.build();
	}
}
