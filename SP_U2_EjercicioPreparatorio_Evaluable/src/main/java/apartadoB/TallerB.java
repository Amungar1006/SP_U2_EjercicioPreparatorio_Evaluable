package apartadoB;

import java.util.concurrent.Semaphore;

public class TallerB {

    public static void main(String[] args) {
        Semaphore semaforoCoches = new Semaphore(0);
        Semaphore semaforoMecanicos = new Semaphore(0);

        ContadorCoches contadorCoches = new ContadorCoches(20);

        String nombre1 = "Antonio";
        String nombre2 = "Pepe";
        Thread mecanico1 = new Thread(new MecanicoB(nombre1, semaforoCoches, semaforoMecanicos, 5, contadorCoches));
        Thread mecanico2 = new Thread(new MecanicoB(nombre2, semaforoCoches, semaforoMecanicos, 8, contadorCoches));

        long inicio = System.currentTimeMillis(); 

        mecanico1.start();
        mecanico2.start();

        for (int i = 1; i <= contadorCoches.getNumeroCoches(); i++) 
        {
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

        long fin = System.currentTimeMillis(); 
        
        System.out.println("Tiempo total reparando coches: " +(fin - inicio) / 1000.0 + " segundos.");
    }
}
