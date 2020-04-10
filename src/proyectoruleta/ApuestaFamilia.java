package proyectoruleta;

public class ApuestaFamilia extends Apuesta {
	
	private String familia;
	private double multiplicador;
	
	/*
	 Vecino --> 19.0
	 Huerfano --> 28.0
	 Tercio --> 24.0
	*/
	
	public ApuestaFamilia (double pCantidad,String pFamilia) {
		super(pCantidad);
		this.familia = pFamilia;
		
		if(pFamilia.equalsIgnoreCase("huerfanos")) 
		{
			this.multiplicador = 1.28;
		}
		if(pFamilia.equalsIgnoreCase("tercios"))
		{
			this.multiplicador = 1.24;
		}
		if(pFamilia.equalsIgnoreCase("vecinos"))
		{
			this.multiplicador = 1.19;
		}
	}
	public double getPremio(Numero pNumero) { //Devuelve lo apostado MAS el premio
		double premio = 0;
		if(pNumero.getFamilia().equalsIgnoreCase(this.familia))	
		{
			premio = super.getCantidad()*multiplicador;
		}
		
		
		return premio;
	}
}
