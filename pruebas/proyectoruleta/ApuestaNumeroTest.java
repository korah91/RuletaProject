package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApuestaNumeroTest {

	Numero n;
	ListaApuestas lista;
	
	@Before
	public void setUp() throws Exception {
		n = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		lista = new ListaApuestas();
	}

	@After
	public void tearDown() throws Exception {
		n = null;
		lista = null;
	}

	@Test
	public void testGetPremio() {
		
		Numero n1 = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero n2 = new Numero("rojo",2,"impar","primera docena","primera mitad","vecinos");
		
		lista.anadirApuesta("Numero", "1", 10); 
		
		assertEquals(lista.getPremio(n1), 360, 0.1);	  //Apuesta al 1 y gana
		assertEquals(lista.getPremio(n2), 0, 0.1);  	  //Apuesta al 1 y no gana

		lista.resetear();
		
		lista.anadirApuesta("Numero", "2", 10); 
		
		assertEquals(lista.getPremio(n1), 0, 0.1);	 	  //Apuesta al 1 y no gana
		assertEquals(lista.getPremio(n2), 360, 0.1);  	  //Apuesta al 1 y gana
	}

	@Test
	public void testApuestaNumero() {
		assertNotNull(n);
	}

}
