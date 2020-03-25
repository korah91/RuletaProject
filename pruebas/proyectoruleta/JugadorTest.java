package proyectoruleta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {
	Jugador jugador;
	@Before
	public void setUp() throws Exception {
		jugador = Jugador.getMiJugador();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMiJugador() {
		assertNotNull(jugador);
	}

	@Test
	public void testGetBeneficioYActualizarSaldo() {
		assertEquals(0,jugador.getBeneficio(),0.1);
		jugador.actualizarSaldo(500);
		assertEquals(500,jugador.getBeneficio(),0.1);
		jugador.actualizarSaldo(-1000); //Esta llamada no es factible ya que no se puede sacar saldo negativo, es para facilitar la prueba.
		assertEquals(-500,jugador.getBeneficio(),0.1);
		jugador.actualizarSaldo(500);
		assertEquals(0,jugador.getBeneficio(),0.1);
	}

	@Test
	public void testGetSaldoInicial() {
		assertEquals(1000,jugador.getSaldoInicial(),0.1);
	}

	@Test
	public void testAnadirSaldoRuleta() {
		jugador.anadirSaldoRuleta(500);
		assertEquals(-500,jugador.getBeneficio(),0.1);
	}

}
