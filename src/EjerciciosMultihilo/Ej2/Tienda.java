package EjerciciosMultihilo.Ej2;

import java.util.concurrent.atomic.AtomicInteger;

public class Tienda {
    private AtomicInteger stock = new AtomicInteger(100); // 100 unidades disponibles

    public boolean intentarEntrarYComprar() {
        if (stock.get() > 0) {
            int actual = stock.decrementAndGet();
            if (actual >= 0) {
                return true; // Compra con éxito
            }
        }
        return false; // Se agotó el stock
    }
}
