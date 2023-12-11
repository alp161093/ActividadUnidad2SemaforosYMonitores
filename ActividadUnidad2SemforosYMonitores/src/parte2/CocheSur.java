package parte2;

public class CocheSur extends Thread{
	private Puente puente;

	public CocheSur(Puente puente) {
		this.puente = puente;
		start();
	}
	
	public void run() {
		while(true) {
			this.puente.cruzarSurNorte();
		}
	}
}
