package com.alanFigueiredoTESTE.repository;

import java.util.Collection;

import com.alanFigueiredoTESTE.model.BaseModel;

/**
 * Interface singleton para gerenciar o repositorio em memoria.
 */
public interface RepositorySingleton {

	public <T extends BaseModel> Collection<T> obterListaDoRepositorio(Class<T> classe);

	public <T extends BaseModel> void salvarNoRepositorio(T baseModel);

}
