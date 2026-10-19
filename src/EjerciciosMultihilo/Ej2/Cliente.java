package EjerciciosMultihilo.Ej2;

public class Cliente implements Runnable {
    private int idCliente;
    private Tienda tienda;

    public Cliente(int idCliente, Tienda tienda) {
        this.idCliente = idCliente;
        this.tienda = tienda;
    }

    @Override
    public void run() {
        int intentos = 0;
        boolean entro = false;

        while (intentos < 10 && !entro) {
            intentos++;
            // Acceso exclusivo a la puerta
            synchronized (tienda) {
                entro = true;
            }

            try {
                Thread.sleep(100); // Espera entre intentos
            } catch (InterruptedException e) {
                break;
            }
        }

        if (entro) {
            boolean compro = tienda.intentarEntrarYComprar();
            if (compro) {
                System.out.println("Cliente " + idCliente + " entró y consiguió el producto.");
            } else {
                System.out.println("Cliente " + idCliente + " entró pero ya no quedan productos.");
            }
        } else {
            System.out.println("Cliente " + idCliente + " desistió tras 10 intentos y se marchó.");
        }
    }
}
