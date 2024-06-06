package com.prueba.tecnica.repo;

public interface EjecutorRepo {
	
	void agregarRuta(String de, String a, int distancia);

    String obtenerRutaDistancia(String ruta);

    int contarViajeParadaMaxima(String comenzar, String fin, int paradaMaxima);

    int contarViajeParadaExacta(String comenzar, String fin, int paradaExacta);

    int contaViaje(String comenzar, String fin, int seDetiene, int limite, boolean paradaMaxima);

    int rutaMasCorta(String comenzar, String fin);

    int contarRutaDistanciaMaxima(String comenzar, String fin, int distanciaMaxima);

    int contarRutaDistancia(String comenzar, String fin, int distanciaActual, int distanciaMaxima);
    
    int encontrarCicloCorto(String comenzar);
}
