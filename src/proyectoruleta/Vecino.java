package proyectoruleta;

public class Vecino extends Numero {
	//atributos
	private static double multiplicador = 19.0;
	
	//Constructoras

	public Vecino(String pColor, int pNumero, boolean pPar, int pDocena, int pMitad) {
		
		super(pColor, pNumero, pPar, pDocena, pMitad);
	}
	
	//metodos adicionales
	
	protected double getPremio() {
		double premio = 0.0;
		
		return(premio); 
	}
}