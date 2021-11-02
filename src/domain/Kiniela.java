package domain;

import java.util.Stack;

import factory.Ticket;

public class Kiniela {
	private static Kiniela kiniela;
	private final String nombre;
	
	private Stack<Sorteo> pilaSorteos;
	
//Constructor
	private Kiniela() {
		this.nombre = "Kini 5";
		this.pilaSorteos = new Stack<>();
	}
	public static synchronized Kiniela getInstance()  {
		if(kiniela == null) {
			kiniela = new Kiniela();
		}
		return kiniela;
	}
	public void agregarSorteo(String fechaSorteo) {		//TODO Podría ser TRY CATCH
		if(this.pilaSorteos.empty()) {
			this.pilaSorteos.push(new Sorteo(fechaSorteo));
		}else if(!this.pilaSorteos.peek().isActivo()) {
			this.pilaSorteos.push(new Sorteo(fechaSorteo));
		}else
			System.out.println("Lo siento, ya existe un sorteo activo");
	}
	public boolean agregarTicketAlSorteo(Ticket ticket) {
		boolean retorno = false;
		if (!this.pilaSorteos.empty() && this.pilaSorteos.peek().isActivo()) {
			retorno = this.pilaSorteos.peek().agregarTicket(ticket);
		}
		return retorno;
	}
	//DATOS TEMPORALES
	public int sizeDeTickets() {
		return this.pilaSorteos.peek().sizeTickets();
	}
	public void establecerPozoAcumulado(double pozoAcum) {
		if (!this.pilaSorteos.empty() && this.pilaSorteos.peek().isActivo()) {
			this.pilaSorteos.peek().setPozoAcumulado(pozoAcum);;
		}
	}
	public void cerrarSorteoConNumGanadores(int[] numGanadores) {
		if (!this.pilaSorteos.empty() && this.pilaSorteos.peek().isActivo()) {
			this.pilaSorteos.peek().setNumerosGanadores(numGanadores);
			this.pilaSorteos.peek().setActivo(false);
		}
	}
	public void listarGanadores() {
		this.pilaSorteos.peek().listarGanadores();
	}
	
	
	
}
