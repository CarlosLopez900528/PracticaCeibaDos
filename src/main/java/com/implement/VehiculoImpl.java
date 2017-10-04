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
		Vehiculo vehiculoNew;
		if (vh.getIdClaseVehiculo() == 1 || vh.getIdClaseVehiculo() == 2) {
			vehiculoNew = repo.save(vh);	
		}else{
			vehiculoNew = new Vehiculo();
		}
		return vehiculoNew;
	}
	
	public List<Vehiculo> buscarTodos() {		
		return repo.findAll();
	}

	
	
	

}
