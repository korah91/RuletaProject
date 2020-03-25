package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaNumerosTest {

	private ListaNumeros lista; 
	
	@Before
	public void setUp() throws Exception {
		
		lista = new ListaNumeros(); 
	}

	@After
	public void tearDown() throws Exception {
	
		lista = null; 
	}

	@Test
	public void testListaNumeros() {
		assertNotNull(lista);
	}

	@Test
	public void testGenerarNumeros() {
		lista.generarNumeros();
		assertEquals(lista.cuantosNumeros(), 37);
	}

	@Test
	public void testLanzarBolaYBuscarNumeroPremiado() {
		lista.generarNumeros();
		
		Numero numeroPremiado = lista.lanzarBola();
		int numero = numeroPremiado.getNumero();
		System.out.println(numero); 
		
		Numero numeroListaPremiado = lista.buscarNumeroPremiado(numero);
		System.out.println(numeroListaPremiado.getNumero());
		
	}

}
