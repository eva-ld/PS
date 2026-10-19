package EjerciciosMultihilo.Ej4;

public class Consumidor implements Runnable {
    private AlmacenCOla almacen;

    public Consumidor(AlmacenCOla almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                almacen.consumir();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
