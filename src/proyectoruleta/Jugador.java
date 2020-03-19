package proyectoruleta;

import java.util.Scanner;

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
	
	public void anadirSaldoRuleta () {
		Ruleta ruleta = Ruleta.getMiRuleta();
		boolean salir = false;
		Scanner scanner = new Scanner(System.in);

    	while(salir == false){
    		System.out.println("Usted tiene " + this.saldoActual + " € en el monedero");
    		System.out.println("Ingrese la cantidad a ingresar");
    	
		String entrada = scanner.nextLine();
		
		double pCant = Double.parseDouble(entrada);
		
		if(pCant == 0)
		{
			salir = true;
		}
		else {
		
			if (pCant > this.saldoActual) 
			{
				System.out.println("No tienes saldo suficiente como para añadir esa cantidad.");
			}
			else
			{
				this.saldoActual = this.saldoActual - pCant;
				ruleta.anadirSaldoRuleta(pCant);
				salir = true;
			}
		}
    	}
	}
	
}

