package EjerciciosMultihilo.Ej1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Pool con 3 trabajadores (hilos)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Se envían 5 pedidos al grupo de hilos
        for (int i = 1; i <= 5; i++) {
            executor.execute(new Pedido(i));
        }

        executor.shutdown();
    }
}