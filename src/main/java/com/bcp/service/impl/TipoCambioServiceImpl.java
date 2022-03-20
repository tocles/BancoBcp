package com.bcp.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import com.bcp.repo.IGenericRepo;
import com.bcp.repo.ITipoCambioRepo;
import com.bcp.service.ITipoCambioService;

import reactor.core.publisher.Mono;


@Service
public class TipoCambioServiceImpl extends CRUDImpl<TipoCambio, Integer> implements ITipoCambioService {
	
	@Autowired
	private ITipoCambioRepo iTipoCambioRepo;
	
	@Override
	protected IGenericRepo<TipoCambio, Integer> getRepo() {		
		return iTipoCambioRepo; 
	}
	
	
	@Override
	public Mono<TipoCambio> registrar(TipoCambioRequest p) {
		TipoCambio tipoCambio= new TipoCambio();
		double tipCambio = 0.00;
		double monto=0.00;
		if (p.getMonedaOrigen().equals("PEN") && p.getMonedaDestino().equals("USD"))
		{

			tipCambio = 0.26;

			monto = p.getMonto()*tipCambio;

		}
		if(p.getMonedaOrigen().equals("PEN") && p.getMonedaDestino().equals("EUR"))
		{
			tipCambio = 0.24;
			monto = p.getMonto()*tipCambio;

		}

		if (p.getMonedaOrigen().equals("USD") && p.getMonedaDestino().equals("PEN"))
		{

			tipCambio = 3.78;
			monto = p.getMonto()*tipCambio;
		}

		if (p.getMonedaOrigen().equals("USD") && p.getMonedaDestino().equals("EUR"))
		{

			tipCambio = 0.90;
			monto = p.getMonto()*tipCambio;
		}

		if (p.getMonedaOrigen().equals("EUR") && p.getMonedaDestino().equals("PEN"))
		{
			tipCambio = 4.19;
			monto = p.getMonto()*tipCambio;

		}


		if (p.getMonedaOrigen().equals("EUR") && p.getMonedaDestino().equals("USD"))
		{
			tipCambio = 1.11;
			monto = p.getMonto()*tipCambio;

		}
		tipoCambio.setId(p.getId());
		tipoCambio.setMonto(p.getMonto());
		tipoCambio.setMontocontipocambio(monto);
		tipoCambio.setMonedaorigen(p.getMonedaOrigen());
		tipoCambio.setMonedadestino(p.getMonedaDestino());
		tipoCambio.setTipocambio(tipCambio);
		
		tipoCambio.setCodUsuRegis("usr_banco");
		tipoCambio.setFecRegis(LocalDate.now());
		return iTipoCambioRepo.save(tipoCambio);
	}


}
