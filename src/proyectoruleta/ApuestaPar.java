package proyectoruleta;

public class ApuestaPar extends Apuesta {
	
	private String par;
	private double multiplicador = 2;
	
	public ApuestaPar (double pCantidad,String pPar) {
		super(pCantidad);
		this.par = pPar;
	}
	public double getPremio(Numero pNumero) { //Devuelve lo apostado MAS el premio
		double premio = 0;
			
		if(pNumero.getPar().equalsIgnoreCase(par))
		{
			premio = this.cantidad*multiplicador;			
		}

		
		return premio;
	}
}