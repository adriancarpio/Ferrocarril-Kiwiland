package com.prueba.tecnica.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import com.prueba.tecnica.dto.RouteNode;
import com.prueba.tecnica.repo.EjecutorRepo;

@Service
public class EjecutorService implements EjecutorRepo {

	private final Map<String, Map<String, Integer>> grafico = new HashMap<>();

	@Override
	public void agregarRuta(String de, String a, int distancia) {
		grafico.computeIfAbsent(de, k -> new HashMap<>()).put(a, distancia);
	}

	@Override
	public String obtenerRutaDistancia(String ruta) {
		String[] arrPueblos = ruta.split("-");
		int distance = 0;
		for (int i = 0; i < arrPueblos.length - 1; i++) {
			String de = arrPueblos[i];
			String a = arrPueblos[i + 1];
			if (grafico.containsKey(de) && grafico.get(de).containsKey(a)) {
				distance += grafico.get(de).get(a);
			} else {
				return "NO HAY TAL RUTA";
			}
		}
		return String.valueOf(distance);
	}

	@Override
	public int contarViajeParadaMaxima(String comenzar, String fin, int paradaMaxima) {
		return contaViaje(comenzar, fin, 0, paradaMaxima, true);
	}

	@Override
	public int contarViajeParadaExacta(String comenzar, String fin, int paradaExacta) {
		return contaViaje(comenzar, fin, 0, paradaExacta, false);
	}

	@Override
	public int contaViaje(String comenzar, String fin, int seDetiene, int limite, boolean paradaMaxima) {
		if (seDetiene > limite) {
			return 0;
		}
		int count = 0;
		if (seDetiene > 0 && comenzar.equals(fin)) {
			if (paradaMaxima || seDetiene == limite) {
				count++;
			}
		}
		if (grafico.containsKey(comenzar)) {
			for (String next : grafico.get(comenzar).keySet()) {
				count += contaViaje(next, fin, seDetiene + 1, limite, paradaMaxima);
			}
		}
		return count;
	}

	@Override
	public int rutaMasCorta(String comenzar, String fin) {

		/*if (comenzar.equals(fin)) {
			return encontrarCicloCorto(comenzar);
		}*/

		PriorityQueue<RouteNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getDistance()));
		queue.add(new RouteNode(comenzar, 0));
		Map<String, Integer> distances = new HashMap<>();
		distances.put(comenzar, 0);

		while (!queue.isEmpty()) {
			RouteNode current = queue.poll();
			if (current.getTown().equals(fin) && current.getDistance() > 0) {
				return current.getDistance();
			}
			if (grafico.containsKey(current.getTown())) {
				for (Map.Entry<String, Integer> neighbor : grafico.get(current.getTown()).entrySet()) {
					int newDist = current.getDistance() + neighbor.getValue();
					if (newDist < distances.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
						distances.put(neighbor.getKey(), newDist);
						queue.add(new RouteNode(neighbor.getKey(), newDist));
					}
				}
			}
		}
		return -1;
	}

	@Override
	public int contarRutaDistanciaMaxima(String comenzar, String fin, int distanciaMaxima) {
		return contarRutaDistancia(comenzar, fin, 0, distanciaMaxima);
	}

	@Override
	public int contarRutaDistancia(String comenzar, String fin, int distanciaActual, int distanciaMaxima) {
		if (distanciaActual >= distanciaMaxima) {
			return 0;
		}
		int count = 0;
		if (distanciaActual > 0 && comenzar.equals(fin)) {
			count++;
		}
		if (grafico.containsKey(comenzar)) {
			for (Map.Entry<String, Integer> neighbor : grafico.get(comenzar).entrySet()) {
				count += contarRutaDistancia(neighbor.getKey(), fin, distanciaActual + neighbor.getValue(),
						distanciaMaxima);
			}
		}
		return count;
	}

	@Override
	public int encontrarCicloCorto(String comenzar) {
		PriorityQueue<RouteNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getDistance()));
		queue.add(new RouteNode(comenzar, 0));
		int cicloMasCorto = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			RouteNode actual = queue.poll();
			if (actual.getTown().equals(comenzar) && actual.getDistance() > 0) {
				cicloMasCorto = Math.min(cicloMasCorto, actual.getDistance());
			}
			if (grafico.containsKey(actual.getTown())) {
				for (Map.Entry<String, Integer> neighbor : grafico.get(actual.getTown()).entrySet()) {
					int newDist = actual.getDistance() + neighbor.getValue();
					queue.add(new RouteNode(neighbor.getKey(), newDist));
				}
			}
		}
		return cicloMasCorto;
	}

}
