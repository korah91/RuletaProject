package proyectoruleta;

public class ApuestaFamilia extends Apuesta {
	
	private String familia;
	private double multiplicador = 36;
	
	public ApuestaFamilia (double pCantidad,String pFamilia) {
		super(pCantidad);
		this.familia = pFamilia;
		
		if(pFamilia.equalsIgnoreCase("huerfanos")) 
		{
			this.cantidad = this.cantidad / 8;
		}
		if(pFamilia.equalsIgnoreCase("tercios"))
		{
			this.cantidad = this.cantidad / 12;
		}
		if(pFamilia.equalsIgnoreCase("vecinos"))
		{
			this.cantidad = this.cantidad / 17;
		}
	}
	public double getPremio(Numero pNumero) { //Devuelve lo apostado MAS el premio
		double premio = 0;
		if(pNumero.getFamilia().equalsIgnoreCase(this.familia))	
		{
			premio = this.cantidad*multiplicador;
		}
		
		
		return premio;
	}
}