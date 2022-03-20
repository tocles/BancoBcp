package com.bcp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import com.bcp.service.ITipoCambioService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/moneda")
public class TipoCambioController {

	@Autowired
	private ITipoCambioService iTipoCambioService;

	@PostMapping
	public Mono<TipoCambio> realizarTipoCambio(@RequestBody TipoCambioRequest request  
			){
		return iTipoCambioService.registrar(request);
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<TipoCambio>> actualizarTipoCambio(@RequestBody TipoCambioRequest request , @PathVariable("id") String id
			){
         
		 Mono<TipoCambioRequest> monoPlato = Mono.just(request);
		 Mono<TipoCambio> monoBd = iTipoCambioService.listarPorId(Integer.parseInt(id));
		 return  monoBd.zipWith(monoPlato, (bd,p) -> {	
			 bd.setTipocambio(request.getTipoCambio());
			 bd.setFecModif(LocalDate.now());
			 bd.setCodUsuModif("usr_banco");
			 return bd;
		 })
		.flatMap(iTipoCambioService::modificar)
		.map(pl->ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(pl))
		.defaultIfEmpty(new ResponseEntity<TipoCambio>(HttpStatus.NOT_FOUND));
	}
	
	
	@GetMapping("/{id}")
	public Mono<TipoCambio> busquedaTipoCambio(@PathVariable("id") String id) {
		return iTipoCambioService.listarPorId(Integer.parseInt(id));
	}
	


}
