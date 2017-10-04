package com.application;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Vehiculo;
import com.services.VehiculoService;

@RestController
@RequestMapping("/vehiculoParq")
public class VehiculoController {
	
	@Autowired
	VehiculoService serv;
		

	@RequestMapping(value = "/createVehiculo" , method = RequestMethod.POST)
    public Vehiculo vehiculo (Vehiculo vh){
		Vehiculo vehiculoNew;
		if (vh.getIdClaseVehiculo() == 1 || vh.getIdClaseVehiculo() == 2) {
			vehiculoNew = serv.guardarVehiculo(vh);
		}else{
			vehiculoNew = new Vehiculo();
		}
		return vehiculoNew;
    }	
	
}
