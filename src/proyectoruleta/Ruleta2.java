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
		String apuesta;
		Scanner entradaEscaner = new Scanner(System.in);
		while (!salir) {
			System.out.print("Introduce saldo a la ruleta!, si no quieres introducir un nuevo saldo introduce un 0");
			entradaTeclado = entradaEscaner.nextLine();
			double dinero = Double.parseDouble(entradaTeclado);
			if(dinero > 0) {
				boolean operacion = this.jugador.anadirSaldoRuleta(dinero);
				if(operacion = false) {
					System.out.println("No tienes suficiente saldo en tu monedero");
				}
				else {
					salir = true;
				}
			}
			else if (dinero < 0){
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
						System.out.print("Introduce la apuesta--> huerfanos, par, rojo, 4 , primera docena, segunda mitad...");
						entradaTeclado = entradaEscaner.nextLine();
						int num = Integer.parseInt(entradaTeclado);
						if(!entradaTeclado.equalsIgnoreCase("huerfanos") || !entradaTeclado.equalsIgnoreCase("tercios") || !entradaTeclado.equalsIgnoreCase("vecinos") || !entradaTeclado.equalsIgnoreCase("rojo") || !entradaTeclado.equalsIgnoreCase("negro") || !entradaTeclado.equalsIgnoreCase("primera mitad") || !entradaTeclado.equalsIgnoreCase("segunda mitad") || !entradaTeclado.equalsIgnoreCase("primera docena") || !entradaTeclado.equalsIgnoreCase("segunda docena") || !entradaTeclado.equalsIgnoreCase("par") || !entradaTeclado.equalsIgnoreCase("impar") || num > 36 || num < 0 ) {
							System.out.println("Apuesa incorrecta, introducelo de nuevo");
						}
						else {
							correcto = true;
						}
					}
					
					if (entradaTeclado.equalsIgnoreCase("huerfanos") || entradaTeclado.equalsIgnoreCase("tercios") || entradaTeclado.equalsIgnoreCase("vecinos")) {
						apuesta = "familia";
					}
					else if (entradaTeclado.equalsIgnoreCase("rojo") || entradaTeclado.equalsIgnoreCase("negro")) {
						apuesta = "color";
					}
					else if (entradaTeclado.equalsIgnoreCase("primera mitad") || entradaTeclado.equalsIgnoreCase("segunda mitad")) {
						apuesta = "mitad";
					}
					else if (entradaTeclado.equalsIgnoreCase("par") || entradaTeclado.equalsIgnoreCase("impar")) {
						apuesta = "par";
					}
					else if (entradaTeclado.equalsIgnoreCase("primera docena") || entradaTeclado.equalsIgnoreCase("segunda docena")) {
						apuesta = "docena";
					}
					else {
						apuesta = "numero";
					}
					apostarDinero(apuesta, entradaTeclado);
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
		double premio = this.listaA.getPremio(pNum);
		this.saldo = this.saldo + premio;
	}
	

}
