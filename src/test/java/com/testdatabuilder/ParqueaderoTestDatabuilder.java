package com.testdatabuilder;

import java.util.Calendar;

import com.entities.Parqueo;

import testdatabuilder.LibroTestDataBuilder;

public class ParqueaderoTestDatabuilder {
	
	private static final int  IDCLASEVEHICULO = 1;
	private static final String PLACAVEHICULO = "CJA083";
	private static final int CILINDRAJE = 1800;
	private static final Calendar FECHA_PARQUEO = Calendar.getInstance();;
	
	private int idClaseVehiculo;
	private String placaVehiculo;
	private int cilindraje;
	private Calendar fechaParqueo;
	
	
	public ParqueaderoTestDatabuilder() {
		this.idClaseVehiculo = IDCLASEVEHICULO;
		this.placaVehiculo = PLACAVEHICULO;
		this.cilindraje = CILINDRAJE;
		this.fechaParqueo = FECHA_PARQUEO;
	}
	
	
	public ParqueaderoTestDatabuilder conidClaseVehiculo(int idClaseVehiculo) {
		this.idClaseVehiculo = idClaseVehiculo;
		return this;
	}

	public ParqueaderoTestDatabuilder conplacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
		return this;
	}

	public ParqueaderoTestDatabuilder concilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public ParqueaderoTestDatabuilder confechaParqueo(Calendar fechaParqueo) {
		this.fechaParqueo = fechaParqueo;
		return this;
	}

	public Parqueo build() {
		return new Parqueo(this.idClaseVehiculo, this.placaVehiculo, this.cilindraje, this.fechaParqueo);
	}
	

}
