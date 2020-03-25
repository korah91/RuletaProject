package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApuestaDocenaTest {
	
	ApuestaDocena ad1, ad2;
	ListaApuestas lista;
	
	@Before
	public void setUp() throws Exception {
		ad1 = new ApuestaDocena(15, "primera docena");
		ad2 = new ApuestaDocena(15, "segunda docena");
		lista = new ListaApuestas();
	}

	@After
	public void tearDown() throws Exception {
		ad1 = null;
		ad2 = null;
		lista = null;
	}

	@Test
	public void testGetPremio() {
		
		Numero primera = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero segunda = new Numero("rojo",1,"impar","segunda docena","primera mitad","huerfanos");
		Numero tercera = new Numero("rojo",1,"impar","tercera docena","primera mitad","huerfanos");

		lista.anadirApuesta("Docena", "primera docena", 10); 
		assertEquals(lista.getPremio(primera), 30, 0.1);	  //Apuesta a primera y gana
		assertEquals(lista.getPremio(segunda), 0, 0.1);  	  //Apuesta a primera y no gana
		assertEquals(lista.getPremio(tercera), 0, 0.1); 	  //Apuesta a primera y no gana
		
		lista.resetear();
		
		lista.anadirApuesta("Docena", "segunda docena", 10);  
		assertEquals(lista.getPremio(primera), 0, 0.1);       //Apuesta a segunda y no gana
		assertEquals(lista.getPremio(segunda), 30, 0.1);      //Apuesta a segunda y gana
		assertEquals(lista.getPremio(tercera), 0, 0.1);		  //Apuesta a segunda y no gana

		lista.resetear();
		
		lista.anadirApuesta("Docena", "tercera docena", 10);  
		assertEquals(lista.getPremio(primera), 0, 0.1);	      //Apuesta a tercera y no gana
		assertEquals(lista.getPremio(segunda), 0, 0.1);	      //Apuesta a tercera y no gana
		assertEquals(lista.getPremio(tercera), 30, 0.1);	  //Apuesta a tercera y gana		
	}

	@Test
	public void testApuestaDocena() {
		assertNotNull(ad1);
		assertNotNull(ad2);
	}

}
