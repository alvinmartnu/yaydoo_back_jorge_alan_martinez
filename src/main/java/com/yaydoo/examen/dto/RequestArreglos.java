package com.yaydoo.examen.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author Alan Martinez
 * Modelo de entrada para el problema de comparacion de arreglos.
 *
 */
@Data
public class RequestArreglos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Nombre Participante uno.
	 */
	private String nameUno;
	/**
	 * Nombre Participante dos.
	 */
	private String nameDos;
	/**
	 * Lista Participante uno.
	 */
	private List<Integer> lstUno;
	/**
	 * Lista Participante dos.
	 */
	private List<Integer> lstDos;

}
