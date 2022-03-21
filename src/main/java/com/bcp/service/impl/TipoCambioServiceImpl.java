package com.bcp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.mapper.TipoCambioMapper;
import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import com.bcp.model.TipoCambioResponse;
import com.bcp.repo.ITipoCambioRepo;
import com.bcp.service.ITipoCambioService;
import com.bcp.utils.NotFoundException;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


@Service
public class TipoCambioServiceImpl implements ITipoCambioService {

	@Autowired
	private ITipoCambioRepo iTipoCambioRepo;


	@Override
	public Single<TipoCambioResponse> obtenerTipoCambio(Double monto, String monedaOrigen, String monedaDestino) {

		/*return buscarPorMoneda(monedaDestino)
				.map(p -> {
					if (p.isPresent()) {
						//Prueba return Single.just(new TipoCambioResponse(""));
						return TipoCambioMapper.contruirTipoCambioResponse(monto, monedaOrigen, monedaDestino, p.get());
					}
					throw new NotFoundException("El tipo de cambio enviado no existe!!!");
				});*/
		
		return  Single.fromCallable(() -> TipoCambioMapper.contruirTipoCambioResponse(monto, monedaOrigen, monedaDestino));
	}


	@Override
	public Completable guardarTipoCambio(TipoCambioRequest tipoCambioRequest) {

		return Completable.fromCallable(() -> iTipoCambioRepo.save(TipoCambioMapper.mapMonedaTipoCambio(tipoCambioRequest)));

	}

	@Override
	public Completable actualizarTipoCambio(TipoCambioRequest tipoCambioRequest, String id) {

		return buscarPorId(id)
				.flatMapCompletable(p -> {

					if (p.isPresent()) {
						TipoCambio tipoCambio = p.get();
						tipoCambio.setTipoCambio(tipoCambioRequest.getTipoCambio());

						return Completable.fromCallable(() -> iTipoCambioRepo.save(tipoCambio));
					} else {
						return Completable.error(new NotFoundException("No existe el tipo de moneda a actualizar"));
					}

				});
	}

	private Single<Optional<TipoCambio>> buscarPorId(String id) {
		return Single.fromCallable(() -> iTipoCambioRepo.findById(Long.parseLong(id)));
	}

	@Override
	public Single<Optional<TipoCambio>> busquedaTipoCambio(String id) {
		return buscarPorId(id);

	}

	/*private Single<Optional<TipoCambio>> buscarPorMoneda(String moneda) {
		return Single.fromCallable(() -> iTipoCambioRepo.buscarPorMoneda(moneda));
	}*/

}
