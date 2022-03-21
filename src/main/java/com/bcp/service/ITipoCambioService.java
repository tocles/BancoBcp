package com.bcp.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import com.bcp.model.TipoCambioResponse;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface ITipoCambioService {
	
	Single<TipoCambioResponse> obtenerTipoCambio (Double monto , String monedaOrigen, String monedaDestino);
	Completable guardarTipoCambio (TipoCambioRequest tipoCambioRequest);
	Completable actualizarTipoCambio (TipoCambioRequest tipoCambioRequest, String id);
	Single<Optional<TipoCambio>> busquedaTipoCambio (String id);
}
