package proyectoruleta;

public abstract class Apuesta {
	
	private double cantidad;
	
	public Apuesta(double pCantidad) {
		this.cantidad = pCantidad;
	}
	
	public abstract double getPremio(Numero pNumero);
	
	protected double getCantidad() {
	
		return this.cantidad; 
	}
	
	
}

