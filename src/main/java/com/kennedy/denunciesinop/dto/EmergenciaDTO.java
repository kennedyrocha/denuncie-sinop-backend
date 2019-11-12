package com.kennedy.denunciesinop.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.kennedy.denunciesinop.domain.Emergencia;

public class EmergenciaDTO implements Serializable{
	private static final long serialVersionUID = 1;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrogatório")
	private Integer tipo;
	private long latitude;
	private long longitude;
	
	public EmergenciaDTO() {
	}
	
	public EmergenciaDTO(Emergencia obj) {
		
		this.id = obj.getId();
		this.tipo = obj.getTipo().getCod();
		this.latitude = obj.getLatitude();
		this.longitude = obj.getLongitude();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
}
