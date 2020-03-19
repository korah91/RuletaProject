package proyectoruleta;

public class Numero {
	//atributos

	private String color; 
	private int numero;
	private boolean par;
	private int docena; 
	private int mitad; 
	
	//Constructoras

	public Numero(String pColor, int pNumero, boolean pPar, int pDocena, int pMitad) {
		
		this.color = pColor; 
		this.numero = pNumero; 
		this.par = pPar; 
		this.docena = pDocena; 
		this.mitad = pMitad; 
	}
	
	//metodos adicionales

	public int getNumero() {
		
		return(this.numero);
	}
	
	protected double getPremio() {
		double premio = 0.0;
		
		return(premio);
	}
}
