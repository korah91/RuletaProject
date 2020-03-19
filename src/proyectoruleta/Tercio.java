package proyectoruleta;

public class Tercio extends Numero {
	//atributos
	
	private static double multiplicador = 24.0;
	
	//Constructoras

	public Tercio(String pColor, int pNumero, boolean pPar, int pDocena, int pMitad) {
		
		super(pColor, pNumero, pPar, pDocena, pMitad);
	}
	
	//metodos adicionales
	
	protected double getPremio() {
		double premio = 0.0;
		
		return(premio); 
	}
}
