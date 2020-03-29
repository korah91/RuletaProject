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
			int num = Integer.parseInt(pApuesta);
		    this.lista.add(new ApuestaNumero(pCantidad, num));
		}
    }
    
    public double getPremio(Numero pNum) {
    	double premioTotal = 0;
    	Iterator<Apuesta> itr = this.getIterador();
    	Apuesta apuesta = null;
    	
    	while(itr.hasNext())
    	{
    		apuesta = itr.next();
    		if(apuesta instanceof ApuestaColor){
    			premioTotal = premioTotal + ((ApuestaColor)apuesta).getPremio(pNum);
    		}
    		else if(apuesta instanceof ApuestaFamilia) {
    			premioTotal = premioTotal + ((ApuestaFamilia)apuesta).getPremio(pNum);
    		}
    		else if(apuesta instanceof ApuestaDocena) {
    			premioTotal = premioTotal + ((ApuestaDocena)apuesta).getPremio(pNum);
    		}
    		else if(apuesta instanceof ApuestaMitad) {
    			premioTotal = premioTotal + ((ApuestaMitad)apuesta).getPremio(pNum);
    		}
    		else if(apuesta instanceof ApuestaPar) {
    			premioTotal = premioTotal + ((ApuestaPar)apuesta).getPremio(pNum);
    		}
    		else {
    			premioTotal = premioTotal + ((ApuestaNumero)apuesta).getPremio(pNum);
    		}
    	}
    	return premioTotal;
    }
    
    public int cantidad() {
    	return this.lista.size();
    }
    
    public void reset() {
    	this.lista.clear();
    }

    
    
}