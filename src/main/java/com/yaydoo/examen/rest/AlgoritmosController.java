package com.yaydoo.examen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaydoo.examen.dto.RequestArreglos;
import com.yaydoo.examen.dto.RequestCadena;
import com.yaydoo.examen.dto.ResponseArreglos;
import com.yaydoo.examen.service.AlgoritmoService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AlgoritmosController {
	
	@Autowired
	private AlgoritmoService service;
	
	@Operation(summary = "Regresa la puntuacion y el nombre del ganador.")
	@RequestMapping(value = "/arreglos", produces = "application/json", method = { RequestMethod.POST })
	public ResponseEntity<ResponseArreglos> comparaArreglos(@RequestBody RequestArreglos request) {
		
		ResponseArreglos result = service.comparaArreglos(request);		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@Operation(summary = "Regresa un json con el numero de veces que se repitio una palabra.")
	@RequestMapping(value = "/cadena", produces = "application/json", method = { RequestMethod.POST })
	public ResponseEntity<String> cuentaPalabras(@RequestBody RequestCadena request) {
		
		String result = service.cuentaPalabras(request);		
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


}
