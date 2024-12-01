package apartadoB;

import java.util.concurrent.Semaphore;

public class CocheB implements Runnable {

    private int id; 
    private Semaphore semaforoCoches; 
    private Semaphore semaforoMecanicos; 

    public CocheB(int id, Semaphore semaforoCoches, Semaphore semaforoMecanicos) {
        this.id = id;
        this.semaforoCoches = semaforoCoches;
        this.semaforoMecanicos = semaforoMecanicos;
    }

    @Override
    public void run() {
        try 
        {
            System.out.println("Coche id-" +id + " está esperando para ser reparado.");
            semaforoMecanicos.release(); 
            semaforoCoches.acquire(); 
            System.out.println("Coche id-" +id + " ha sido reparado y se va del taller.");
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}
