package proyectoruleta;

import java.util.*;
import java.io.File;

public class Ruleta {
	private static Ruleta miRuleta = null;
	private ListaNumeros listaN;
	private ListaApuestas listaA;
	private double saldo = 0.0;
	
	private Ruleta() {
		this.listaN = new ListaNumeros();
		this.listaA = new ListaApuestas();
		
	}
	
	public static synchronized Ruleta getRuleta() {
		if (Ruleta.miRuleta == null) {
			Ruleta.miRuleta = new Ruleta();
		}
		return Ruleta.miRuleta;
	}
	
	public void jugarPartida() {
		
		boolean partida = false;
		boolean salirdinero = false;
		boolean operacion = false;
		boolean apuestacorrecta = false;
		Jugador jugador = Jugador.getMiJugador();
		ListaPremiados listaP = ListaPremiados.getListaPremiados();
		
		String entradaTeclado;
		String apuesta;
		Scanner entradaEscaner = new Scanner(System.in);
		
		while (!partida) {
			salirdinero = false;
			operacion = false;
			apuestacorrecta = false;
			this.crearNumeros();
			
			while (!salirdinero) {
				System.out.println("Tu saldo del monedero actual es" + " " + jugador.getSaldoActual());
				System.out.println(" ");
				System.out.println("El saldo actual de la ruleta es" + " " + this.saldo);
				System.out.println(" ");
				System.out.print("Introduce saldo a la ruleta!, si no quieres introducir un nuevo saldo introduce un 0 --> ");
				
				entradaTeclado = entradaEscaner.nextLine();
				double dinero = Double.parseDouble(entradaTeclado);
				
				if(dinero > 0) {
					operacion = jugador.anadirSaldoRuleta(dinero);
					if(operacion == false) {
						System.out.println("No tienes suficiente saldo en tu monedero");
						System.out.println(" ");
					}
					else {
						salirdinero = true;
						this.anadirSaldoRuleta(dinero);
					}
				}
				else if (dinero < 0){
					System.out.println("Introduce el saldo correctamente, mayor o igual que 0");
					System.out.println(" ");
				}
				else {
					salirdinero = true;
				}
			}
			while (!apuestacorrecta) {  //Varias apuestas hasta que mete un 0 en cantidad 
				System.out.println("Tu saldo de la ruleta es" + " " + this.saldo);
				System.out.println(" ");
				System.out.println("Introduce una cantidad que deseas apostar");
				System.out.println("Si no quieres realizar mas apuestas introduce el numero 0 en la cantidad");
				System.out.print("Introduce la cantidad de apuesta --> ");
				entradaTeclado = entradaEscaner.nextLine();
				System.out.println(" ");
				double cant = Double.parseDouble(entradaTeclado);
				if(cant > 0 && cant <= this.saldo) { //Apuesta correcta, no se tiene en cuenta que no meta una cantidad o la meta negativa
					this.saldo = this.saldo - cant;
					boolean correcto = false;
					while (!correcto) {
						System.out.println("====== Tipos de apuestas posibles ======");
						System.out.println("Familia : huerfanos, tercios, vecinos");
						System.out.println("Color   : rojo, negro");
						System.out.println("Mitad   : primera mitad, segunda mitad");
						System.out.println("Par     : par, impar");
						System.out.println("Docena  : primera docena, segunda docena, tercera docena");
						System.out.println("Numero  : 0, 1, 2, 3 ... 36");
						System.out.println("");
						System.out.print("Introduce la apuesta--> huerfanos, par, rojo, 4 , primera docena, segunda mitad... --> ");
						entradaTeclado = entradaEscaner.nextLine();
						System.out.println(" ");
						
						if(!entradaTeclado.matches("\\d+") && !entradaTeclado.equalsIgnoreCase("huerfanos") && !entradaTeclado.equalsIgnoreCase("tercios") && !entradaTeclado.equalsIgnoreCase("vecinos") && !entradaTeclado.equalsIgnoreCase("rojo") && !entradaTeclado.equalsIgnoreCase("negro") && !entradaTeclado.equalsIgnoreCase("primera mitad") && !entradaTeclado.equalsIgnoreCase("segunda mitad") && !entradaTeclado.equalsIgnoreCase("primera docena") && !entradaTeclado.equalsIgnoreCase("segunda docena") && !entradaTeclado.equalsIgnoreCase("tercera docena") && !entradaTeclado.equalsIgnoreCase("par") && !entradaTeclado.equalsIgnoreCase("impar")) {
							System.out.println("Apuesta incorrecta, introducelo de nuevo");
							System.out.println(" ");
						}
						else if(isNumeric(entradaTeclado) == true) {
							int entr = Integer.parseInt(entradaTeclado);
							if(entr < 0 || entr > 36) {
								System.out.println("Apuesta incorrecta, introducelo de nuevo");
								System.out.println(" ");
							}
							else {
							correcto = true;
							}
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
					else if (entradaTeclado.equalsIgnoreCase("primera docena") || entradaTeclado.equalsIgnoreCase("segunda docena") || entradaTeclado.equalsIgnoreCase("tercera docena")) {
						apuesta = "docena";
					}
					else {
						apuesta = "numero";
						
					}
					apostarDinero(apuesta, entradaTeclado, cant);
				}
					
				else if(cant > this.saldo) {
					System.out.println("No tienes suficiente saldo");
					System.out.println(" ");
				}
				else if(cant == 0) {
					apuestacorrecta = true;
				}
				else {
					System.out.println("Apuesta incorrecta, introduce una apuesta mayor o igual que cero");
					System.out.println(" ");
				}
			}
			Numero num = this.listaN.lanzarBola();
			listaP.annadirNumeroPremiado(num);
			listaP.imprimirTiradas();//tiradas anteriores
			listaP.imprimirCalientes();//calientes y frios (se imprimira a partir de 5 numeros)
			double ganancia = this.listaA.getPremio(num);
			if(ganancia > 0) {
				System.out.println("Has ganado"+ " " + ganancia + " " + "euros");
				System.out.println(" ");
				ganancia = 0;
			}
			else {
				System.out.println("No has ganado");
				ganancia = 0;
			}
			
			this.actualizarSaldoRuleta(num);
			this.listaA.reset();
			
			boolean aux = false;
			
			while(!aux) {
				System.out.print("Si quieres retirar dinero escribe 1, si no introduce un 0 --> ");
				
				entradaTeclado = entradaEscaner.nextLine();
				if(entradaTeclado.equalsIgnoreCase("1")) { //Es como que no quiere seguir jugando
					aux = true;
					partida = true;
					listaA.reset();
				}
				else if(!entradaTeclado.equalsIgnoreCase("0")) {
					System.out.println("Comando incorrecto, introducelo correctamente");
					System.out.println(" ");
				}
				else {
					aux = true;
				}
			}
		}
		Ruleta.miRuleta.retirarDinero();
		System.out.println("Tu dinero actual es" + " " + jugador.getSaldoActual());
	}
	
	public void apostarDinero(String pTipoApuesta, String pApuesta, double pCant) {
		this.listaA.anadirApuesta(pTipoApuesta, pApuesta, pCant);
		System.out.println("Has apostado "+ pCant +" a "+ pApuesta + "\n");
		
	}
	
	public void retirarDinero() {
		Jugador jugador = Jugador.getMiJugador();
		jugador.actualizarSaldo(this.saldo);
		this.saldo = 0.0;
		double dinero = jugador.getBeneficio();
		if (dinero >= 0 ) {
			System.out.println(String.format("Tu beneficio total de las partidas es %4f", dinero));
			System.out.println(" ");
		}
		else {
			System.out.println(String.format("Has perdido una cantidad total de %4f", -dinero));
			System.out.println(" ");
		}
	}
	
	public void anadirSaldoRuleta(double pSaldo) {
		this.saldo = this.saldo + pSaldo;
	}
	
	public static boolean isNumeric(String teclado) {

        boolean resultado;

        try {
            Integer.parseInt(teclado);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
	
	public void actualizarSaldoRuleta(Numero pNum) {
		double premio = this.listaA.getPremio(pNum);
		this.saldo = this.saldo + premio;
	}
	
	public void crearNumeros() {
		this.listaN.generarNumeros();
	}
	

}