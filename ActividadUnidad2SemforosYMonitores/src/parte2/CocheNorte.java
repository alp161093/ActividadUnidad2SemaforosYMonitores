package parte2;

public class CocheNorte extends Thread{
	private Puente puente;

	public CocheNorte(Puente puente) {
		this.puente = puente;
		start();
	}
	
	public void run() {
		while(true) {
			this.puente.cruzarNorteSur();
		}
	}
}
