import java.util.List;

public class Cliente {

    String nombre;
    List<Producto> productos;

    public Cliente(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
}
