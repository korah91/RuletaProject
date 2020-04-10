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
	
	private Iterator<Numero> getIteradorLista(){
		return(lista.iterator());
	}
	
	public void annadirNumeroPremiado(Numero pNumero) {
		lista.add(pNumero); 
	}
	
	public void imprimirTiradas() {
		Iterator<Numero> itr = this.getIteradorLista();
		Numero num = null; 
		System.out.println("Los ultimos numeros premiados han sido : ");	
		System.out.println(" ");
		
		while(itr.hasNext()) {
			num = itr.next(); 
			
			System.out.println("Numero    : " + num.getNumero());
			System.out.println("Color     : " + num.getColor());
			System.out.println("Par/Impar : " + num.getPar());
			System.out.println("Docena    : " + num.getDocena());
			System.out.println("Mitad     : " + num.getMitad());
			System.out.println("Familia   : " + num.getFamilia());
			System.out.println(" ");
			
		}

	}

	
	public void  imprimirCalientes() {
		ArrayList<Integer> listaTemp = new ArrayList<Integer>();
		Iterator<Numero> itr = this.getIteradorLista();
		Numero primero = null;
		
		System.out.println("Los numeros calientes son : " );
		System.out.println(" ");
		
		while(itr.hasNext()) {
			primero = itr.next();
			/* Comprobar que el numero no este en nuestro arrayList */
			if (!listaTemp.contains(primero.getNumero())) {
				Numero num = new Numero(primero.getColor(), primero.getNumero(), primero.getPar(), primero.getDocena()
						, primero.getMitad(), primero.getFamilia());
				int iNumeroVeces = 0;
				for (int iIndice = 0; iIndice < this.lista.size(); iIndice++) {
					if (primero.getNumero() == this.lista.get(iIndice).getNumero()) {
						iNumeroVeces++;
					}
				}
				
				num.setVecesAparecido(iNumeroVeces);
				listaTemp.add(num.getNumero());
				

				if(iNumeroVeces >= 2) {
					
						System.out.println("==========================");
		                System.out.println("|Numero      : " + num.getNumero());
		                System.out.println("|Color       : " + num.getColor());
		                System.out.println("|Par/Impar   : " + num.getPar());
		                System.out.println("|Docena      : " + num.getDocena());
		                System.out.println("|Mitad       : " + num.getMitad());
		                System.out.println("|Familia     : " + num.getFamilia());
		                System.out.println("|Apariciones : " + num.getVecesAparecido());
		                System.out.println("==========================");

		                System.out.println(" ");
						
				}
			}
			
		}
	}
	
	public int cuantosNumeros() {
		
		return(lista.size());
	}
	
	public void reset() {
		lista = new ArrayList<Numero>(); 
	}

}
