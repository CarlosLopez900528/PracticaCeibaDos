package com.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Parqueo;
import com.repositories.RepositoriesParqueo;
import com.services.ParqueoService;

@Service
public class ParqueoImpl implements ParqueoService{
	
	int cantCarros;
	int cantMotos;
	boolean vehiculoValido;
	boolean puedeCrearCarro;
	boolean puedeCrearMoto;
	boolean diaHabilPlaca;

	@Autowired
	private RepositoriesParqueo repoParqueo;
	
	public Parqueo guardarParqueo(Parqueo pq) {
		Parqueo parq;
		if (validaClaseVehiculo(pq) && validaCantCarros(pq)) {
			parq = repoParqueo.save(pq);	
		}else if(validaClaseVehiculo(pq) && validaCantMotos(pq)){
			parq = repoParqueo.save(pq);
		}else{
			parq = new Parqueo();
		}
		return parq;
	}
	
	public boolean validaClaseVehiculo(Parqueo pq) {
		
		if (pq.getIdClaseVehiculo() == 1 || pq.getIdClaseVehiculo() == 2) {
			vehiculoValido = true;
		}else {
			vehiculoValido = false;
		}
		return vehiculoValido;
	}
	
	public boolean validaCantCarros(Parqueo pq) {	
		List<Parqueo> listParqueoCa = findByIdClaseVehiculo(1);
		cantCarros = listParqueoCa.size();
		if (pq.getIdClaseVehiculo() == 1 && cantCarros < 20) {
			puedeCrearCarro = true;
			cantCarros = cantCarros + 1;
		}else {
			puedeCrearCarro = false;
		}
		return puedeCrearCarro;
	}
	
	public boolean validaCantMotos(Parqueo pq) {
		List<Parqueo> listParqueoMo = findByIdClaseVehiculo(2);
		cantMotos = listParqueoMo.size();
		if (pq.getIdClaseVehiculo() == 2 && cantMotos < 10) {
			puedeCrearMoto = true;
			cantMotos = cantMotos + 1;
		}else {
			puedeCrearMoto = false;
		}
		return puedeCrearMoto;
	}
	
	public boolean validaDiaHabil(Parqueo pq) {
		
		if (pq.getPlacaVehiculo().substring(0).equals("A")) {
			if (pq.getFechaParqueo().getDay() == 0 || pq.getFechaParqueo().getDay() == 1) {
				diaHabilPlaca = true;
			}else{
				diaHabilPlaca = false;
			}
		}else{
			diaHabilPlaca = false;
		}
		return diaHabilPlaca;
	}

	public List<Parqueo> buscarTodos() {
		return repoParqueo.findAll();
	}

	public List<Parqueo> findByIdClaseVehiculo(int idClaseVehiculo) {
		
		return repoParqueo.findByIdClaseVehiculo(idClaseVehiculo);
	}
}
