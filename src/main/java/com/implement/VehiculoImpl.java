package com.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Vehiculo;
import com.repositories.RepositoriesVehiculo;
import com.services.VehiculoService;

@Service
public class VehiculoImpl implements VehiculoService{

	@Autowired
	private RepositoriesVehiculo repo;
	
	public Vehiculo guardarVehiculo(Vehiculo vh) {		
		return repo.save(vh);		
	}
	
	public List<Vehiculo> buscarTodos() {		
		return repo.findAll();
	}

	
	
	

}
