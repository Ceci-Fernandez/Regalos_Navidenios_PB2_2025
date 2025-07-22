package ar.edu.unlam.pb2.regalosNavidenios;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RegalonTest {

	@Test
	public void dadaUnaPersonaConCriterioInteresadoDeMinimo100000_AlVisitarlaConRegalosQueSuperanElMinimo_SeLeEntregaUno() {
	    Regalon regalon = new Regalon();
	    regalon.agregarRegalo(new Regalo("zapatillas", "Adidas", 50000, 0));
	    regalon.agregarRegalo(new Regalo("celular", "Apple", 650000, 0));
	    regalon.agregarRegalo(new Regalo("juguete", "PlayMovil", 35000, 5));

	    Interesado criterio = new Interesado(100000);
	    Persona persona = new Persona("1234567", criterio);

	    regalon.visitar(persona);

	    List<Regalo> regalosPersona = persona.getRegalos();
	    List<Regalo> regalosEnBolsa = regalon.getBolsa();

	    assertEquals(1, regalosPersona.size());
	    assertEquals("celular", regalosPersona.get(0).getNombre());
	    assertEquals(2, regalosEnBolsa.size());
	    assertFalse(regalosEnBolsa.contains(regalosPersona.get(0)));
	}
	
	
	@Test
	public void dadaUnaPersonaConCriterioInteresadoDeMinimo900000_AlVisitarlaSinRegalosQueSuperanElMinimo_SeLeEntregaUnVoucher() {
	    Regalon regalon = new Regalon();
	    regalon.agregarRegalo(new Regalo("zapatillas", "Adidas", 50000, 0));
	    regalon.agregarRegalo(new Regalo("celular", "Apple", 650000, 0));
	    regalon.agregarRegalo(new Regalo("juguete", "PlayMovil", 35000, 5));

	    Interesado criterio = new Interesado(900000);
	    Persona persona = new Persona("45678910", criterio);

	    regalon.visitar(persona);

	    List<Regalo> regalosPersona = persona.getRegalos();
	    List<Regalo> regalosEnBolsa = regalon.getBolsa();

	    assertEquals(1, regalosPersona.size());
	    Regalo regalo = regalosPersona.get(0);
	    assertEquals("voucher", regalo.getNombre());
	    assertEquals("Papapp", regalo.getMarca());
	    assertEquals(20000, regalo.getValor(), 0);
	    assertEquals(0, regalo.getAntiguedad());

	    assertEquals(3, regalosEnBolsa.size()); 
	}
	@Test
	public void noSeAgregaRegaloConValorONegativo() {
	    Regalon regalon = new Regalon();
	    Regalo regaloValido = new Regalo("libro", "EditorialX", 1000, 1);
	    Regalo regaloInvalido = new Regalo("mug", "MarcaY", -200, -5);

	    regalon.agregarRegalo(regaloValido);
	    regalon.agregarRegalo(regaloInvalido); 

	    assertEquals(1, regalon.getBolsa().size());
	    assertTrue(regalon.getBolsa().contains(regaloValido));
	}
	@Test
	public void regalonEntregaVoucherSiNoHayRegalosEnLaBolsa() {
	    Regalon regalon = new Regalon(); 
	    Persona persona = new Persona("12345678", new Interesado(100000));

	    regalon.visitar(persona);

	    List<Regalo> recibidos = persona.getRegalos();
	    assertEquals(1, recibidos.size());

	    Regalo regalo = recibidos.get(0);
	    assertEquals("voucher", regalo.getNombre());
	    assertEquals("Papapp", regalo.getMarca());
	    assertEquals(20000, regalo.getValor(), 0);
	    assertEquals(0, regalo.getAntiguedad());
	}
	@Test
	public void queSeRegistreCorrectamenteLaEntrega() {
	    Regalon regalon = new Regalon();
	    Regalo regalo = new Regalo("juguete", "Playmovil", 35000, 5);
	    regalon.agregarRegalo(regalo);

	    Persona persona = new Persona("11111111", new Conformista());
	    regalon.visitar(persona);

	    List<Entrega> entregas = regalon.getEntregas();

	    assertEquals(1, entregas.size());
	    assertEquals(persona, entregas.get(0).getPersona());
	    assertEquals(regalo, entregas.get(0).getRegalo());
	}




}
