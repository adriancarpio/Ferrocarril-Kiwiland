package com.prueba.tecnica.task;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.service.EjecutorService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component
@RequiredArgsConstructor
public class Ejecutor {
	
	private final EjecutorService ejecutorService;

	private static Logger LOGGER = LogManager.getLogger(Ejecutor.class);

	@PostConstruct
	public void procesarMain() {
		
		ejecutorService.agregarRuta("A", "B", 5);
		ejecutorService.agregarRuta("B", "C", 4);
		ejecutorService.agregarRuta("C", "D", 8);
		ejecutorService.agregarRuta("D", "C", 8);
		ejecutorService.agregarRuta("D", "E", 6);
		ejecutorService.agregarRuta("A", "D", 5);
		ejecutorService.agregarRuta("C", "E", 2);
		ejecutorService.agregarRuta("E", "B", 3);
		ejecutorService.agregarRuta("A", "E", 7);
		
		LOGGER.info("Salida #1: " + ejecutorService.obtenerRutaDistancia("A-B-C"));
		LOGGER.info("Salida #2: " + ejecutorService.obtenerRutaDistancia("A-D"));
		LOGGER.info("Salida #3: " + ejecutorService.obtenerRutaDistancia("A-D-C"));
		LOGGER.info("Salida #4: " + ejecutorService.obtenerRutaDistancia("A-E-B-C-D"));
		LOGGER.info("Salida #5: " + ejecutorService.obtenerRutaDistancia("A-E-D"));
		LOGGER.info("Salida #6: " + ejecutorService.contarViajeParadaMaxima("C", "C", 3));
		LOGGER.info("Salida #7: " + ejecutorService.contarViajeParadaExacta("A", "C", 4));
		LOGGER.info("Salida #8: " + ejecutorService.rutaMasCorta("A", "C"));
		LOGGER.info("Salida #9: " + ejecutorService.contarRutaDistanciaMaxima("C", "C", 30));
	}

}
