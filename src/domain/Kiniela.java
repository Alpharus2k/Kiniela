package domain;

import java.util.ArrayList;


public class Kiniela {
	private static Kiniela kiniela;
	private final String nombre;
	
	private ArrayList<Sorteo> sorteos; //Podría ser pila o lista ordenada
//Constructor
	private Kiniela() {
		this.nombre = "Kiniela Global";
		this.sorteos = new ArrayList<>();
	}
	public static synchronized Kiniela getInstance()  {
		if(kiniela == null) {
			kiniela = new Kiniela();
		}
		return kiniela;
	}
	public void agregarSorteo(String fecha) {
		if(!sorteos.isEmpty() && !sorteos.get(sorteos.size()-1).isActivo()) { //verificar si el ultimo sorteo NO isActivo
				sorteos.add(new Sorteo(fecha));
			
		}
	}
	
	
	
	//agregar tickets a los sorteos
	//buscar ganadores
	
	
	
	
}
