package EjerciciosMultihilo.Ej2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        ExecutorService executor = Executors.newFixedThreadPool(20);

        // 300 clientes intentando comprar
        for (int i = 1; i <= 300; i++) {
            executor.execute(new Cliente(i, tienda));
        }

        executor.shutdown();
    }
}
