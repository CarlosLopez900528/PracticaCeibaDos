package com.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class Parqueo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idParqueo;
	
	@Column
	private int idClaseVehiculo;
	
	@Column
	private String placaVehiculo;
	
	@Column
	@CreationTimestamp
	private Calendar fechaParqueo;
	
	public Parqueo() {		
	}

	public Parqueo(Long idParqueo, int idClaseVehiculo, String placaVehiculo, Calendar fechaParqueo) {
		this.idParqueo = idParqueo;
		this.idClaseVehiculo = idClaseVehiculo;
		this.placaVehiculo = placaVehiculo;
		this.fechaParqueo = fechaParqueo;
	}

	public Long getIdParqueo() {
		return idParqueo;
	}

	public void setIdParqueo(Long idParqueo) {
		this.idParqueo = idParqueo;
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

	public Calendar getFechaParqueo() {
		return fechaParqueo;
	}

	public void setFechaParqueo(Calendar fechaParqueo) {
		this.fechaParqueo = fechaParqueo;
	}	
}
