import java.util.ArrayList;
import exceptions.CeroEntradasException;

public class Concierto {
    private String artista;
    private String ciudad;
    private double precioBase;
    private int aforoMaximo;
    private ArrayList<Entrada> entradasVendidas = new ArrayList<>();
    private boolean activo;
    private boolean inactivo; // Variable solicitada

    public Concierto() {}

    // Sincronización de estados
    public void setActivo(boolean activo) {
        this.activo = activo;
        this.inactivo = !activo;
    }

    public boolean isActivo() { return activo; }
    public boolean isInactivo() { return inactivo; }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
        this.activo = !inactivo;
    }

    // Getters y Setters necesarios
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public double getPrecioBase() { return precioBase; }
    public void setAforoMaximo(int aforoMaximo) { this.aforoMaximo = aforoMaximo; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public ArrayList<Entrada> getEntradasVendidas() { return entradasVendidas; }

    // Métodos de lógica
    public double calcularRecaudacion() {
        double total = 0.0;
        for (Entrada e : entradasVendidas) total += e.getPrecioTotal();
        return total;
    }

    public double calcularPrecioMedio() throws CeroEntradasException {
        if (entradasVendidas.isEmpty()) {
            throw new CeroEntradasException("Error: No hay entradas vendidas para " + artista);
        }
        return calcularRecaudacion() / entradasVendidas.size();
    }

    public boolean entradasDisponibles() {
        return entradasVendidas.size() < aforoMaximo;
    }

    @Override
    public String toString() { return "Concierto de " + artista; }
}