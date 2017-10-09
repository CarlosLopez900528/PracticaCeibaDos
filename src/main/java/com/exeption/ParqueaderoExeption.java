package com.exeption;

public class ParqueaderoExeption extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public ParqueaderoExeption(String message) {
		super(message);
	}
}
