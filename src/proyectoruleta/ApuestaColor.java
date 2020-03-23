package proyectoruleta;

public class ApuestaColor extends Apuesta {
	
	private String color;
	private double multiplicador = 2;
	
	public ApuestaColor (double pCantidad,String pColor) {
		super(pCantidad);
		this.color = pColor;
	}
	
	public double getPremio(Numero pNumero) {
		double premio = 0;
		
		if(pNumero.getColor().equalsIgnoreCase(this.color))
		{
			premio = this.cantidad*multiplicador;
		}
		
		return premio;
	}
}
