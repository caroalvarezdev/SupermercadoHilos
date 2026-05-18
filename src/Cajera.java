public class Cajera extends Thread {

    String nombre;
    Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {

        double total = 0;

        System.out.println("🛒 Cajera " + nombre +
                " comienza a atender a " + cliente.nombre);

        for (Producto p : cliente.productos) {

            System.out.println("Procesando producto: " + p.nombre);

            total += p.precio;

            try {
                Thread.sleep(p.tiempoProcesamiento * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Producto procesado: " + p.nombre +
                    " | Precio: $" + p.precio +
                    " | Tiempo: " + p.tiempoProcesamiento + " segundos");
        }

        System.out.println("✅ Cajera " + nombre +
                " terminó la compra. Total: $" + total);
    }
}
