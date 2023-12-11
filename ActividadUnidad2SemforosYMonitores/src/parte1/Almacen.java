package parte1;
import java.util.concurrent.Semaphore;

public class Almacen {
	
	public final int  unidades = 20;
	
	private int unidadesReservadas = 0;
	private Semaphore reserva = new Semaphore(unidades, true);
	private Semaphore unidadesParaLiberar = new Semaphore(0, true); 
	
	
	public int getUnidadesReservadas() {
		return unidadesReservadas;
	}
	public void setUnidadesReservadas(int unidadesReservadas) {
		this.unidadesReservadas = unidadesReservadas;
	}	
	public Semaphore getReserva() {
		return reserva;
	}
	public Semaphore getunidadesParaLiberar() {
		return unidadesParaLiberar;
	}
}
