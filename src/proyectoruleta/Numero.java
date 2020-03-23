package proyectoruleta;

public class Numero {
	//atributos

	private String color; 
	private int  numero;
	private String par;
	private String docena; 
	private String  mitad; 
	private String familia; 
	
	//Constructoras

	public Numero(String pColor, int pNumero, String pPar, String pDocena, String pMitad, String pFamilia) {
		
		this.color = pColor; 
		this.numero = pNumero; 
		this.par = pPar; 
		this.docena = pDocena; 
		this.mitad = pMitad; 
		this.familia = pFamilia; 
	}
	
	//metodos adicionales

	public int getNumero() {
		
		return(this.numero);
	}
	
	public String getColor() {
		return(this.color); 
	}
	
	public String getPar() { 
		
		return(this.par); 
	}
	
	public String getDocena() {
		
		return(this.docena); 
	}
	
	public String getMitad() {
		
		return(this.mitad); 
	}
	
	public String getFamilia() {
		
		return(this.familia); 
	}
}
