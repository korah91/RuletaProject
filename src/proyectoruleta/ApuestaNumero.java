package proyectoruleta;

public class ApuestaNumero extends Apuesta {
	
	private int numero;
	private double multiplicador = 36;
	
	public ApuestaNumero (double pCantidad,int pNumero) {
		super(pCantidad);
		this.numero = pNumero;
	}
	public double getPremio(Numero pNumero) { //Devuelve lo apostado MAS el premio
		double premio = 0;
		
		if(numero == pNumero.getNumero()) //Si el numero es el premiado
		{
			premio = super.getCantidad()*multiplicador;
		}
		
		return premio;
	}

}
