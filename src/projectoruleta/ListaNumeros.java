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
			
			if(numeroPremiado.getNumero() == pNum){
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

	
	public ArrayList<Numero> guardarNumerosPremiados() {
		
		ArrayList<Numero> listaNumerosPremiados = new ArrayList<Numero>();
		Numero numeroPremiado = null; 
		
		numeroPremiado = this.lanzarBola();
		listaNumerosPremiados.add(numeroPremiado); 
		
		return(listaNumerosPremiados);
	}
	
	public int cuantosNumerosPremiados() {
		ArrayList<Numero> listaPremiados = this.guardarNumerosPremiados();
		
		return(listaPremiados.size());
	}
	
	public void imprimirTiradas() {
		
		ArrayList<Numero> listaPremiados = this.guardarNumerosPremiados(); 
		int indice = listaPremiados.size();
		int contador = 0;
		
		System.out.println("Los ultimos 5 numeros premiados han sido : ");
		
		while (contador != 5 ) {
			
			System.out.println( listaPremiados.get(indice) );
			indice = indice - 1; 
			contador = contador + 1; 
		}
	}
	
	public void  imprimirCalientesYFrios() {
		ArrayList<Numero> listaDePremiados = this.guardarNumerosPremiados();
		ArrayList<Numero> listaCalientes = new ArrayList<Numero>();
		ArrayList<Numero> listaFrios = new ArrayList<Numero>();
		int indice = 0; 
		int contador = 0;
		
		while (indice < 36) {
			contador = Collections.frequency(listaDePremiados, indice);
			indice = indice + 1; 
		}
		
		if (contador >= 3 && listaCalientes.contains(indice)) {
			listaCalientes.add(listaDePremiados.get(indice));
		}
		else {
			if(!listaFrios.contains(indice)) {
			listaFrios.add(listaDePremiados.get(indice));
		
			}
		}	
	}

	public double getPremio() {
		double premio = 0.0;
		
		return(premio);
	}
}
