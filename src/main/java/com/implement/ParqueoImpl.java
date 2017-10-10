package com.implement;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Parqueo;
import com.exeption.ParqueaderoExeption;
import com.repositories.RepositoriesParqueo;
import com.services.ParqueoService;

@Service
public class ParqueoImpl implements ParqueoService{
	
	static final String NO_DIA_HABIL_PLACA_A = "Hoy no se permite el ingreso a los vehiculos que inicia su placa en A";
	static final String VEHICULO_CON_PLACA_IGUAL = "El vehiculo con esta placa ya se encuentra en el parqueadero";
	static final String VEHICULO_NO_PERMITIDO = "Este vehiculo no esta permitido o se completo el cupo";
	static final int MAXIMO_CANT_CARRO = 20;
	static final int MAXIMO_CANT_MOTO = 10;
	static final int CARRO = 1;
	static final int MOTO = 2;
	int cantCarros;
	int cantMotos;
	int valorCobro;
	boolean vehiculoValido;
	boolean puedeCrearCarro;
	boolean puedeCrearMoto;
	boolean diaHabilPlaca;
	int horaSalida;
	int minutosSalida;
	int segundosSalida;

	@Autowired
	private RepositoriesParqueo repoParqueo;
	
	public Parqueo guardarParqueo(Parqueo pq) {
		Parqueo parq;
		Calendar fechaParqueo = new GregorianCalendar();
		
		Parqueo parqueoV = this.findByPlacaVehiculo(pq.getPlacaVehiculo());		

		if (parqueoV == null) {
			pq.setFechaParqueo(fechaParqueo);
			if (validaDiaHabil(pq)) {
				if (validaClaseVehiculo(pq) && validaCantCarros(pq)) {
					parq = repoParqueo.save(pq);	
				}else if(validaClaseVehiculo(pq) && validaCantMotos(pq)){
					parq = repoParqueo.save(pq);
				}else{
					throw new ParqueaderoExeption(VEHICULO_NO_PERMITIDO);
				}
			}else{
				throw new ParqueaderoExeption(NO_DIA_HABIL_PLACA_A);
			}
		}else{
			throw new ParqueaderoExeption(VEHICULO_CON_PLACA_IGUAL);
		}
		
		return parq;
	}
	
	public boolean validaClaseVehiculo(Parqueo pq) {		
		if (pq.getIdClaseVehiculo() == CARRO || pq.getIdClaseVehiculo() == MOTO) {
			vehiculoValido = true;
		}else {
			vehiculoValido = false;
		}
		return vehiculoValido;
	}
	
	public boolean validaCantCarros(Parqueo pq) {	
		List<Parqueo> listParqueoCa = findByIdClaseVehiculo(1);
		cantCarros = listParqueoCa.size();
		if (pq.getIdClaseVehiculo() == CARRO && cantCarros < MAXIMO_CANT_CARRO) {
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
		if (pq.getIdClaseVehiculo() == MOTO && cantMotos < MAXIMO_CANT_MOTO) {
			puedeCrearMoto = true;
			cantMotos = cantMotos + 1;
		}else {
			puedeCrearMoto = false;
		}
		return puedeCrearMoto;
	}
	
	public boolean validaDiaHabil(Parqueo pq) {
		String letraInicial = pq.getPlacaVehiculo().substring(0,1);
		if (letraInicial.equals("A")) {
			if (pq.getFechaParqueo().get(Calendar.DAY_OF_WEEK) == 0 || pq.getFechaParqueo().get(Calendar.DAY_OF_WEEK) == 1) {
				diaHabilPlaca = true;
			}else{
				diaHabilPlaca = false;
			}
		}else{
			diaHabilPlaca = true;
		}
		return diaHabilPlaca;
	}	
	
	public float calcularCobro(String placa){

		Parqueo parqueoV = this.findByPlacaVehiculo(placa);
		
		if(parqueoV != null) {
			
			float valorAPagar;
			float tarifaDiaVehiculo;
			float tarifaHoraVehiculo;
			
			if(parqueoV.getIdClaseVehiculo() == MOTO) {
				
				tarifaDiaVehiculo = 6000;
				tarifaHoraVehiculo = 500;
			}else {
				
				tarifaDiaVehiculo = 8000;
				tarifaHoraVehiculo = 1000;
			} 
			
			Date ahora = new Date();
			
			Calendar calFechaInicial=Calendar.getInstance();
			Calendar calFechaFinal=Calendar.getInstance();
			
			calFechaInicial.setTime(parqueoV.getFechaParqueo().getTime());
			calFechaFinal.setTime(ahora);
			
			long numeroHoras=0;
			numeroHoras=(long)Math.ceil((float)(calFechaFinal.getTimeInMillis()-calFechaInicial.getTimeInMillis())/1000/60/60);

			if(numeroHoras >= 9) {
				
				long numeroDias = (long)Math.ceil(numeroHoras /24.0);
				valorAPagar = numeroDias * tarifaDiaVehiculo;
				
			}else valorAPagar = numeroHoras * tarifaHoraVehiculo;
			
			if(parqueoV.getIdClaseVehiculo() == MOTO && parqueoV.getCilindraje() > 500)
				valorAPagar +=  2000;

			return valorAPagar;
			
		}else throw new ParqueaderoExeption("El vehiculo no existe");
		
	}


	public List<Parqueo> buscarTodos() {
		return repoParqueo.findAll();
	}

	public List<Parqueo> findByIdClaseVehiculo(int idClaseVehiculo) {		
		return repoParqueo.findByIdClaseVehiculo(idClaseVehiculo);
	}

	public Parqueo findByPlacaVehiculo(String placaVehiculo) {
		return repoParqueo.findByPlacaVehiculo(placaVehiculo);
	}	
}
