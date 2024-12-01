package apartadoB;

public class ContadorCoches {
    private int numeroCoches;

    public ContadorCoches(int numeroCoches) {
        this.numeroCoches = numeroCoches;
    }

    public synchronized int getNumeroCoches() {
        return numeroCoches;
    }

    public synchronized void decrementar() {
        if (numeroCoches > 0) {
            numeroCoches--;
        }
    }
}
