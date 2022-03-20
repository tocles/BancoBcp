package com.bcp.model;

import java.util.Date;

import org.springframework.data.relational.core.mapping.Column;
public class Auditoria {
	
	@Column("codUsuRegis")
	private String codUsuRegis;
	@Column("fecRegis")
	private Date fecRegis;
	@Column("codUsuModif")
    private String codUsuModif;
	@Column("fecModif")
	private Date fecModif;
	
	public String getCodUsuRegis() {
		return codUsuRegis;
	}
	public void setCodUsuRegis(String codUsuRegis) {
		this.codUsuRegis = codUsuRegis;
	}
	public Date getFecRegis() {
		return fecRegis;
	}
	public void setFecRegis(Date fecRegis) {
		this.fecRegis = fecRegis;
	}
	public String getCodUsuModif() {
		return codUsuModif;
	}
	public void setCodUsuModif(String codUsuModif) {
		this.codUsuModif = codUsuModif;
	}
	public Date getFecModif() {
		return fecModif;
	}
	public void setFecModif(Date fecModif) {
		this.fecModif = fecModif;
	}

	
	
}
