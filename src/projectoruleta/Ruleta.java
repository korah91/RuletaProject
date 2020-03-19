package projectoruleta;
import java.util.Random;

public class Ruleta {
	private int numero = 36;
	
	public Ruleta()
	{
		
	}
	
	public int lanzarBola()
	{
		Random r = new Random();
		int caeEn = r.nextInt(numero);
		return caeEn;
	}
	
}
