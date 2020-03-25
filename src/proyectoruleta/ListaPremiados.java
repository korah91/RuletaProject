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
	
	public static synchronized ListaPremiados getListaPremiados() {
		
		if(miListaPremiados == null) {
			miListaPremiados = new ListaPremiados(); 
		}
		
		return(ListaPremiados.miListaPremiados); 
	}
	
	private Iterator<Numero> getIterador(){
		return(lista.iterator());
	}
	
	public void annadirNumeroPremiado(Numero pNumero) {
		lista.add(pNumero); 
	}
	
	public void imprimirTiradas() {
		Iterator<Numero> itr = this.getIterador();
		Numero num = null; 
		System.out.println("Los ultimos numeros premiados han sido : ");	
		System.out.println(" ");
		
		while(itr.hasNext()) {
			num = itr.next(); 
			
			System.out.println("Numero : " + num.getNumero());
			System.out.println("Color : " + num.getColor());
			System.out.println("Par/Impar : " + num.getPar());
			System.out.println("Docena : " + num.getDocena());
			System.out.println("Mitad : " + num.getMitad());
			System.out.println("Familia : " + num.getFamilia());
			System.out.println(" ");
			
		}

	}

	
	public void  imprimirCalientesYFrios() {
		ArrayList<Numero> listaCalientes = new ArrayList<Numero>();
		ArrayList<Numero> listaFrios = new ArrayList<Numero>();
		Iterator<Numero> itrCalientes = listaCalientes.iterator(); 
		Iterator<Numero> itrFrios = listaFrios.iterator();
		Numero numCaliente = null; 
		Numero numFrios = null;
		int indice = 0; 
		int contador = 0;
		
		while (indice < this.cuantosNumeros() - 1) {
			contador = Collections.frequency(this.lista, indice);
			indice = indice + 1; 
		}
		
		if (contador >= 3 && !listaCalientes.contains(indice)) {
			listaCalientes.add(this.lista.get(indice));
		}
		else {
			if(!listaFrios.contains(indice)) {
			listaFrios.add(this.lista.get(indice));
		
			}
		}
		
		System.out.println("Los numeros calientes son : " );
		System.out.println(" ");
		
		while (itrCalientes.hasNext()) {
			
			numCaliente = itrCalientes.next();
			
			System.out.println("Numero : " + numCaliente.getNumero());
			System.out.println("Color : " + numCaliente.getColor());
			System.out.println("Par/Impar : " + numCaliente.getPar());
			System.out.println("Docena : " + numCaliente.getDocena());
			System.out.println("Mitad : " + numCaliente.getMitad());
			System.out.println("Familia : " + numCaliente.getFamilia());
			System.out.println(" ");
		}
		 
		System.out.println("Los numeros frios son : ");
		System.out.println(" ");
		
		while (itrFrios.hasNext()) {
			
			numFrios = itrFrios.next();
			
			System.out.println("Numero : " + numFrios.getNumero());
			System.out.println("Color : " + numFrios.getColor());
			System.out.println("Par/Impar : " + numFrios.getPar());
			System.out.println("Docena : " + numFrios.getDocena());
			System.out.println("Mitad : " + numFrios.getMitad());
			System.out.println("Familia : " + numFrios.getFamilia());
			System.out.println(" ");
		}
	}
	
	public int cuantosNumeros() {
		
		return(lista.size());
	}

}
