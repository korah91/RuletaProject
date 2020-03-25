package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApuestaMitadTest {


	ApuestaMitad am1, am2;
	ListaApuestas lista;
	@Before
	public void setUp() throws Exception {
		am1 = new ApuestaMitad(15, "primera mitad");
		am2 = new ApuestaMitad(15, "segunda mitad");
		lista = new ListaApuestas();
	}

	@After
	public void tearDown() throws Exception {
		am1 = null;
		am2 = null;
		lista = null;
	}

	@Test
	public void testGetPremio() {
		
		Numero mitad1 = new Numero("negro",2,"impar","segunda docena","primera mitad","huerfanos");
		Numero mitad2 = new Numero("rojo",1,"impar","primera docena","segunda mitad","vecinos");
		
		lista.anadirApuesta("Mitad", "primera mitad", 10); 
		
		assertEquals(lista.getPremio(mitad1), 20, 0.1);	 	  //Apuesta a la primera mitad y gana
		assertEquals(lista.getPremio(mitad2), 0, 0.1);  	  //Apuesta a la segunda mitad y no gana

		lista.resetear();
		
		lista.anadirApuesta("Mitad", "segunda mitad", 10); 
		
		assertEquals(lista.getPremio(mitad1), 0, 0.1);	 	  //Apuesta a la primera mitad y no gana
		assertEquals(lista.getPremio(mitad2), 20, 0.1);  	  //Apuesta a la segunda mitad y gana
	}

	@Test
	public void testApuestaMitad() {
		assertNotNull(am1);
		assertNotNull(am2);
		
	}

}
