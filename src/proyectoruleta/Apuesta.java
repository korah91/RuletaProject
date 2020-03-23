package proyectoruleta;

public abstract class Apuesta {
	
	protected double cantidad;
	protected double multiplicador;
	
	public Apuesta(double pCantidad) {
		this.cantidad = pCantidad;
	}
	
	public abstract double getPremio();
}
