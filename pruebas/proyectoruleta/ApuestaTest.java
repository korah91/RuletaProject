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

		//Pruebas Color
		
		Numero rojo = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero negro = new Numero("negro",1,"impar","primera docena","primera mitad","huerfanos");

		lista.anadirApuesta("Color", "rojo", 15); 
		assertEquals(lista.getPremio(rojo), 30, 0.1);
		assertEquals(lista.getPremio(negro), 0, 0.1);
		
		lista.resetear();
		
		lista.anadirApuesta("Color", "negro", 15); 
		assertEquals(lista.getPremio(rojo), 0, 0.1);
		assertEquals(lista.getPremio(negro), 30, 0.1);
		

		//Pruebas Docena
		
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
		
		lista.resetear();
		
		//Pruebas Familia
		
		Numero huerfano = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero vecino = new Numero("rojo",1,"impar","primera docena","primera mitad","vecinos");
		Numero tercio = new Numero("rojo",1,"impar","primera docena","primera mitad","tercios");

		lista.anadirApuesta("Familia", "huerfanos", 10); 

		assertEquals(lista.getPremio(huerfano), 12.8, 0.1);	  //Apuesta a huerfanos y gana
		assertEquals(lista.getPremio(vecino), 0, 0.1);  	  //Apuesta a vecinos y no gana
		assertEquals(lista.getPremio(tercio), 0, 0.1); 	  	  //Apuesta a tercios y no gana
		
		lista.resetear();
		
		lista.anadirApuesta("Familia", "vecinos", 10); 
		assertEquals(lista.getPremio(huerfano), 0, 0.1);	  //Apuesta a huerfanos y no gana
		assertEquals(lista.getPremio(vecino), 11.19, 1);  	  //Apuesta a vecinos y gana
		assertEquals(lista.getPremio(tercio), 0, 0.1); 	  	  //Apuesta a tercios y no gana
		
		lista.resetear();
		
		lista.anadirApuesta("Familia", "tercios", 10); 
		assertEquals(lista.getPremio(huerfano), 0, 1);	  //Apuesta a huerfanos y no gana
		assertEquals(lista.getPremio(vecino), 0, 0.1);  	  //Apuesta a vecinos y no gana
		assertEquals(lista.getPremio(tercio), 12.4, 1); 	  //Apuesta a tercios y gana
		
		lista.resetear();

		//Pruebas Mitad
		
		Numero mitad1 = new Numero("negro",2,"impar","segunda docena","primera mitad","huerfanos");
		Numero mitad2 = new Numero("rojo",1,"impar","primera docena","segunda mitad","vecinos");
		
		lista.anadirApuesta("Mitad", "primera mitad", 10); 
		
		assertEquals(lista.getPremio(mitad1), 20, 0.1);	 	  //Apuesta a la primera mitad y gana
		assertEquals(lista.getPremio(mitad2), 0, 0.1);  	  //Apuesta a la segunda mitad y no gana

		lista.resetear();
		
		lista.anadirApuesta("Mitad", "segunda mitad", 10); 
		
		assertEquals(lista.getPremio(mitad1), 0, 0.1);	 	  //Apuesta a la primera mitad y no gana
		assertEquals(lista.getPremio(mitad2), 20, 0.1);  	  //Apuesta a la segunda mitad y gana

		lista.resetear();
		
		//Pruebas Numero
		
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

}
