package proyectoruleta;

import java.util.*;

public class ListaNumeros {
	//atributos

	private ArrayList<Numero> lista; 
	
	//Constructoras

	public ListaNumeros() {
		
		this.lista = new ArrayList<Numero>();
	}
	
	//metodos adicionales
	private Iterator<Numero> getIterador(){
		
		return(lista.iterator());
	}
	
	public Numero buscarNumeroPremiado(int pNum) {
		Iterator<Numero> itr = this.getIterador();
		Numero numeroPremiado = null; 
		boolean encontrado = false;
		
		while (itr.hasNext() && !encontrado){
			numeroPremiado = itr.next();
			
			if(numeroPremiado.getNumero() == pNum ){
				encontrado = true;
			}
		}
		return(numeroPremiado);
	}
	
	public Numero lanzarBola()
	
    {	
		Numero numeroPremiado = null; 
		int numero = 36;
        Random r = new Random();
        int caeEn = r.nextInt(numero);
        numeroPremiado = this.buscarNumeroPremiado(caeEn);
        
        return (numeroPremiado);
    }
	
	

}
