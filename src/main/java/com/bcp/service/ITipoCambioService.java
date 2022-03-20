package com.bcp.service;

import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import reactor.core.publisher.Mono;

public interface ITipoCambioService extends ICRUD<TipoCambio, Integer> {
	
	Mono<TipoCambio> registrar(TipoCambioRequest p);
//	Mono<TipoCambio> registrarTipoCambio(TipoCambioRequest p);
	//Mono<TipoCambio> actualizarTipoCambio(String id);
}
