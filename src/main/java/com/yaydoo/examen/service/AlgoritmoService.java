package com.yaydoo.examen.service;

import com.yaydoo.examen.dto.RequestArreglos;
import com.yaydoo.examen.dto.RequestCadena;
import com.yaydoo.examen.dto.ResponseArreglos;

/**
 * @author Alan Martinez
 *
 */
public interface AlgoritmoService {
	
	/**
	 * Método que ocntiene la logica del problema 1.
	 * @param Parametros de entrada
	 * @return response.
	 */
	ResponseArreglos comparaArreglos(RequestArreglos request);

	/**
	 * Método que cuenta las palabras en un texto.
	 * @param Parametros de entrada
	 * @return response.
	 */
	String cuentaPalabras(RequestCadena request);

}
