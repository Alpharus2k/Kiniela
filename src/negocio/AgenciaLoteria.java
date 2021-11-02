package negocio;
import domain.Kiniela;
import factory.*;

public class AgenciaLoteria {
	private int idLocal;
	private String direccion;
	
	public AgenciaLoteria(String direccion, int idLocal) {
		this.direccion = direccion;
		this.idLocal = idLocal;
	}
	//Hacer tickets y agregarlos al sorteo
	public void emitirTicketManual(int[] numeros) {
		boolean mostrar = agregarTicket(new TicketManual(this.idLocal, numeros));
	//	System.out.println("Se pudo agregar el ticket: "+mostrar);
	}
	public void emitirTicketAutomatico() {
		boolean mostrar = agregarTicket(new TicketAutomatico(this.idLocal));
	//	System.out.println("Se pudo agregar el ticket: "+mostrar);
	}
	
	private boolean agregarTicket(Ticket ticket) {
		return Kiniela.getInstance().agregarTicketAlSorteo(ticket);
	}
}
