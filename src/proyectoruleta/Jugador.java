package proyectoruleta;

public class Jugador {

	private double saldoInicial;
	private double saldoActual;
	private static Jugador miJugador = null;
	
	private Jugador() {
		this.saldoInicial = 1000;
		this.saldoActual = this.saldoInicial;
	}
	
	public Jugador getMiJugador() {
		
		if (Jugador.miJugador == null) {
			Jugador.miJugador = new Jugador();
		}
		return Jugador.miJugador;
	}
	public double getBeneficio() {
		return this.saldoActual - this.saldoInicial;
	}
	
	public void actualizarSaldo (double pCant) {
		this.saldoActual = this.saldoActual + pCant;
	}
	
	public double getSaldoInicial () {
		return this.saldoInicial;
	}
	
	public boolean anadirSaldoRuleta (double pCant) {
		boolean resp = false;
		if (this.saldoActual >= pCant) {
			resp = true;
			this.saldoActual = this.saldoActual - pCant;
		}
		return resp;
	}
	
}