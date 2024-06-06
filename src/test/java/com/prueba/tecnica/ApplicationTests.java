package com.prueba.tecnica;

import com.intuit.karate.junit5.Karate;

class ApplicationTests {
	   
	   @Karate.Test
	    Karate testRuta() {
	        return Karate.run("classpath:Karate/ruta.feature").relativeTo(getClass());
	    }

}
