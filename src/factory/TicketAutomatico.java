package factory;

import java.util.ArrayList;
import java.util.Collections;

public class TicketAutomatico extends Ticket {
	private static final ArrayList<Integer> POSIBLE_NUM = generarNumeros();
	
	public TicketAutomatico(int idAgenciaLoteria) {
		super(idAgenciaLoteria, generarNumRandom());
	}
	
	//Genera un lista con todos los posibles números
	private static ArrayList<Integer> generarNumeros() {
		ArrayList<Integer> retorno = new ArrayList<>();
		for (int i = NUM_MINIMO; i <= NUM_MAXIMO; i++) {
			retorno.add(i);
		}
		return retorno;
	}
	
	//Genera un Arreglo de 5 elemenos Unicos
	public static int[] generarNumRandom() {
		int[] retorno = new int[NUM_JUGADAS_MAX];
		 ArrayList<Integer> listaAux = (ArrayList<Integer>) POSIBLE_NUM.clone();
		 Collections.shuffle(listaAux);	
		 for (int i = 0; i < Ticket.NUM_JUGADAS_MAX; i++) {
			retorno[i] = listaAux.remove((int) (Math.random() * (listaAux.size())));
		}
		 
		return retorno;
	}

}
