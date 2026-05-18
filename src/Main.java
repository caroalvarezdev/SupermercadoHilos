import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();

        // Productos cliente 1
        Producto p1 = new Producto("Leche", 5000, 2);
        Producto p2 = new Producto("Pan", 3000, 1);

        // Productos cliente 2
        Producto p3 = new Producto("Arroz", 7000, 3);
        Producto p4 = new Producto("Huevos", 12000, 2);

        // Productos cliente 3
        Producto p5 = new Producto("Gaseosa", 6000, 2);
        Producto p6 = new Producto("Café", 4000, 1);

        // Lista productos
        List<Producto> productosCliente1 = Arrays.asList(p1, p2);
        List<Producto> productosCliente2 = Arrays.asList(p3, p4);
        List<Producto> productosCliente3 = Arrays.asList(p5, p6);

        // Clientes
        Cliente cliente1 = new Cliente("Rocío", productosCliente1);
        Cliente cliente2 = new Cliente("Julian", productosCliente2);
        Cliente cliente3 = new Cliente("Carolina", productosCliente3);

        // Cajeras (hilos)
        Cajera cajera1 = new Cajera("Mariana", cliente1);
        Cajera cajera2 = new Cajera("Laura", cliente2);
        Cajera cajera3 = new Cajera("Sofía", cliente3);

        // Iniciar hilos
        cajera1.start();
        cajera2.start();
        cajera3.start();

        // Esperar a que terminen
        try {
            cajera1.join();
            cajera2.join();
            cajera3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();

        System.out.println("⏱️ Tiempo total de ejecución: "
                + ((fin - inicio) / 1000) + " segundos");
    }
}