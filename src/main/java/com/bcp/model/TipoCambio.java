package com.bcp.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Table("tipocambio")
public class TipoCambio {
	
	@Id
	private Integer id;

	@Column("monto")
	private Double monto;

	@Column("montocontipocambio")
	private Double montocontipocambio;

	@Column("monedaorigen")
	private String monedaorigen;

	@Column("monedadestino")
	private String monedadestino;

	@Column("tipocambio")
	private Double tipocambio;
	
	@Column("codUsuRegis")
	private String codUsuRegis;
	
	@Column("fecRegis")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecRegis;
	
	@JsonIgnore
	@Column("codUsuModif")
    private String codUsuModif;
	
	@JsonIgnore
	@Column("fecModif")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecModif;
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Double getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(Double tipocambio) {
		this.tipocambio = tipocambio;
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

	public String getCodUsuRegis() {
		return codUsuRegis;
	}

	public void setCodUsuRegis(String codUsuRegis) {
		this.codUsuRegis = codUsuRegis;
	}



	public String getCodUsuModif() {
		return codUsuModif;
	}

	public void setCodUsuModif(String codUsuModif) {
		this.codUsuModif = codUsuModif;
	}

	public LocalDate getFecRegis() {
		return fecRegis;
	}

	public void setFecRegis(LocalDate fecRegis) {
		this.fecRegis = fecRegis;
	}

	public LocalDate getFecModif() {
		return fecModif;
	}

	public void setFecModif(LocalDate fecModif) {
		this.fecModif = fecModif;
	}







}
