package parte1;

//consumidor
public class Reservar extends Thread{
	public Almacen almacen;
	public int unidadesAReservar;
	
	public Reservar(Almacen a, int n) {
		this.almacen = a;
		this.unidadesAReservar = n;
		start();
	}
	
	
	public void run() {
		
		while(true) {
			try {
				//si hay unidades para liberar entonces nos deja continuar, si no hay unidades para liberar no nos deja continuar
				almacen.getReserva().acquire(this.unidadesAReservar);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			
			almacen.getunidadesParaLiberar().release(this.unidadesAReservar);
			this.almacen.setUnidadesReservadas(this.almacen.getUnidadesReservadas() + this.unidadesAReservar);
			System.out.println("El numero de reservas es " + this.almacen.getUnidadesReservadas());
		}
	}
}
