package apartadoA;

import java.util.concurrent.Semaphore;

public class Taller {
	
	
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1); 

        int numCoches = 20; 
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= numCoches; i++) {
            Thread hiloMecanico = new Thread(new Mecanico(semaforo, i));
            hiloMecanico.start();
            try 
            {
                hiloMecanico.join();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("El mecanico tardó " +(endTime - startTime)  / 1000.0 + " segundos en reparar todos los coches.");
    }
	

}
