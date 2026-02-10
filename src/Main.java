import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE CONCIERTOS ===\n");

        // 1. Crear 3 conciertos
        Concierto concierto1 = new Concierto();
        concierto1.setArtista("Metallica");
        concierto1.setCiudad("Madrid");
        concierto1.setPrecioBase(50.0);
        concierto1.setAforoMaximo(100);
        concierto1.setEntradasVendidas(new ArrayList<>());
        concierto1.setActivo(true);

        Concierto concierto2 = new Concierto();
        concierto2.setArtista("Coldplay");
        concierto2.setCiudad("Barcelona");
        concierto2.setPrecioBase(60.0);
        concierto2.setAforoMaximo(150);
        concierto2.setEntradasVendidas(new ArrayList<>());
        concierto2.setActivo(true);

        Concierto concierto3 = new Concierto();
        concierto3.setArtista("Taylor Swift");
        concierto3.setCiudad("Valencia");
        concierto3.setPrecioBase(70.0);
        concierto3.setAforoMaximo(200);
        concierto3.setEntradasVendidas(new ArrayList<>());
        concierto3.setActivo(true);

        System.out.println("Conciertos creados:");
        System.out.println(concierto1);
        System.out.println(concierto2);
        System.out.println(concierto3);
        System.out.println();

        // 2. Crear 3 usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Ana García");
        usuario1.setEdad(25);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Carlos López");
        usuario2.setEdad(30);

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("María Rodríguez");
        usuario3.setEdad(22);

        System.out.println("Usuarios creados:");
        System.out.println(usuario1.getNombre());
        System.out.println(usuario2.getNombre());
        System.out.println(usuario3.getNombre());
        System.out.println();

        // 3. Hacer que cada usuario compre entradas para 2 conciertos
        System.out.println("=== COMPRA DE ENTRADAS ===\n");

        // Usuario 1 compra entradas
        System.out.println(usuario1.getNombre() + " comprando entradas:");
        usuario1.comprarEntrada(concierto1, TipoEntrada.VIP);
        usuario1.comprarEntrada(concierto2, TipoEntrada.PISTA);
        System.out.println();

        // Usuario 2 compra entradas
        System.out.println(usuario2.getNombre() + " comprando entradas:");
        usuario2.comprarEntrada(concierto2, TipoEntrada.GRADA);
        usuario2.comprarEntrada(concierto3, TipoEntrada.VIP);
        System.out.println();

        // Usuario 3 compra entradas
        System.out.println(usuario3.getNombre() + " comprando entradas:");
        usuario3.comprarEntrada(concierto1, TipoEntrada.PISTA);
        usuario3.comprarEntrada(concierto3, TipoEntrada.GRADA);
        System.out.println();

        // 4. Hacer que cada usuario valore 1 concierto
        System.out.println("=== VALORACIONES ===\n");

        System.out.println(usuario1.getNombre() + " valorando:");
        usuario1.valorar(concierto1, 9);
        System.out.println();

        System.out.println(usuario2.getNombre() + " valorando:");
        usuario2.valorar(concierto2, 8);
        System.out.println();

        System.out.println(usuario3.getNombre() + " valorando:");
        usuario3.valorar(concierto3, 10);
        System.out.println();

        // Mostrar estadísticas de los conciertos
        System.out.println("=== ESTADÍSTICAS DE CONCIERTOS ===\n");

        System.out.println(concierto1);
        System.out.println("Entradas vendidas: " + concierto1.getEntradasVendidas().size());
        System.out.println("Recaudación total: " + concierto1.calcularRecaudacion() + " €");
        System.out.println("Precio medio: " + concierto1.calcularPrecioMedio() + " €");
        System.out.println("Entradas disponibles: " + (concierto1.entradasDisponibles() ? "Sí" : "No"));
        System.out.println();

        System.out.println(concierto2);
        System.out.println("Entradas vendidas: " + concierto2.getEntradasVendidas().size());
        System.out.println("Recaudación total: " + concierto2.calcularRecaudacion() + " €");
        System.out.println("Precio medio: " + concierto2.calcularPrecioMedio() + " €");
        System.out.println("Entradas disponibles: " + (concierto2.entradasDisponibles() ? "Sí" : "No"));
        System.out.println();

        System.out.println(concierto3);
        System.out.println("Entradas vendidas: " + concierto3.getEntradasVendidas().size());
        System.out.println("Recaudación total: " + concierto3.calcularRecaudacion() + " €");
        System.out.println("Precio medio: " + concierto3.calcularPrecioMedio() + " €");
        System.out.println("Entradas disponibles: " + (concierto3.entradasDisponibles() ? "Sí" : "No"));
        System.out.println();

        // Mostrar información de los usuarios
        System.out.println("=== INFORMACIÓN DE USUARIOS ===\n");
        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
    }
}
