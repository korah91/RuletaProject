package proyectoruleta;

import java.util.*;

public class ListaApuestas {
    private ArrayList<Apuesta> lista;
    
    public ListaApuestas() {
        this.lista = new ArrayList<Apuesta>();
    }
    private Iterator<Apuesta> getIterador(){
    	return this.lista.iterator();
    }
    public void resetear() {
        this.lista.clear();
    }
    public void anadirApuesta(String pTipo, String pApuesta, double pCantidad){
        if(pTipo.equalsIgnoreCase("familia")) {
            this.lista.add(new ApuestaFamilia(pCantidad, pApuesta));
        }
        else if(pTipo.equalsIgnoreCase("color")){
            this.lista.add(new ApuestaColor(pCantidad, pApuesta));
        } 
	else if(pTipo.equalsIgnoreCase("docena")) {
	    this.lista.add(new ApuestaDocena(pCantidad, pApuesta));
	}
	else if(pTipo.equalsIgnoreCase("par")){
	    this.lista.add(new ApuestaPar(pCantidad, pApuesta));
	}
	else if(pTipo.equalsIgnoreCase("mitad")) {
	    this.lista.add(new ApuestaMitad(pCantidad, pApuesta));
	}
	else if(pTipo.equalsIgnoreCase("numero")) {
	    this.lista.add(new ApuestaNumero(pCantidad, pApuesta));
	}
    }
    
    public double getPremio(Numero pNum) {
    	double premioTotal = 0;
    	Iterator<Apuesta> itr = this.getIterador();
    	Apuesta apuesta = null;
    	
    	while(itr.hasNext())
    	{
    		apuesta = itr.next();
    		premioTotal = premioTotal + apuesta.getPremio(pNum);
    	}
    	return premioTotal;
    }

    
    
}
