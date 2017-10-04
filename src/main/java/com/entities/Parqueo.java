package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Parqueo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idParqueo;
	
	@Column
	private int idClaseVehiculo;
	
	@Column
	private String placaVehiculo;

}
