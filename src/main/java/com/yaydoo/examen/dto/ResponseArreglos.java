package com.yaydoo.examen.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Alan Martinez
 * Modelo de salida para el problema de comparacion de arreglos.
 *
 */
@Data
public class ResponseArreglos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * resultado de la puntuacion.
	 */
	private String puntuacion;
	/**
	 * nombre del ganador.
	 */
	private String ganador;
	

}
