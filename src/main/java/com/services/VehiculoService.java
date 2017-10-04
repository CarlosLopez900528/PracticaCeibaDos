package com.services;


import java.util.List;

import com.entities.Vehiculo;

public interface VehiculoService {
	
	public Vehiculo guardarVehiculo(Vehiculo vh);
	
	public List<Vehiculo> buscarTodos();

}
