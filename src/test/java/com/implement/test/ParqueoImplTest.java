package com.implement.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.entities.Parqueo;
import com.implement.ParqueoImpl;
import com.testdatabuilder.ParqueaderoTestDatabuilder;

public class ParqueoImplTest {

	@Test
	public void testGuardarParqueo() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaClaseVehiculo() {
		// arrange
		ParqueaderoTestDatabuilder parqueaderoTestDatabuilder = new ParqueaderoTestDatabuilder().
											conidClaseVehiculo(1);

		// act
		ParqueoImpl parqueoImpl = new ParqueoImpl(); 
		Parqueo parqueo = parqueaderoTestDatabuilder.build();

		// assert
		assertEquals(1, parqueo.getIdClaseVehiculo());
		assertEquals(true, parqueoImpl.validaClaseVehiculo(parqueo));
	}

	@Test
	public void testValidaCantCarros() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaCantMotos() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidaDiaHabil() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcularCobro() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIdClaseVehiculo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPlacaVehiculo() {
		fail("Not yet implemented");
	}

}
