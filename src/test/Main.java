package test;

import domain.Kiniela;
import factory.Ticket;
import negocio.AgenciaLoteria;


public class Main {

	public static void main(String[] args) {
		final String SALTO = "*** *** *** *** *** *** ***";
		Kiniela kini5 = Kiniela.getInstance();
		
		kini5.agregarSorteo("27/05/21");
		
		kini5.agregarSorteo("28/05/21");
		
		//Instancia Agencias de Loteria
		
		AgenciaLoteria ag1 = new AgenciaLoteria("Calle Siempre Viva 007", 01);
		AgenciaLoteria ag2 = new AgenciaLoteria("Calle Siempre Viva 107", 02);
		AgenciaLoteria ag3 = new AgenciaLoteria("Calle Siempre Viva 207", 03);
		AgenciaLoteria ag4 = new AgenciaLoteria("Calle Siempre Viva 307", 04);
		System.out.println(SALTO);
		
		
		for (int i = 0; i < 10; i++) {
			generarTickets(ag1,1000);
			generarTickets(ag2,1000);
			generarTickets(ag3,1000);
			generarTickets(ag4,1000);
		}
		ag2.emitirTicketManual(new int[]{02,14,26,31,40});	// este tiene 5 aciertos
		ag3.emitirTicketManual(new int[]{02,14,26,31,42});	// este tiene 4 aciertos
		ag4.emitirTicketManual(new int[]{02,14,26,31,43});	// este tiene 4 aciertos
		
		System.out.println("sizeDeTickets: " + kini5.sizeDeTickets());
		System.out.println(SALTO);
		kini5.establecerPozoAcumulado(1000000.50);
		System.out.println("Establecemos los numeros ganadores");
		kini5.cerrarSorteoConNumGanadores(new int[]{02,14,26,31,40});
		System.out.println(SALTO);
		
		kini5.listarGanadores();
		
	}

	private static void generarTickets(AgenciaLoteria agencia, int cantTickets) {
		for (int i = 0; i < cantTickets; i++) {
			agencia.emitirTicketAutomatico();
		}
		
	}
	

	
	
}
