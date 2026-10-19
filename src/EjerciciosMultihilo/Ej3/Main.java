package EjerciciosMultihilo.Ej3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cuenta = new CuentaBancaria();
        ExecutorService executor = Executors.newCachedThreadPool();

        // Procesos que ingresan dinero
        for (int i = 0; i < 40; i++) executor.execute(new Transaccion(cuenta, 100));
        for (int i = 0; i < 20; i++) executor.execute(new Transaccion(cuenta, 50));
        for (int i = 0; i < 60; i++) executor.execute(new Transaccion(cuenta, 20));

        // Procesos que retiran dinero
        for (int i = 0; i < 40; i++) executor.execute(new Transaccion(cuenta, -100));
        for (int i = 0; i < 20; i++) executor.execute(new Transaccion(cuenta, -50));
        for (int i = 0; i < 60; i++) executor.execute(new Transaccion(cuenta, -20));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Saldo final en la cuenta (Debe ser 100 €): " + cuenta.getSaldo() + " €");
    }
}
