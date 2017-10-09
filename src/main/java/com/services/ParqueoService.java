package com.services;

import java.util.List;

import com.entities.Parqueo;

public interface ParqueoService {

	public Parqueo guardarParqueo(Parqueo parqueo);
	
	public List<Parqueo> buscarTodos();
	
	public List<Parqueo> findByIdClaseVehiculo(int idClaseVehiculo);
	
	public Parqueo findByPlacaVehiculo(String placaVehiculo);
	
	public float calcularCobro(String placaVehiculo);
	
	
}
