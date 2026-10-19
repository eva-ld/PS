package EjerciciosMultihilo.Ej3;

public class Transaccion implements Runnable {
    private CuentaBancaria cuenta;
    private int cantidad;

    public Transaccion(CuentaBancaria cuenta, int cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cuenta.operar(cantidad);
    }
}