package com.bcp.service.impl;

import com.bcp.repo.IGenericRepo;
import com.bcp.service.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{

	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public Flux<T> listar(){
		return getRepo().findAll();		
	}
	
	@Override
	public Mono<T> listarPorId(ID id) {
		return getRepo().findById(id);
	}

	@Override
	public Mono<T> registrar(T t){
		return getRepo().save(t);		
	}

	@Override
	public Mono<T> modificar(T t){
		return getRepo().save(t);	
	}

	@Override
	public Mono<Void> eliminar(ID id) {
		return getRepo().deleteById(id);
	}
	
}
