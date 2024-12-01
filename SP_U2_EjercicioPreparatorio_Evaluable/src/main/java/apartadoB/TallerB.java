package apartadoB;

import java.util.concurrent.Semaphore;

public class TallerB {

    public static void main(String[] args) {
    	
        Semaphore semaforoCoches = new Semaphore(1); 
        Semaphore semaforoMecanicos = new Semaphore(1); 
        ContadorCoches contadorCoches = new ContadorCoches(20);

        String nombre1 = "Pepe";
        String nombre2 = "Antonio";
        Thread mecanico1 = new Thread(new MecanicoB(nombre1, semaforoCoches, semaforoMecanicos, 5, contadorCoches));
        Thread mecanico2 = new Thread(new MecanicoB(nombre2, semaforoCoches, semaforoMecanicos, 8, contadorCoches));

        mecanico1.start();
        mecanico2.start();

        for (int i = 1; i <= contadorCoches.getNumeroCoches(); i++) {
        	
            Thread coche = new Thread(new CocheB(i, semaforoCoches, semaforoMecanicos));
            coche.start();
        }

        try 
        {
            mecanico1.join();
            mecanico2.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        System.out.println("Todos los coches han sido reparados.");
    }
}
