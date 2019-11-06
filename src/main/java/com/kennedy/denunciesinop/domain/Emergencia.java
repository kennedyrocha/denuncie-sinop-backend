package com.kennedy.denunciesinop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kennedy.denunciesinop.domain.enums.TipoEmergencia;

@Entity
public class Emergencia implements Serializable {
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer tipo;
	private long latitude;
	private long longitude;
	
	public Emergencia() {
		super();
	}

	public Emergencia(Integer id, Integer tipo, long latitude, long longitude) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public TipoEmergencia getTipo() {
		return TipoEmergencia.toEnum(this.tipo);
	}

	public void setTipo(TipoEmergencia tipo) {
		this.tipo = tipo.getCod();
	}
}
