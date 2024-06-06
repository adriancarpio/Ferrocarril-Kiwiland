# Kiwiland Railroad

## Descripción

El proyecto Kiwiland Railroad es una aplicación que ayuda a calcular la distancia de rutas específicas, contar el número de diferentes rutas entre dos ciudades, y encontrar la ruta más corta entre dos ciudades en un grafo dirigido. Este proyecto utiliza Spring Boot para la lógica del servicio y Karate para pruebas automatizadas.

## Estructura del Proyecto


## Requisitos Previos

- Java 17
- Maven 3.9.6

## Configuración del Proyecto

1. Clona el repositorio:
    [git clone https://github.com/tu-usuario/tu-repositorio.git](https://github.com/adriancarpio/prueba-netby.git)
    cd tu-repositorio

2. Compila el proyecto usando Maven:
    mvn clean install

## Ejecución de Pruebas

Este proyecto utiliza Karate para pruebas automatizadas. Las pruebas están definidas en el archivo `cliente.feature`.

1. Para ejecutar las pruebas, simplemente usa Maven:
    mvn test

## Descripción del Código

### EjecutorService.java

Esta clase implementa la lógica para manejar las rutas y cálculos necesarios:

- `agregarRuta(String de, String a, int distancia)`: Agrega una ruta entre dos ciudades con una distancia específica.
- `obtenerRutaDistancia(String ruta)`: Calcula la distancia de una ruta específica.
- `contarViajeParadaMaxima(String comenzar, String fin, int paradaMaxima)`: Cuenta el número de viajes con un máximo de paradas.
- `contarViajeParadaExacta(String comenzar, String fin, int paradaExacta)`: Cuenta el número de viajes con un número exacto de paradas.
- `contaViaje(String comenzar, String fin, int seDetiene, int limite, boolean paradaMaxima)`: Método interno para contar viajes.
- `rutaMasCorta(String comenzar, String fin)`: Encuentra la ruta más corta entre dos ciudades.
- `contarRutaDistanciaMaxima(String comenzar, String fin, int distanciaMaxima)`: Cuenta el número de rutas con una distancia máxima.
- `contarRutaDistancia(String comenzar, String fin, int distanciaActual, int distanciaMaxima)`: Método interno para contar rutas por distancia.
- `encontrarCicloCorto(String comenzar)`: Encuentra el ciclo más corto comenzando y terminando en la misma ciudad.

### RouteNode.java

Clase de datos que representa un nodo de ruta en el grafo, con una ciudad (`town`) y una distancia (`distance`).

### EjecutorRepo.java

Interfaz que define los métodos que deben ser implementados por `EjecutorService`.

### KarateTests.java

Clase de prueba que utiliza Karate para ejecutar pruebas definidas en `cliente.feature`.

### ruta.feature

Archivo de Karate que define los escenarios de prueba para las rutas y los cálculos del servicio.
