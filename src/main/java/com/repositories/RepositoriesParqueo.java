package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Parqueo;

public interface RepositoriesParqueo extends JpaRepository<Parqueo, Long>{

	List<Parqueo> findByIdClaseVehiculo(int idClaseVehiculo);
	
	Parqueo findByPlacaVehiculo(String placaVehiculo);
}
