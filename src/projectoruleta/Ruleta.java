package proyectoruleta;

import java.util.Scanner;

public class Ruleta {
	private static Ruleta miRuleta = null;
	private ListaNumeros listaN;
	private Jugador jugador;
	private ListaApuestas listaA;
	private double saldo = 0.0;
	
	private Ruleta() {
		this.listaN = new ListaNumeros();
	}
	
	public static synchronized Ruleta getRuleta() {
		if (Ruleta.miRuleta == null) {
			Ruleta.miRuleta = new Ruleta();
		}
	}
	
	public void jugarPartida() {
		boolean salir = false;
		String entradaTeclado;
		String entradaTeclado2;
		Scanner entradaEscaner = new Scanner(System.in);
		while (!salir) {
			System.out.print("Introduce saldo a la ruleta!");
			entradaTeclado = entradaEscaner.nextLine();
			double cant = Double.parseDouble(entradaTeclado);
			if(cant > 0) {
				this.anadirSaldoRuleta(cant);
				salir = true;
			}
			else {
				System.out.println("Introduce el saldo correctamente, mayor que 0");
			}
		}
		salir = false;
		boolean comenzar = false;
		while (!salir) {
			this.listaN.imprimirTiradas();//tiradas anteriores
			this.listaN.imprimirCalientesYFrios();//calientes y frios 
			while (!comenzar) {  //Varias apuestas hasta que mete un 0 en cantidad 
				System.out.println("Introduce una cantidad y una apuesta, por ejemplo 5, rojo");
				System.out.println("Si no quieres realizar mas apuestas introcude el numero 0 en la cantidad");
				System.out.print("Introduce la cantidad de apuesta");
				entradaTeclado = entradaEscaner.nextLine();
				double cant = Double.parseDouble(entradaTeclado);
				if(cant > 0 && cant <= this.saldo) { //Apuesta correcta
					boolean correcto = false;
					while (!correcto) {
						System.out.print("Introduce el tipo de apuesta--> familia, color, mitad, par, docena o numero");
						entradaTeclado = entradaEscaner.nextLine();
						if(entradaTeclado != "familia" || entradaTeclado != "color" || entradaTeclado != "mitad" || entradaTeclado != "par" || entradaTeclado != "docena" || entradaTeclado != "numero") {
							System.out.println("Apuesa incorrecta, introducelo de nuevo");
						}
						else {
							correcto = true;
						}
					}
					correcto = false;
					while(!correcto) { 
						System.out.print("Introduce la apuesta--> huerfanos, par, rojo, 4...");
						entradaTeclado2 = entradaEscaner.nextLine();
						if (entradaTeclado == "familia" && (entradaTeclado2 != "huefanos" || entradaTeclado2 != "tercios" || entradaTeclado2 != "vecinos")) {
							System.out.println("Apuesta incorrecta, intducelo de nuevo");
						}
						else if (entradaTeclado == "color" && (entradaTeclado2 != "rojo" || entradaTeclado2 != "negro")) {
							System.out.println("Apuesta incorrecta, intducelo de nuevo");
						}
						else if (entradaTeclado == "mitad" && (entradaTeclado2 != "primera" || entradaTeclado2 != "segunda")) {
							System.out.println("Apuesta incorrecta, intducelo de nuevo");
						}
						else if (entradaTeclado == "par" && (entradaTeclado2 != "par" || entradaTeclado2 != "impar")) {
							System.out.println("Apuesta incorrecta, intducelo de nuevo");
						}
						else if (entradaTeclado == "docena" && (entradaTeclado2 != "primera" || entradaTeclado2 != "segunda")) {
							System.out.println("Apuesta incorrecta, intducelo de nuevo");
						}
						else if (entradaTeclado == "numero") {
							int num = Integer.parseInt(entradaTeclado2);
							if(num < 0 || num > 36) {
								System.out.println("Apuesta incorrecta, intducelo de nuevo");
							}
						}
						else {
							correcto = true;
						}
					}
					apostarDinero(entradaTeclado, entradaTeclado2 );
				}
					
				else if(cant > this.saldo) {
					System.out.println("No tienes suficiente saldo");
				}
				else if(cant == 0) {
					comenzar = true;
				}
			}
			Numero num = this.listaN.lanzarBola();
			
			
		}
		
	}
	
	public void apostarDinero(String pTipoApuesta, String pApuesta) {
		if(pTipoApuesta == "familia") {
			this.listaA.anadirApuestaFamilia(pApuesta);
		}
		else if(pTipoApuesta == "color") {
			this.listaA.annadirApuestaColor(pApuesta);
		}
		else if(pTipoApuesta ==  "mitad") {
			this.listaA.anadirApuestaMitad(pApuesta);
		}
		else if(pTipoApuesta == "par") {
			this.listaA.anadirApuestaMitad(pApuesta);
		}
		else if(pTipoApuesta == "docena") {
			this.listaA.anadirApuestaDocena(pApuesta);
		}
		else if(pTipoApuesta == "numero") {
			this.listaA.annadirApuestaNumero(pApuesta);
		}
		
	}
	
	public void retirarDinero() {
		this.jugador.actualizarSaldo(this.saldo);
		this.saldo = 0.0;
	}
	
	public void anadirSaldoRuleta(double pSaldo) {
		this.saldo = this.saldo + pSaldo;
	}
	
	public void actualizarSaldoRuleta() {
		
		
	}
	

}
