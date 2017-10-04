package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVehiculo;
	
	@Column
	private int idClaseVehiculo;
	
	@Column
	private String placaVehiculo;

	public Vehiculo() {
	}

	public Vehiculo(Long idVehiculo, int idClaseVehiculo, String placaVehiculo) {
		super();
		this.idVehiculo = idVehiculo;
		this.idClaseVehiculo = idClaseVehiculo;
		this.placaVehiculo = placaVehiculo;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getIdClaseVehiculo() {
		return idClaseVehiculo;
	}

	public void setIdClaseVehiculo(int idClaseVehiculo) {
		this.idClaseVehiculo = idClaseVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
}
