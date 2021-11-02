package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import factory.Ticket;

public class Sorteo {
	//Atributos	

		//Constantes de porcentaje de premios para cada lugar
		private static final int MIN_ACIERTO = 3;
		public static final int MAX_ACIERTO = 5;
		
		private static final double CINCO_ACIERTOS = 0.9714497;			
		private static final double CUATRO_ACIERTOS = 0.0219618;
		private static final double TRES_ACIERTOS = 0.0065885;
		//Contador de sorteos
		private static int contadorSorteo = 0;
		private int numeroSorteo;
		private List<Ganador> ganadoresDelSorteo;
		private String fechaSorteo;
		private ArrayList<Ticket> tickets;
		private int numerosGanadores[] = {-1,-1,-1,-1,-1};
		private boolean activo;		//Hay un unico sorteo activo a la vez
		private double pozoAcumulado;
		//Montos a dividir entre los ganadores de cada puesto
		private double[][] premios;
//Constructor
		private Sorteo() {
			this.numeroSorteo = ++contadorSorteo;
			this.activo = true;
			System.out.println("Se agregó un sorteo");
		}
		protected Sorteo(String fechaSorteo) {
			this();
			this.fechaSorteo = fechaSorteo;
			this.tickets = new ArrayList<>();
			this.ganadoresDelSorteo = new ArrayList<Ganador>();
			this.premios = new double[(MAX_ACIERTO-MIN_ACIERTO+1)][1];

		}
		protected void setPozoAcumulado(double pozoAcumulado) {
			this.pozoAcumulado = pozoAcumulado;
			calcularPremios();
		}
		private void calcularPremios() {
			
			this.premios[0][0] = this.pozoAcumulado* Sorteo.CINCO_ACIERTOS;
			this.premios[1][0] = this.pozoAcumulado* Sorteo.CUATRO_ACIERTOS;
			this.premios[2][0] = this.pozoAcumulado* Sorteo.TRES_ACIERTOS;
			System.out.println("Para 5 hay: $"+this.premios[0][0]);
			System.out.println("Para 4 hay: $"+this.premios[1][0]);
			System.out.println("Para 3 hay: $"+this.premios[2][0]);
		}
		protected boolean isActivo() {
			return activo;
		}
		protected boolean agregarTicket(Ticket ticket) {
			return this.tickets.add(ticket);	
		}
		protected void setNumerosGanadores(int[] numerosGanadores) {
			this.numerosGanadores = numerosGanadores;
		}
		protected void setActivo(boolean activo) {
			this.activo = activo;
			buscarGanadores();
		}
		private void buscarGanadores() {
			for (Ticket ticket : this.tickets) {
				int aciertos = buscarAciertos(ticket);
				if (aciertos >= MIN_ACIERTO) {
					this.ganadoresDelSorteo.add(new Ganador(ticket, this.numeroSorteo, aciertos));
				}
			}
			 Collections.sort(this.ganadoresDelSorteo);
			calcularAsignarPremios();			 
		}
		private void calcularAsignarPremios() {
			for (int i = MIN_ACIERTO; i <= MAX_ACIERTO; i++) {
				int cont = contarElementos(i, 0);
				asignarPremios(i, cont);
			}
		}
		private void asignarPremios(int i, int cont) {
			double premio = 0;
			switch (i) {
				case (3):
					
					premio = Math.round((this.premios[2][0]	/ cont) *100) /100d;
					break;
				case(4):
					premio = Math.round((this.premios[1][0]	/ cont) *100) /100d;
					break;
				case(5):
					premio = Math.round((this.premios[0][0]	/ cont) *100) /100d;
					break;
			}		
			for (Ganador ganador : ganadoresDelSorteo) {
				if(i == ganador.getCantAciertos()) {
					ganador.setGanancia(premio);
				}
			}
		}
		private int contarElementos(int i, int cont) {
			for (Ganador ganador : ganadoresDelSorteo) {
				if(i == ganador.getCantAciertos()) {
					cont++;
				}
			}
			return cont;
		}
			
		//contar ganadores por aciertos. 
		//asignar premios por acierto
		
		private int buscarAciertos(Ticket ticket) {
			int retorno = 0;
			tag:
			for (int i = 0; i < numerosGanadores.length; i++) {
				for (int j = 0; j < ticket.getNumeros().length; j++) {
					if(numerosGanadores[i]==ticket.getNumeros()[j]) {
						retorno++;
						continue tag;		//<- Salta al proximo ciclo si hay coincidencia
					}
				}
			}
			return retorno;
		}
		public void listarGanadores() {
			if(!this.ganadoresDelSorteo.isEmpty()) {
				System.out.println(this.ganadoresDelSorteo.size());
				for (Ganador ganador : ganadoresDelSorteo) {
					System.out.println(ganador);
				}
			}
		}
		
		//DATOS TEMPORALES
		protected int sizeTickets() {
			return this.tickets.size();
		}
		
		
		
		
}
