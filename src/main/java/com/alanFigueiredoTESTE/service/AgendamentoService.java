package com.alanFigueiredoTESTE.service;

import java.util.Collection;

import com.alanFigueiredoTESTE.exception.NegocioException;
import com.alanFigueiredoTESTE.model.AgendamentoModel;

public interface AgendamentoService {

	public Double calcularTaxaAgendamento(AgendamentoModel agendamentoModel);

	public void validarTaxaAgendamento(AgendamentoModel agendamentoModel)
			throws NegocioException;

	public void salvarAgendamento(AgendamentoModel agendamentoModel)
			throws NegocioException;

	public Collection<AgendamentoModel> listarAgendamentos();
	
}
