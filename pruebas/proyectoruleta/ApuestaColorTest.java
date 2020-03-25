package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApuestaColorTest {
	
	ApuestaColor ac;
	ListaApuestas lista;

	@Before
	public void setUp() throws Exception {
		ac = new ApuestaColor(15, "rojo");
		lista = new ListaApuestas();
	}

	@After
	public void tearDown() throws Exception {
		ac = null;
	}

	@Test
	public void testGetPremio() {
		
		Numero rojo = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero negro = new Numero("negro",1,"impar","primera docena","primera mitad","huerfanos");

		lista.anadirApuesta("Color", "rojo", 15); 
		assertEquals(lista.getPremio(rojo), 30, 0.1);
		assertEquals(lista.getPremio(negro), 0, 0.1);
		
		lista.resetear();
		
		lista.anadirApuesta("Color", "negro", 15); 
		assertEquals(lista.getPremio(rojo), 0, 0.1);
		assertEquals(lista.getPremio(negro), 30, 0.1);
	}

	@Test
	public void testApuestaColor() {
		assertNotNull(ac);
	}

}
