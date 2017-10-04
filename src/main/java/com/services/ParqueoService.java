package com.services;

import java.util.List;

import com.entities.Parqueo;

public interface ParqueoService {

public Parqueo guardarParqueo(Parqueo parqueo);
	
	public List<Parqueo> buscarTodos();
}
