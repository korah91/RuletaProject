package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

	private Numero numeroRojoPar; 
	private Numero numeroNegroImpar; 
	private Numero numeroHuerfano; 
	private Numero numeroVecino;
	private Numero numeroTercio; 
	private Numero numeroVerde; 
	private Numero numeroDocena1; 
	private Numero numeroDocena2; 
	private Numero numeroDocena3;
	private Numero numeroMitad1; 
	private Numero numeroMitad2; 
	
	@Before 
	public void setUp() throws Exception {
	
	
	numeroRojoPar =  new Numero("rojo",14,"par","segunda docena","primera mitad","huerfanos");
	numeroNegroImpar = new Numero("negro",13,"impar","segunda docena","primera mitad","tercios"); 
	numeroHuerfano = new Numero("rojo",9,"impar","primera docena","primera mitad","huerfanos"); 
	numeroVecino = new Numero("negro",22,"par","segunda docena","segunda mitad","vecinos");
	numeroTercio = new Numero("rojo",23,"impar","segunda docena","segunda mitad","tercios"); 
	numeroVerde = new Numero("verde",0,"par","0","0","vecinos"); 
	numeroDocena1 = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
	numeroDocena2 = new Numero("negro",20,"par","segunda docena","segunda mitad","huerfanos"); 
	numeroDocena3 = new Numero("negro",35,"impar","tercera docena","segunda mitad","vecinos");
	numeroMitad1 = new Numero("rojo",18,"par","segunda docena","primera mitad","vecinos"); 
	numeroMitad2 = new Numero("rojo",36,"par","tercera docena","segunda mitad","tercios"); 

	}
	
	@After
	public void tearDown() throws Exception {
		numeroRojoPar = null; 
		numeroNegroImpar = null; 
		numeroHuerfano = null; 
		numeroVecino = null;
		numeroTercio = null; 
		numeroVerde = null; 
		numeroDocena1 = null; 
		numeroDocena2 = null; 
		numeroDocena3 = null;
		numeroMitad1 = null; 
		numeroMitad2 = null; 
		
	}

	@Test
	public void testNumero() {
		assertNotNull(numeroRojoPar);
		assertNotNull(numeroNegroImpar);
		assertNotNull(numeroHuerfano);
		assertNotNull(numeroVecino);
		assertNotNull(numeroTercio);
		assertNotNull(numeroVerde);
		assertNotNull(numeroDocena1);
		assertNotNull(numeroDocena2);
		assertNotNull(numeroDocena3);
		assertNotNull(numeroMitad1);
		assertNotNull(numeroMitad2);
	}

	@Test
	public void testGetNumero() {
		
		assertEquals(numeroRojoPar.getNumero(), 14);
		assertEquals(numeroNegroImpar.getNumero(), 13); 
		assertEquals(numeroHuerfano.getNumero(), 9); 
		assertEquals(numeroVecino.getNumero(), 22 ); 
		assertEquals(numeroTercio.getNumero(), 23); 
		assertEquals(numeroVerde.getNumero(), 0); 
		assertEquals(numeroDocena1.getNumero(), 1 ); 
		assertEquals(numeroDocena2.getNumero(), 20); 
		assertEquals(numeroDocena3.getNumero(), 35); 
		assertEquals(numeroMitad1.getNumero(), 18); 
		assertEquals(numeroMitad2.getNumero(), 36); 
	
	}

	@Test
	public void testGetColor() {
		assertEquals(numeroRojoPar.getColor(), "rojo");
		assertEquals(numeroNegroImpar.getColor(), "negro"); 
		assertEquals(numeroVerde.getColor(), "verde"); 
	}

	@Test
	public void testGetPar() {
		
		assertEquals(numeroRojoPar.getPar(), "par");
		assertEquals(numeroNegroImpar.getPar(), "impar"); 
		assertEquals(numeroVerde.getPar(), "par"); 
	}

	@Test
	public void testGetDocena() {
		
		assertEquals(numeroVerde.getDocena(), "0"); 
		assertEquals(numeroDocena1.getDocena(), "primera docena" ); 
		assertEquals(numeroDocena2.getDocena(), "segunda docena"); 
		assertEquals(numeroDocena3.getDocena(), "tercera docena"); 
	}

	@Test
	public void testGetMitad() {
	
		assertEquals(numeroVerde.getMitad(), "0"); 
		assertEquals(numeroMitad1.getMitad(), "primera mitad"); 
		assertEquals(numeroMitad2.getMitad(), "segunda mitad"); 

	}

	@Test
	public void testGetFamilia() {
		
		assertEquals(numeroHuerfano.getFamilia(), "huerfanos"); 
		assertEquals(numeroVecino.getFamilia(), "vecinos");
		assertEquals(numeroTercio.getFamilia(), "tercios");
	}
}
