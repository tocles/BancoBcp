package com.bcp.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import com.bcp.model.TipoCambioResponse;
import com.bcp.service.ITipoCambioService;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@RestController
@RequestMapping("/moneda")
@Validated
public class TipoCambioController {

	@Autowired
	private ITipoCambioService iTipoCambioService;

	

	@GetMapping(value = "/obtenerTipoCambio")
	public Single<ResponseEntity<TipoCambioResponse>> ejecutarTipoCambio(
			    @RequestParam
	            @NotNull(message = "El campo 'monto' no puede ser nulo")
	                    Double monto,

	            @RequestParam
	            @NotNull(message = "El campo 'monedaOrigen' no puede ser nulo")
	            @Pattern(regexp = "^(PEN|USD|EUR)+$", message = "El campo 'monedaOrigen' solo permite los valores 'USD' 'PEN' y 'EUR'")
	                    String monedaOrigen,

	            @RequestParam
	            @NotNull(message = "El campo monedaDestino no puede ser nulo")
	            @Pattern(regexp = "^(PEN|USD|EUR)+$", message = "El campo 'monedaDestino' solo permite los valores 'USD' 'PEN' y 'EUR'")
	                    String monedaDestino) {
		return iTipoCambioService.obtenerTipoCambio(monto,monedaOrigen,monedaDestino).map(ResponseEntity::ok);
	}
	
	
	@PostMapping(value = "/")
	public Completable guardarTipoCambio(@Valid @RequestBody TipoCambioRequest tipoCambioRequest) {
		return iTipoCambioService.guardarTipoCambio(tipoCambioRequest);

	}
	
	@PutMapping("/{id}")
	public Completable actualizarTipoCambio(@Valid @RequestBody TipoCambioRequest tipoCambioRequest , @PathVariable("id") String id) {
		return iTipoCambioService.actualizarTipoCambio(tipoCambioRequest , id);
	}
	
	@GetMapping("/{id}")
	public Single<Optional<TipoCambio>> busquedaTipoCambio(@PathVariable("id") String id) {
		return iTipoCambioService.busquedaTipoCambio(id);
	}

	/* ESTOS ES CON WEBFLUX */
	
	
	/*@PutMapping("/{id}")
	public Mono<ResponseEntity<Transaccion>> actualizarTipoCambio(@RequestBody TransaccionRequest request , @PathVariable("id") String id
			){
         
		 Mono<TransaccionRequest> monoPlato = Mono.just(request);
		 Mono<Transaccion> monoBd = iTipoCambioService.listarPorId(Integer.parseInt(id));
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
		.defaultIfEmpty(new ResponseEntity<Transaccion>(HttpStatus.NOT_FOUND));
	}
	
	
	@GetMapping("/{id}")
	public Mono<Transaccion> busquedaTipoCambio(@PathVariable("id") String id) {
		return iTipoCambioService.listarPorId(Integer.parseInt(id));
	}*/
	


}
