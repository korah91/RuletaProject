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
			System.out.print("Introduce saldo a la ruleta!, si no quieres introducir un nuevo saldo introduce un 0");
			entradaTeclado = entradaEscaner.nextLine();
			double cant = Double.parseDouble(entradaTeclado);
			if(cant > 0) {
				boolean operacion = this.jugador.anadirSaldoRuleta(cant);
				if(operacion = false) {
					System.out.println("No tienes suficiente saldo en tu monedero");
				}
				else {
					salir = true;
				}
			}
			else if (cant < 0){
				System.out.println("Introduce el saldo correctamente, mayor o igual que 0");
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
				this.saldo = this.saldo - cant;
				if(cant > 0 && cant <= this.saldo) { //Apuesta correcta
					boolean correcto = false;
					while (!correcto) {
						System.out.print("Introduce el tipo de apuesta--> familia, color, mitad, par, docena o numero");
						entradaTeclado = entradaEscaner.nextLine();
						if(!entradaTeclado.equalsIgnoreCase("familia") || !entradaTeclado.equalsIgnoreCase("color") || !entradaTeclado.equalsIgnoreCase("mitad") || !entradaTeclado.equalsIgnoreCase("par") || !entradaTeclado.equalsIgnoreCase("docena") || !entradaTeclado.equalsIgnoreCase("numero")) {
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
						if (entradaTeclado.equalsIgnoreCase("familia") && (!entradaTeclado2.equalsIgnoreCase("huerfanos")|| !entradaTeclado2.equalsIgnoreCase("tercios") || entradaTeclado2.equalsIgnoreCase("vecinos"))) {
							System.out.println("Apuesta incorrecta, introducelo de nuevo");
						}
						else if (entradaTeclado.equalsIgnoreCase("color") && (!entradaTeclado2.equalsIgnoreCase("rojo") || !entradaTeclado2.equalsIgnoreCase("negro"))) {
							System.out.println("Apuesta incorrecta, introducelo de nuevo");
						}
						else if (entradaTeclado.equalsIgnoreCase("mitad") && (!entradaTeclado2.equalsIgnoreCase("primera") || !entradaTeclado2.equalsIgnoreCase("segunda"))) {
							System.out.println("Apuesta incorrecta, introducelo de nuevo");
						}
						else if (entradaTeclado.equalsIgnoreCase("par") && (!entradaTeclado2.equalsIgnoreCase("par") || !entradaTeclado2.equalsIgnoreCase("impar"))) {
							System.out.println("Apuesta incorrecta, introducelo de nuevo");
						}
						else if (entradaTeclado.equalsIgnoreCase("docena") && (!entradaTeclado2.equalsIgnoreCase("primera") || !entradaTeclado2.equalsIgnoreCase("segunda"))) {
							System.out.println("Apuesta incorrecta, introducelo de nuevo");
						}
						else if (entradaTeclado.equalsIgnoreCase("numero")) {
							int num = Integer.parseInt(entradaTeclado2);
							if(num < 0 || num > 36) {
								System.out.println("Apuesta incorrecta, introducelo de nuevo");
							}
						}
						else {
							correcto = true;
						}
					}
					apostarDinero(entradaTeclado, entradaTeclado2);
				}
					
				else if(cant > this.saldo) {
					System.out.println("No tienes suficiente saldo");
				}
				else if(cant == 0) {
					comenzar = true;
				}
			}
			Numero num = this.listaN.lanzarBola();
			
			this.actualizarSaldoRuleta(num);
			
			boolean aux = false;
			while(!aux) {
				System.out.print("Si quieres retirar dinero escribe 1, si no introduce un 0");
				entradaTeclado = entradaEscaner.nextLine();
				if(entradaTeclado.equalsIgnoreCase("1")) {
					salir = true;
					aux = true;
				}
				else if(!entradaTeclado.equalsIgnoreCase("0")) {
					System.out.println("Comando incorrecto, introducelo correctamente");
				}
				else {
					aux = true;
				}
			}
			
		}
		
	}
	
	public void apostarDinero(String pTipoApuesta, String pApuesta) {
		if(pTipoApuesta.equalsIgnoreCase("familia")) {
			this.listaA.anadirApuestaFamilia(pApuesta);
		}
		else if(pTipoApuesta.equalsIgnoreCase("color")) {
			this.listaA.annadirApuestaColor(pApuesta);
		}
		else if(pTipoApuesta.equalsIgnoreCase("mitad")) {
			this.listaA.anadirApuestaMitad(pApuesta);
		}
		else if(pTipoApuesta.equalsIgnoreCase("par")) {
			this.listaA.anadirApuestaMitad(pApuesta);
		}
		else if(pTipoApuesta.equalsIgnoreCase("docena")) {
			this.listaA.anadirApuestaDocena(pApuesta);
		}
		else if(pTipoApuesta.equalsIgnoreCase("numero")) {
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
	
	public void actualizarSaldoRuleta(Numero pNum) {
		double premio = this.listaA.getPremio(num);
		this.saldo = this.saldo + premio;
	}
	

}
