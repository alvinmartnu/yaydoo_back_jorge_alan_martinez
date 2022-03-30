package com.yaydoo.examen.service.imp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.yaydoo.examen.dto.RequestArreglos;
import com.yaydoo.examen.dto.RequestCadena;
import com.yaydoo.examen.dto.ResponseArreglos;
import com.yaydoo.examen.service.AlgoritmoService;

@Service
public class AlgoritmoServiceImp implements AlgoritmoService {

	@Override
	public ResponseArreglos comparaArreglos(RequestArreglos request) {
		ResponseArreglos result = new ResponseArreglos();
		int jPunosUno = 0;
		int jPunosDos = 0;
		List<Integer> jUno = request.getLstUno();
		List<Integer> jDos = request.getLstDos();

		for (int i = 0; i < jUno.size(); i++) {
			
			if (jUno.get(i) > jDos.get(i)) {
				jPunosUno++;
				continue;
			} else if (jUno.get(i) < jDos.get(i)) {
				jPunosDos++;
				continue;
			} else if (jUno.get(i) == jDos.get(i)) {
				continue;
			}
		}

		result.setPuntuacion(
				request.getNameUno() + ": " + jPunosUno + " -- " + request.getNameDos() + ": " + jPunosDos);

		if (jPunosUno > jPunosDos) {
			result.setGanador(request.getNameUno());
		} else if (jPunosUno < jPunosDos) {
			result.setGanador(request.getNameDos());
		} else {
			result.setGanador("Empate");
		}

		return result;
	}

	@Override
	public String cuentaPalabras(RequestCadena request) {

		String cadena = request.getTexto().replaceAll("[^a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]", "");

		List<String> itemCompare = Arrays.asList(cadena.split(" "));

		Map<String, Long> duplicateCount = itemCompare.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		JSONObject result = new JSONObject(duplicateCount);

		return result.toString();
	}

}
