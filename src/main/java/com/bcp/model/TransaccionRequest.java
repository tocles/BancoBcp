package com.bcp.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;

public class TransaccionRequest {
	
	@Id
	private Integer id;
	
	@NotNull(message = "El campo 'monto' no puede ser nulo")
	private Double monto;
	@NotNull(message = "El campo 'currency' no puede ser nulo")
	@Pattern(regexp = "^(PEN|USD|EUR)+$", message = "El campo monedaOrigen solo permite los valores 'USD' , 'PEN' , 'EUR'")
	private String monedaOrigen;
	@Pattern(regexp = "^(PEN|USD|EUR)+$", message = "El campo monedaDestino solo permite los valores 'USD' , 'PEN' , 'EUR'")
	private String monedaDestino;
	@NotNull(message = "El campo 'tipoCambio' no puede ser nulo")
	private Double tipoCambio;
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	
	
	


	
}
