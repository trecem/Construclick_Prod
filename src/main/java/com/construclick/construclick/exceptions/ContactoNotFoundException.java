package com.construclick.construclick.exceptions;

public class ContactoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	//Método constructor va  recibir un parámetro para poder evaluar y lanzar la Excepción
	public ContactoNotFoundException(Long id) {
		super("El mensaje con el Id: " + id + " no existe.");
	}


}
