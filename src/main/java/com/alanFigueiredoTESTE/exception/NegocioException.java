package com.alanFigueiredoTESTE.exception;

import lombok.Getter;
import lombok.Setter;

public class NegocioException extends Exception  {
	private static final long serialVersionUID = -5317743899043403187L;
	@Getter
	@Setter
	private Object[] parametros;
	

	public NegocioException(final String pMessage) {
		super(pMessage);
	}

	public NegocioException(final String pMessage, final Throwable pThrowlable) {
		super(pMessage, pThrowlable);
	}

	public NegocioException(final String pMessage, final Object[] params) {
		super(pMessage);
		this.parametros = params;
	}

	public NegocioException(final String pMessage, final Throwable pThrowlable, final Object[] params) {
		super(pMessage, pThrowlable);
		this.parametros = params;
	}
}
