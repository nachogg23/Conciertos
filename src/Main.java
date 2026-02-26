import exceptions.*;

public class Main {
    public static void main(String[] args) {
        Concierto c1 = new Concierto();
        c1.setArtista("Metallica");
        c1.setAforoMaximo(1);
        c1.setActivo(true);

        Concierto c2 = new Concierto();
        c2.setArtista("Coldplay");
        c2.setInactivo(true);

        Usuario u1 = new Usuario();
        u1.setNombre("Ana");

        System.out.println("INICIO DE PRUEBAS DE EXCEPCIONES ");

        try {
            c1.calcularPrecioMedio();
        } catch (CeroEntradasException e) {
            System.out.println("1. CAPTURADA: " + e.getMessage());
        }

        try {
            u1.comprarEntrada(c2, TipoEntrada.PISTA);
        } catch (Exception e) {
            System.out.println("2. CAPTURADA: " + e.getMessage());
        }

        try {
            u1.comprarEntrada(c1, TipoEntrada.PISTA);
            Usuario u2 = new Usuario();
            u2.comprarEntrada(c1, TipoEntrada.PISTA);
        } catch (Exception e) {
            System.out.println("3. CAPTURADA: " + e.getMessage());
        }

        try {
            u1.comprarEntrada(c1, TipoEntrada.VIP);
        } catch (Exception e) {
            System.out.println("4. CAPTURADA: " + e.getMessage());
        }

        try {
            u1.valorar(c1, 99); // Nota imposible
        } catch (Exception e) {
            System.out.println("5. CAPTURADA: " + e.getMessage());
        }

        try {
            Usuario u3 = new Usuario();
            u3.valorar(c1, 10);
        } catch (Exception e) {
            System.out.println("6. CAPTURADA: " + e.getMessage());
        }
    }
}
