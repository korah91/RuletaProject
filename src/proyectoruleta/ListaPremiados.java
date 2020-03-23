package proyectoruleta;

import java.util.*;

public class ListaPremiados {
	//atributos
	
	private ArrayList<Numero> lista; 
	private static ListaPremiados miListaPremiados = null; 
	
	//Constructoras

	private ListaPremiados() {
		this.lista = new ArrayList<Numero>(); 
	}
	
	//metodos adicionales
	
	public ListaPremiados getMiListaPremiados() {
		
		if(miListaPremiados == null) {
			miListaPremiados = new ListaPremiados(); 
		}
		
		return(ListaPremiados.miListaPremiados); 
	}
	
	public void annadirNumeroPremiado(Numero pNumero) {
		lista.add(pNumero); 
	}
	
	public void imprimirTiradas() {
		
		System.out.println("Los ultimos numeros premiados han sido : ");	
		System.out.println( this.lista );

	}

	
	public void  imprimirCalientesYFrios() {
		ArrayList<Numero> listaCalientes = new ArrayList<Numero>();
		ArrayList<Numero> listaFrios = new ArrayList<Numero>();
		int indice = 0; 
		int contador = 0;
		
		while (indice < 36) {
			contador = Collections.frequency(this.lista, indice);
			indice = indice + 1; 
		}
		
		if (contador >= 3 && listaCalientes.contains(indice)) {
			listaCalientes.add(this.lista.get(indice));
		}
		else {
			if(!listaFrios.contains(indice)) {
			listaFrios.add(this.lista.get(indice));
		
			}
		}	
		
		System.out.println("Los numeros calientes son : " + listaCalientes); 
		System.out.println("Los numeros frios son : " + listaFrios); 
	}

}
