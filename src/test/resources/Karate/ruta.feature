Feature: Test Ejecutor

  Background:
    * def EjecutorService = Java.type('com.prueba.tecnica.service.EjecutorService')
    * def Ejecutor = new EjecutorService()
    * eval Ejecutor.agregarRuta('A', 'B', 5)
    * eval Ejecutor.agregarRuta('B', 'C', 4)
    * eval Ejecutor.agregarRuta('C', 'D', 8)
    * eval Ejecutor.agregarRuta('D', 'C', 8)
    * eval Ejecutor.agregarRuta('D', 'E', 6)
    * eval Ejecutor.agregarRuta('A', 'D', 5)
    * eval Ejecutor.agregarRuta('C', 'E', 2)
    * eval Ejecutor.agregarRuta('E', 'B', 3)
    * eval Ejecutor.agregarRuta('A', 'E', 7)

  Scenario: Test distacia ruta
    * def output1 = Ejecutor.obtenerRutaDistancia('A-B-C')
    * match output1 == '9'

    * def output2 = Ejecutor.obtenerRutaDistancia('A-D')
    * match output2 == '5'

    * def output3 = Ejecutor.obtenerRutaDistancia('A-D-C')
    * match output3 == '13'

    * def output4 = Ejecutor.obtenerRutaDistancia('A-E-B-C-D')
    * match output4 == '22'

    * def output5 = Ejecutor.obtenerRutaDistancia('A-E-D')
    * match output5 == 'NO HAY TAL RUTA'

    * def output6 = Ejecutor.contarViajeParadaMaxima('C', 'C', 3)
    * match output6 == 2

    * def output7 = Ejecutor.contarViajeParadaExacta('A', 'C', 4)
    * match output7 == 3

    * def output8 = Ejecutor.rutaMasCorta('A', 'C')
    * match output8 == 9

    * def output9 = Ejecutor.contarRutaDistanciaMaxima('C', 'C', 30)
    * match output9 == 7