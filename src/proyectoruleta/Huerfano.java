package proyectoruleta;

public class Huerfano extends Numero {
	//atributos

	private static double multiplicador = 28.0;
	
	//Constructoras

	public Huerfano(String pColor, int pNumero, boolean pPar, int pDocena, int pMitad) {
		
		super(pColor, pNumero, pPar, pDocena, pMitad);
	}
	
	//metodos adicionales
	
	protected double getPremio() {
		double premio = 0.0;
		
		return(premio); 
	}
}
