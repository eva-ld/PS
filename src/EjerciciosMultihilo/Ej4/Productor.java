package EjerciciosMultihilo.Ej4;

public class Productor implements Runnable {
    private AlmacenCOla almacen;

    public Productor(AlmacenCOla almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                almacen.producir(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
