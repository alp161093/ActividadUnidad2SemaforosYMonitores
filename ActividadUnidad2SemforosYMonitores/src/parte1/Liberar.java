package parte1;

//Productor
public class Liberar extends Thread{
	public Almacen almacen;
	public int unidadesALiberar;
	
	public Liberar(Almacen a, int n) {
		this.almacen = a;
		this.unidadesALiberar = n;
		start();
	}
	
	
	
	public void run() {
		
		while(true) {
			try {
				//si hay unidades para liberar entonces nos deja continuar, si no hay unidades para liberar no nos deja continuar
				almacen.getunidadesParaLiberar().acquire(this.unidadesALiberar);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			System.out.println("Se acaban de liberar " + this.unidadesALiberar);
			almacen.getReserva().release(this.unidadesALiberar);
			this.almacen.setUnidadesReservadas(this.almacen.getUnidadesReservadas() - this.unidadesALiberar );
			System.out.println("Reservas disponibles " + this.almacen.getUnidadesReservadas());
		}
	}
}
