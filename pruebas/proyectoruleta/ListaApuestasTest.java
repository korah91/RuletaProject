package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaApuestasTest {
	ListaApuestas lista;

	@Before
	public void setUp() throws Exception {
		lista = new ListaApuestas();
	}

	@After
	public void tearDown() throws Exception {
		lista.resetear();
	}

	@Test
	public void testListaApuestas() {
		assertNotNull(lista);
	}

	@Test
	public void testResetearAnadirApuesta() {
		lista.anadirApuesta("Familia", "tercios", 100);
		assertEquals(lista.cantidad(), 1);
		lista.anadirApuesta("Color", "Rojo", 50);
		assertEquals(lista.cantidad(), 2);
		lista.anadirApuesta("Numero", "0", 200);
		assertEquals(lista.cantidad(),3);
		lista.resetear();
		assertEquals(lista.cantidad(), 0);
	}


	@Test
	public void testGetPremio() {
		Numero num1 = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero num15 = new Numero("negro",15,"impar","segunda docena","primera mitad","vecinos");
		lista.anadirApuesta("Color", "rojo", 100);
		assertEquals(lista.getPremio(num1), 200, 0.1); //Apuesta a rojo y gana
		lista.resetear();
		lista.anadirApuesta("Familia", "tercios", 100);
		assertEquals(lista.getPremio(num1), 0, 0.1); //Apuesta a tercios y no gana
		lista.resetear();
		lista.anadirApuesta("Numero", "1", 100);
		lista.anadirApuesta("Docena", "Segunda docena", 50);
		assertEquals(lista.getPremio(num1), 3600, 0.1); //Apuesta a dos cosas y solo gana una 
		assertEquals(lista.getPremio(num15), 150, 0.1); //Apuesta a dos cosas y solo gana una 
		lista.anadirApuesta("Color", "Rojo", 10);
		assertEquals(lista.getPremio(num1), 3620, 0.1); //Apuesta a tres cosas y gana dos 
		
	}

}
