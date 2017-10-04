package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Parqueo;
import com.services.ParqueoService;

@RestController
@RequestMapping("/ParqueoParq")
public class ParqueoController {
	
	@Autowired
	ParqueoService servParqueo;
	
	@RequestMapping(value = "/createParqueo" , method = RequestMethod.POST)
    public Parqueo insertParqueo (Parqueo pq){	
		return servParqueo.guardarParqueo(pq);
	}
}
