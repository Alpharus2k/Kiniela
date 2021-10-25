package domain;

import java.util.ArrayList;

public class Sorteo {
//Atributos	
	//Constantes de porcentaje de premios para cada lugar
	private static final double PRIMERO = 97.14497;
	private static final double SEGUNDO = 2.19618;
	private static final double TERCERO = 0.65885;
	//Montos que se llevan los ganadores
	private double primero;
	private double segundo;
	private double tercero;	
	
	//lista de ID de locales de venta admitidos o algo asi
	private int[] localesHabilitados = {1,2,3,4,5,6,7};
	//listas de ganadores ordenados por: idLocal y Aciertos
	
	
	private double pozoAcumulado;
	
	//Calcular las ganancias y mostrarlas con DF Format o round
	
	

	
	private static int contadorSorteo = 0;
	private int numeroSorteo;
	private String fechaSorteo;
	private ArrayList<Ticket> tickets;
	private int numerosGanadores[] = {-1,-1,-1,-1,-1};
	private boolean activo;		//Hay un unico sorteo activo a la vez
//Constructor
	private Sorteo() {
		this.numeroSorteo = ++contadorSorteo;
		this.activo = true;
	}
	protected Sorteo(String fechaSorteo) {
		this();
		this.fechaSorteo = fechaSorteo;
		this.tickets = new ArrayList<>();
	}
	protected void agregarTicket(Ticket ticket) {
		
	}
	
	//agregar tickets - crear un generador Random
	//comprobar que los numeros del ticket sean validos
	//instanciar e ingresar los numeros ganadores
	//buscar los tickets ganadores con x /x1 /x2 aciertos
	//agruparlos por ID de local
	
	
	
//Metodos Varios	
	private void calcularMontosGanadores() {
		this.primero = pozoAcumulado * Sorteo.PRIMERO;
		this.segundo = pozoAcumulado * Sorteo.SEGUNDO;
		this.tercero = pozoAcumulado * Sorteo.TERCERO;
	}
//toString
	@Override
	public String toString() {
		return "Sorteo N°: " + numeroSorteo + ", Fecha: " + fechaSorteo;
	}
//Getters Setters
	protected boolean isActivo() {
		return activo;
	}
	protected void setActivo(boolean activo) {
		this.activo = activo;
	}
	protected void setPozoAcumulado(double pozoAcumulado) {
		this.pozoAcumulado = pozoAcumulado;
		calcularMontosGanadores();
	}
}
