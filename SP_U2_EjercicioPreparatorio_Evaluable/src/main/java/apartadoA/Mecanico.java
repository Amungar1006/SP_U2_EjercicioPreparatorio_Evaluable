package apartadoA;

import java.util.concurrent.Semaphore;

public class Mecanico implements Runnable{
	
	private Semaphore semaforo;
    private int idCoche;
    
    public Mecanico(Semaphore semaforo, int idCoche) {
        this.semaforo = semaforo;
        this.idCoche = idCoche;
    }

    
	public Semaphore getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	
	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}


	@Override
    public void run() {
        try 
        {
            semaforo.acquire(); 
            System.out.println("Mecánico reparando coche id-" +idCoche);
            Thread.sleep(5000); 
            System.out.println("Mecánico terminó de reparar coche id-" + idCoche);
        } 
        catch(InterruptedException e) {
            e.printStackTrace();
        } 
        finally 
        {
            semaforo.release(); 
        }
    }
}
    
    
	
