package com.application;



import java.util.List;

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
    public Vehiculo insertVehiculo (Vehiculo vh){
		return serv.guardarVehiculo(vh);
    }	
	
	@RequestMapping(value = "/listarVehiculo" , method = RequestMethod.POST)
    public List<Vehiculo> listarVehiculo (Vehiculo vh){	
		return serv.buscarTodos();
    }
	
}
