package EjerciciosMultihilo.Ej4;

import java.util.LinkedList;
import java.util.Queue;

public class AlmacenCOla {
    private Queue<Integer> cola = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public synchronized void producir(int valor) throws InterruptedException {
        while (cola.size() == CAPACIDAD) {
            wait(); // Espera si la cola está llena
        }
        cola.add(valor);
        System.out.println("Producido: " + valor);
        notifyAll(); // Notifica a los consumidores
    }

    public synchronized void consumir() throws InterruptedException {
        while (cola.isEmpty()) {
            wait(); // Espera si la cola está vacía
        }
        int valor = cola.poll();
        System.out.println("Consumido: " + valor);
        notifyAll(); // Notifica a los productores
    }
}