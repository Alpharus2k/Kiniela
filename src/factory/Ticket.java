package factory;

import domain.Sorteo;

public abstract class Ticket {
	public static final int NUM_MINIMO = 0;
	public static final int NUM_MAXIMO = 43;
	public static final int NUM_JUGADAS_MAX = Sorteo.MAX_ACIERTO;
	
	private int idAgenciaLoteria; 
	private final int[] numeros;
//Constructor
	protected Ticket(int idAgenciaLoteria, int[] numeros) {
		this.idAgenciaLoteria = idAgenciaLoteria;
		this.numeros = numeros;
	}
	public int[] getNumeros() {
		return numeros;
	}
	public int getIdAgenciaLoteria() {
		return idAgenciaLoteria;
	}
	public String numeroDelTicket() {
		StringBuilder retorno = new StringBuilder();
		for (int i = 0; i < numeros.length; i++) {
			retorno.append(numeros[i]).append(", ");
		}
		return retorno.toString();
	}
	
}
