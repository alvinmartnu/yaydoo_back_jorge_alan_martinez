package com.yaydoo.examen.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Alan Martinez.
 * Modelo de entrada para el problema 2 de algoritmos.
 *
 */
@Data
public class RequestCadena implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * Texto donde se contaran las palabras.
	 */
	private String texto;

}
