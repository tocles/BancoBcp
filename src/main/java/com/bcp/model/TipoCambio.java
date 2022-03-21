package com.bcp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tipo_cambio")
public class TipoCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "moneda_origen")
	private String monedaOrigen;
	
	@Column(name = "moneda_destino")
	private String monedaDestino;

	@Column(name = "tipo_cambio")
	private Double tipoCambio;

	@Column(name = "fec_regi")
	private Date fecregis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Date getFecregis() {
		return fecregis;
	}

	public void setFecregis(Date fecregis) {
		this.fecregis = fecregis;
	}





}
