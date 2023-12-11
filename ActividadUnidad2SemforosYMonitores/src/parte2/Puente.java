package parte2;

public class Puente {
	public boolean cruzandoVehiculoSurNorte = false;
	public boolean cruzandoVehiculoNorteSur = false;
	
	public synchronized void cruzarSurNorte() {
		
		if(cruzandoVehiculoNorteSur)
			try {
				System.out.println("El puente esta ocupado, esperado a que pase de Norte a Sur...");
				wait(); //dormimos el proceso y se libera el monitor porque se está esperando a que el puente esté libre
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("Cruzando el puente de Sur a Norte");
		cruzandoVehiculoSurNorte = true;
		notify(); //notificamos y despertamos otros procesos que estén dormidos
	}
	
	
	
	public synchronized void cruzarNorteSur() {
		if(cruzandoVehiculoSurNorte)
			try {
				System.out.println("El puente esta ocupado, esperado a que pase de Sur a Norte...");
				wait(); //dormimos el proceso y se libera el monitor porque se está esperando a que el puente esté libre
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("Cruzando el puente de Norte a Sur");
		cruzandoVehiculoNorteSur = true;
		notify(); //notificamos y despertamos otros procesos que estén dormidos
		
	}
}
