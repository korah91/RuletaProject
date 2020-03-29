package proyectoruleta;

public class ApuestaMitad extends Apuesta {
	
	private String mitad;
	private double multiplicador = 2;
	
	public ApuestaMitad (double pCantidad,String pMitad) {
		super(pCantidad);
		this.mitad = pMitad;
	}
	public double getPremio(Numero pNumero) {
		double premio = 0;
		
		if(pNumero.getMitad().equalsIgnoreCase(this.mitad))
		{
			premio = this.cantidad*multiplicador;
		}
		
		return premio;
	}

}
