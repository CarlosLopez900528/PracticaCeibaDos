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
	private String nombre;
	
	
	
	
	public Vehiculo() {
	}

	public Vehiculo(Long idVehiculo, String nombre) {
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
