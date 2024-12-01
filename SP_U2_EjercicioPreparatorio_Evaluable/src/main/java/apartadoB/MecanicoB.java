package apartadoB;

import java.util.concurrent.Semaphore;

public class MecanicoB implements Runnable {

    private String nombre; 
    private Semaphore semaforoCoches; 
    private Semaphore semaforoMecanicos; 
    private int tiempoReparacion; 
    private ContadorCoches contadorCoches; 

    public MecanicoB(String nombre, Semaphore semaforoCoches, Semaphore semaforoMecanicos, int tiempoReparacion, ContadorCoches contadorCoches) {
        this.nombre = nombre;
        this.semaforoCoches = semaforoCoches;
        this.semaforoMecanicos = semaforoMecanicos;
        this.tiempoReparacion = tiempoReparacion;
        this.contadorCoches = contadorCoches;
    }

    @Override
    public void run() {
        while (contadorCoches.getNumeroCoches() > 0) {
            try 
            {
                semaforoMecanicos.acquire();
                if (contadorCoches.getNumeroCoches() > 0) {
                    System.out.println(nombre +" está reparando un coche.");
                    Thread.sleep(tiempoReparacion * 1000); 
                    contadorCoches.decrementar(); 
                    semaforoCoches.release(); 
                    System.out.println(nombre + " ha terminado de reparar un coche.");
                }
            } 
            catch(InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
        System.out.println(nombre +" ha terminado su jornada.");
    }
}
