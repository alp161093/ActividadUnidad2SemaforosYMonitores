package parte1;

public class Main {

	static Almacen almacen = new Almacen();
	public static void main(String[] args) {
		// Configuración de parámetros
        int n = 5;  // Número de procesos
        int k = 3;  // Número de unidades del recurso

       

        // Crear e iniciar los procesos
        for (int i = 0; i < n; i++) {
            Thread procesoThread = new Thread(new Reservar(almacen, 2));
            procesoThread.start();

            // Simular el proceso de liberación después de un tiempo
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    Liberar proceso = new Liberar(almacen, 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

	}

}
