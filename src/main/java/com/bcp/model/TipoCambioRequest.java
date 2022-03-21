package com.bcp.model;

import javax.validation.constraints.NotNull;

public class TipoCambioRequest {
	
	@NotNull(message = "El campo 'monedaOrigen' no puede ser nulo")
    private String monedaOrigen;
	
	@NotNull(message = "El campo 'monedaDestino' no puede ser nulo")
    private String monedaDestino;
	
	@NotNull(message = "El campo 'tipoCambio' no puede ser nulo")
    private Double tipoCambio;
    
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	

}
