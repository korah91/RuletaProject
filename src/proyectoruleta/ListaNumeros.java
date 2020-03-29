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
	
	/* 
	private String color; 
	private int  numero;
	private String par;
	private String docena; 
	private String  mitad; 
	private String familia; */
	
	public void generarNumeros() {
		Numero numero0 = new Numero("verde",0,"par","0","0","vecinos");
		Numero numero1 = new Numero("rojo",1,"impar","primera docena","primera mitad","huerfanos");
		Numero numero2 = new Numero("negro",2,"par","primera docena","primera mitad","vecinos");
		Numero numero3 = new Numero("rojo",3,"impar","primera docena","primera mitad","vecinos");
		Numero numero4 = new Numero("negro",4,"par","primera docena","primera mitad","vecinos" );
		Numero numero5 = new Numero("rojo",5,"impar","primera docena","primera mitad","tercios" );
		Numero numero6 = new Numero("negro",6,"par","primera docena","primera mitad","huerfanos");
		Numero numero7 = new Numero("rojo",7,"impar","primera docena","primera mitad","vecinos");
		Numero numero8 = new Numero("negro",8,"par","primera docena","primera mitad","tercios");
		Numero numero9 = new Numero("rojo",9,"impar","primera docena","primera mitad","huerfanos");
		Numero numero10 = new Numero("negro",10,"par","primera docena","primera mitad","tercios");
		Numero numero11 = new Numero("negro",11,"impar","primera docena","primera mitad","tercios");
		Numero numero12 = new Numero("rojo",12,"par","primera docena","primera mitad","vecinos");
		Numero numero13 = new Numero("negro",13,"impar","segunda docena","primera mitad","tercios");
		Numero numero14 = new Numero("rojo",14,"par","segunda docena","primera mitad","huerfanos");
		Numero numero15 = new Numero("negro",15,"impar","segunda docena","primera mitad","vecinos");
		Numero numero16 = new Numero("rojo",16,"par","segunda docena","primera mitad","tercios");
		Numero numero17 = new Numero("negro",17,"impar","segunda docena","primera mitad","huerfanos");
		Numero numero18 = new Numero("rojo",18,"par","segunda docena","primera mitad","vecinos");
		Numero numero19 = new Numero("rojo",19,"impar","segunda docena","segunda mitad","vecinos");
		Numero numero20 = new Numero("negro",20,"par","segunda docena","segunda mitad","huerfanos");
		Numero numero21 = new Numero("rojo",21,"impar","segunda docena","segunda mitad","vecinos");
		Numero numero22 = new Numero("negro",22,"par","segunda docena","segunda mitad","vecinos");
		Numero numero23 = new Numero("rojo",23,"impar","segunda docena","segunda mitad","tercios");
		Numero numero24 = new Numero("negro",24,"par","segunda docena","segunda mitad","tercios");
		Numero numero25 = new Numero("rojo",25,"impar","tercera docena","segunda mitad","vecinos");
		Numero numero26 = new Numero("negro",26,"par","tercera docena","segunda mitad","vecinos");
		Numero numero27 = new Numero("rojo",27,"impar","tercera docena","segunda mitad","tercios");
		Numero numero28 = new Numero("negro",28,"par","tercera docena","segunda mitad","vecinos");
		Numero numero29 = new Numero("negro",29,"impar","tercera docena","segunda mitad","vecinos");
		Numero numero30 = new Numero("rojo",30,"par","tercera docena","segunda mitad","tercios");
		Numero numero31 = new Numero("negro",31,"impar","tercera docena","segunda mitad","huerfanos");
		Numero numero32 = new Numero("rojo",32,"par","tercera docena","segunda mitad","vecinos");
		Numero numero33 = new Numero("negro",33,"impar","tercera docena","segunda mitad","tercios");
		Numero numero34 = new Numero("rojo",34,"par","tercera docena","segunda mitad","huerfanos");
		Numero numero35 = new Numero("negro",35,"impar","tercera docena","segunda mitad","vecinos");
		Numero numero36 = new Numero("rojo",36,"par","tercera docena","segunda mitad","tercios");
		
		lista.add(numero0);
		lista.add(numero1);
		lista.add(numero2);
		lista.add(numero3);
		lista.add(numero4);
		lista.add(numero5);
		lista.add(numero6);
		lista.add(numero7);
		lista.add(numero8);
		lista.add(numero9);
		lista.add(numero10);
		lista.add(numero11);
		lista.add(numero12);
		lista.add(numero13);
		lista.add(numero14);
		lista.add(numero15);
		lista.add(numero16);
		lista.add(numero17);
		lista.add(numero18);
		lista.add(numero19);
		lista.add(numero20);
		lista.add(numero21);
		lista.add(numero22);
		lista.add(numero23);
		lista.add(numero24);
		lista.add(numero25);
		lista.add(numero26);
		lista.add(numero27);
		lista.add(numero28);
		lista.add(numero29);
		lista.add(numero30);
		lista.add(numero31);
		lista.add(numero32);
		lista.add(numero33);
		lista.add(numero34);
		lista.add(numero35);
		lista.add(numero36);
	}
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
	
	public int cuantosNumeros() {
		return(lista.size());
	}
	
	

}
