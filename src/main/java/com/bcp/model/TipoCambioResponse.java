package com.bcp.model;

public class TipoCambioResponse {
	
	private Double monto;
	private Double montocontipocambio;
	private String monedaorigen;
	private String monedadestino;
	private Double tipocambio;

	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getMontocontipocambio() {
		return montocontipocambio;
	}
	public void setMontocontipocambio(Double montocontipocambio) {
		this.montocontipocambio = montocontipocambio;
	}
	public String getMonedaorigen() {
		return monedaorigen;
	}
	public void setMonedaorigen(String monedaorigen) {
		this.monedaorigen = monedaorigen;
	}
	public String getMonedadestino() {
		return monedadestino;
	}
	public void setMonedadestino(String monedadestino) {
		this.monedadestino = monedadestino;
	}
	public Double getTipocambio() {
		return tipocambio;
	}
	public void setTipocambio(Double tipocambio) {
		this.tipocambio = tipocambio;
	}
}
