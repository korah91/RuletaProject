package proyectoruleta;

public class ApuestaFamilia extends Apuesta {
	
	private String familia;
	
	public ApuestaFamilia (double pCantidad,String pFamilia) {
		super(pCantidad);
		this.familia = pFamilia;
	}

}