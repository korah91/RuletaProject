package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApuestaFamiliaTest {

	ApuestaFamilia af1, af2, af3;
	ListaApuestas lista;
	
	@Before
	public void setUp() throws Exception {
		af1 = new ApuestaFamilia(15, "huerfanos");
		af2 = new ApuestaFamilia(15, "vecinos");
		af3 = new ApuestaFamilia(15, "tercios");

		lista = new ListaApuestas();
	}

	@After
	public void tearDown() throws Exception {
		af1 = null;
		af2 = null;
		af3 = null;
		lista = null;
	}

	@Test
	public void testGetPremio() {
		
		Numero huerfano = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero vecino = new Numero("rojo",1,"impar","primera docena","primera mitad","vecinos");
		Numero tercio = new Numero("rojo",1,"impar","primera docena","primera mitad","tercios");

		lista.anadirApuesta("Familia", "huerfanos", 10); 

		assertEquals(lista.getPremio(huerfano), 45, 0.1);	  //Apuesta a huerfanos y gana
		assertEquals(lista.getPremio(vecino), 0, 0.1);  	  //Apuesta a vecinos y no gana
		assertEquals(lista.getPremio(tercio), 0, 0.1); 	  	  //Apuesta a tercios y no gana
		
		lista.resetear();
		
		lista.anadirApuesta("Familia", "vecinos", 10); 
		assertEquals(lista.getPremio(huerfano), 0, 0.1);	  //Apuesta a huerfanos y no gana
		assertEquals(lista.getPremio(vecino), 21.17, 1);  	  //Apuesta a vecinos y gana
		assertEquals(lista.getPremio(tercio), 0, 0.1); 	  	  //Apuesta a tercios y no gana
		
		lista.resetear();
		
		lista.anadirApuesta("Familia", "tercios", 10); 
		assertEquals(lista.getPremio(huerfano), 0, 1);		  //Apuesta a huerfanos y no gana
		assertEquals(lista.getPremio(vecino), 0, 0.1);  	  //Apuesta a vecinos y no gana
		assertEquals(lista.getPremio(tercio), 30, 1); 	  	  //Apuesta a tercios y gana
	}

	@Test
	public void testApuestaFamilia() {
		assertNotNull(af1);
		assertNotNull(af2);
		assertNotNull(af3);
	}

}
