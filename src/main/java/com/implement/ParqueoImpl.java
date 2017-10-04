package com.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entities.Parqueo;
import com.repositories.RepositoriesParqueo;
import com.services.ParqueoService;

public class ParqueoImpl implements ParqueoService{

	@Autowired
	private RepositoriesParqueo repoParqueo;
	
	public Parqueo guardarParqueo(Parqueo pq) {		
		return repoParqueo.save(pq);		
	}

	public List<Parqueo> buscarTodos() {
		return repoParqueo.findAll();
	}
}
