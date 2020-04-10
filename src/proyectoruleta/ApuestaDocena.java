package proyectoruleta;

public class ApuestaDocena extends Apuesta {
	
	private String docena;
	private double multiplicador = 3; //El multiplicador siempre es el mismo
	
	
	public ApuestaDocena (double pCantidad,String pDocena) {
		super(pCantidad);
		this.docena = pDocena;
	}
	
	public double getPremio(Numero pNumero) {
		double premio = 0;
		
		if(pNumero.getDocena().equalsIgnoreCase(this.docena))
		{
			premio = super.getCantidad()*multiplicador;
		}
		
		return premio;
		
	}

}
