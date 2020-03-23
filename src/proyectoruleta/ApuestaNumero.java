package proyectoruleta;

public class ApuestaNumero extends Apuesta {
	
	private String numero;
	private double multiplicador = 36;
	
	public ApuestaNumero (double pCantidad,String pNumero) {
		super(pCantidad);
		this.numero = pNumero;
	}
	public double getPremio(Numero pNumero) { //Devuelve lo apostado MAS el premio
		double premio = 0;
		
		if(Integer.toString(pNumero.getNumero()).equalsIgnoreCase(numero)) //Si el numero es el premiado
		{
			premio = this.cantidad*multiplicador;
		}
		
		return premio;
	}

}
