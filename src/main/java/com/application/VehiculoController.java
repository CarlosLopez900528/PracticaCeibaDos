package com.application;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Vehiculo;
import com.services.ParqueaderoService;

@RestController
@RequestMapping("/vehiculoParq")
public class VehiculoController {
	
	@Autowired
	ParqueaderoService serv;
		

	@RequestMapping(value = "/createVehiculo" , method = RequestMethod.POST)
    public Vehiculo vehiculo (Vehiculo vh){
    	return serv.guardarVehiculo(vh);
    }	
}
