package proyectoruleta;

public class ApuestaNumero extends Apuesta {
	
	private String numero;
	
	public ApuestaNumero (double pCantidad,String pNumero) {
		super(pCantidad);
		this.numero = pNumero;
	}

}
