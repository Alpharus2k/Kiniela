package domain;

import java.util.Comparator;

import factory.Ticket;

public class Ganador implements Comparable<Ganador>,Comparator<Ganador>{
	private Ticket ticket;
	private int numeroSorteo;
	private Integer cantAciertos;
	private double ganancia;
	protected Ganador(Ticket ticket, int numeroSorteo, int cantAciertos) {
		super();
		this.ticket = ticket;
		this.numeroSorteo = numeroSorteo;
		this.cantAciertos = cantAciertos;
		this.ganancia = 0;
	}
	protected double getGanancia() {
		return ganancia;
	}
	protected void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}
	protected Ticket getTicket() {
		return ticket;
	}
	protected int getNumeroSorteo() {
		return numeroSorteo;
	}
	protected int getCantAciertos() {
		return cantAciertos;
	}
	@Override
	public int compare(Ganador gan1, Ganador gan2) {
		
		return gan1.getCantAciertos()-gan2.getCantAciertos();
	}
	@Override
	public int compareTo(Ganador gan1) {
		return this.cantAciertos.compareTo((Integer) gan1.getCantAciertos());
	}
	//TODO FALTA ASIGNAR GANANCIA
	@Override
	public String toString() {
		return "Ganador [Numeros Jugados: "+this.ticket.numeroDelTicket() +" numeroSorteo=" + numeroSorteo + ", cantAciertos=" + cantAciertos
				+ ", ganancia $" + ganancia + "]";
	}
	
	
	
	
}
