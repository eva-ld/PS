package EjerciciosMultihilo.Ej3;

public class CuentaBancaria {
    private int saldo = 100; // Saldo inicial

    // Metodo sincronizado para evitar condiciones de carrera
    public synchronized void operar(int cantidad) {
        saldo += cantidad;
    }

    public int getSaldo() {
        return saldo;
    }
}
