package com.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Parqueo;
import com.entities.Vehiculo;
import com.repositories.RepositoriesParqueo;
import com.services.ParqueoService;

@Service
public class ParqueoImpl implements ParqueoService{

	@Autowired
	private RepositoriesParqueo repoParqueo;
	
	public Parqueo guardarParqueo(Parqueo pq) {
		Parqueo parq;
		if (pq.getIdClaseVehiculo() == 1 || pq.getIdClaseVehiculo() == 2) {
			parq = repoParqueo.save(pq);	
		}else{
			parq = new Parqueo();
		}
		return parq;
	}

	public List<Parqueo> buscarTodos() {
		return repoParqueo.findAll();
	}
}
