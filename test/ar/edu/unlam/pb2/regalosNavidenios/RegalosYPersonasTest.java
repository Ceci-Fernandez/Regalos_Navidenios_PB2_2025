package ar.edu.unlam.pb2.regalosNavidenios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RegalosYPersonasTest {

	@Test
	public void dadaUnaPersonaConCriteroConformista_leGustaCualquierRegalo() {
	    Criterio conformista = new Conformista();
	    Persona persona = new Persona("37217330", conformista);
	    Regalo regalo = new Regalo("Zapatillas", "Nike", 100000, 0);

	    assertTrue(persona.getCriterio().leGusta(regalo));
	}
	@Test
	public void dadaUnaPersonaConCriteroInteresado_leGustaUnRegaloQueSuperaUnValorMinimo() {
	    Interesado criterio = new Interesado(100000);
	    Persona persona = new Persona("37217330", criterio);

	    Regalo regaloBarato = new Regalo("Gorra", "Topper", 50000, 0);
	    Regalo regaloCaro = new Regalo("Zapatillas", "Nike", 150000, 0);

	    assertFalse(persona.getCriterio().leGusta(regaloBarato));
	    assertTrue(persona.getCriterio().leGusta(regaloCaro));
	}
	@Test
	public void dadaUnaPersonaConCriteroMarquero_leGustaUnRegaloDeUnaMarcaDeSuPreferencia() {
	    List<String> marcas = new ArrayList<>();
	    marcas.add("Apple");
	    marcas.add("Nike");

	    Marquero criterio = new Marquero(marcas);
	    Persona persona = new Persona("37217330", criterio);

	    Regalo regaloAceptado = new Regalo("Celular", "Apple", 650000, 0);
	    Regalo regaloRechazado = new Regalo("Juguete", "PlayMovil", 35000, 5);

	    assertTrue(persona.getCriterio().leGusta(regaloAceptado));
	    assertFalse(persona.getCriterio().leGusta(regaloRechazado));
	}
	@Test
	public void dadaUnaPersonaConCombinado_leGustaUnRegaloDeUnaMarcaDeSuPreferenciaYQueSuperaUnValorMinimo() {
	    Interesado interesado = new Interesado(100000);
	    
	    List<String> marcas = new ArrayList<>();
	    marcas.add("Nike");
	    Marquero marquero = new Marquero(marcas);

	    List<Criterio> criterios = new ArrayList<>();
	    criterios.add(interesado);
	    criterios.add(marquero);
	    Combinado combinado = new Combinado(criterios);

	    Persona persona = new Persona("37217330", combinado);

	    Regalo regaloCumpleTodo = new Regalo("Zapatillas", "Nike", 150000, 0);
	    Regalo regaloBarato = new Regalo("Zapatillas", "Nike", 50000, 0);
	    Regalo regaloOtraMarca = new Regalo("Zapatillas", "Adidas", 150000, 0);

	    assertTrue(persona.getCriterio().leGusta(regaloCumpleTodo));
	    assertFalse(persona.getCriterio().leGusta(regaloBarato));
	    assertFalse(persona.getCriterio().leGusta(regaloOtraMarca));
	}
	@Test
	public void dadaUnaPersonaConCriterioAntiguarios_leGustaUnRegaloConMasDe20Anios() {
	    Anticuarios criterio = new Anticuarios();
	    Persona persona = new Persona("37217330", criterio);

	    Regalo regaloViejo = new Regalo("Cámara", "Kodak", 30000, 25);
	    Regalo regaloNuevo = new Regalo("Celular", "Samsung", 30000, 5);

	    assertTrue(persona.getCriterio().leGusta(regaloViejo));
	    assertFalse(persona.getCriterio().leGusta(regaloNuevo));
	}
	@Test
	public void cambiarCriterioDePersonaModificaElResultadoDeLeGusta() {
	    Persona persona = new Persona("800", new Conformista());
	    Regalo regalo = new Regalo("remera", "MarcaX", 100, 0);

	    assertTrue(persona.getCriterio().leGusta(regalo)); 

	    persona.setCriterio(new Interesado(100000));
	    assertFalse(persona.getCriterio().leGusta(regalo)); 
	}




	
	
	

}
