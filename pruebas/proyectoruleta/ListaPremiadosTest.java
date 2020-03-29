package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPremiadosTest {

	private ListaPremiados listaP;
	
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
	
		listaP = ListaPremiados.getListaPremiados();  
		
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
		
		listaP.reset(); 
		
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
	public void testGetMiListaPremiados() {
		
		assertNotNull(listaP);
		
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
	public void testAnnadirNumeroPremiado() {
		
		listaP.annadirNumeroPremiado(numeroRojoPar);
		listaP.annadirNumeroPremiado(numeroNegroImpar);
		listaP.annadirNumeroPremiado(numeroHuerfano);
		listaP.annadirNumeroPremiado(numeroVecino);
		listaP.annadirNumeroPremiado(numeroTercio);
		listaP.annadirNumeroPremiado(numeroVerde);
		listaP.annadirNumeroPremiado(numeroDocena1);
		listaP.annadirNumeroPremiado(numeroDocena2);
		listaP.annadirNumeroPremiado(numeroDocena3);
		listaP.annadirNumeroPremiado(numeroMitad1);
		listaP.annadirNumeroPremiado(numeroMitad2);
		
		assertEquals(listaP.cuantosNumeros(), 11);
	}

	@Test
	public void testImprimirTiradas() {
		
		listaP.annadirNumeroPremiado(numeroRojoPar);
		listaP.annadirNumeroPremiado(numeroNegroImpar);
		listaP.annadirNumeroPremiado(numeroHuerfano);
		listaP.annadirNumeroPremiado(numeroVecino);
		listaP.annadirNumeroPremiado(numeroTercio);
		listaP.annadirNumeroPremiado(numeroVerde);
		listaP.annadirNumeroPremiado(numeroDocena1);
		listaP.annadirNumeroPremiado(numeroDocena2);
		listaP.annadirNumeroPremiado(numeroDocena3);
		listaP.annadirNumeroPremiado(numeroMitad1);
		listaP.annadirNumeroPremiado(numeroMitad2);
		
		listaP.imprimirTiradas();
	}

	@Test
	public void testImprimirCalientes() {
		
		listaP.annadirNumeroPremiado(numeroRojoPar);
		listaP.annadirNumeroPremiado(numeroNegroImpar);
		listaP.annadirNumeroPremiado(numeroNegroImpar);
		listaP.annadirNumeroPremiado(numeroNegroImpar);
		listaP.annadirNumeroPremiado(numeroNegroImpar);
		listaP.annadirNumeroPremiado(numeroTercio);
		listaP.annadirNumeroPremiado(numeroVerde);
		listaP.annadirNumeroPremiado(numeroDocena3);
		listaP.annadirNumeroPremiado(numeroDocena3);
		listaP.annadirNumeroPremiado(numeroDocena3);
		
		listaP.imprimirCalientes();
	}

}
