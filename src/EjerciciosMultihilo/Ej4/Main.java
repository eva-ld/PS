package EjerciciosMultihilo.Ej4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        AlmacenCOla almacen = new AlmacenCOla();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Productor(almacen));
        executor.execute(new Consumidor(almacen));

        executor.shutdown();
    }
}
