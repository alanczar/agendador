package com.alanFigueiredoTESTE.integracao;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.alanFigueiredoTESTE.exception.NegocioException;
import com.alanFigueiredoTESTE.model.AgendamentoModel;
import com.alanFigueiredoTESTE.service.AgendamentoService;

public class IntegracaoRest {
	@Context
	private HttpServletResponse response;

	@Autowired
	private AgendamentoService agendamentoService;

	@OPTIONS
	@Path("/{path:.*}")
	public javax.ws.rs.core.Response headerRequest(@HeaderParam("Access-Control-Request-Method") final String requestMethod,
			@HeaderParam("Access-Control-Request-Headers") final String requestHeaders) {
		final ResponseBuilder retValue = Response.ok();
		if (requestHeaders != null) {
			retValue.header("Access-Control-Allow-Headers", requestHeaders);
		}
		if (requestMethod != null) {
			retValue.header("Access-Control-Allow-Methods", requestMethod);
		}
		retValue.header("Access-Control-Allow-Origin", "*");

		return retValue.build();
	}

	@POST
	@Path("/calcularTaxa")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	public Double calcularTaxa(AgendamentoModel agendamentoModel) {
		return this.agendamentoService.calcularTaxaAgendamento(agendamentoModel);
	}

	@POST
	@Path("/salvarAgendamento")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvarAgendamento(AgendamentoModel agendamentoModel) throws NegocioException {
		this.agendamentoService.salvarAgendamento(agendamentoModel);
	}

	@POST
	@Path("/listarAgendamentos")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<AgendamentoModel> listarAgendamentos() throws NegocioException {
		return this.agendamentoService.listarAgendamentos();
	}
}
