package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApuestaTest {

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
	public void testApuesta() {
		assertNotNull(ac);
		
	}

	@Test
	public void testGetPremio() {
		lista.anadirApuesta("Color", "rojo", 15);
		lista.getPremio(1);
	}

}
