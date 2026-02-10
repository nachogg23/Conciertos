import java.util.ArrayList;
import java.util.Objects;

public class Concierto {
    private String artista;
    private String ciudad;
    private double precioBase;
    private int aforoMaximo;
    private ArrayList<Entrada> entradasVendidas;
    private boolean activo;


    public Concierto(String artista, String ciudad, double precioBase, int aforoMaximo, ArrayList<Entrada> entradasVendidas, boolean activo) {
        this.artista = artista;
        this.ciudad = ciudad;
        this.precioBase = precioBase;
        this.aforoMaximo = aforoMaximo;
        this.entradasVendidas = entradasVendidas;
        this.activo = activo;
    }


    public Concierto() {
        this.entradasVendidas = new ArrayList<>();
    }


    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(ArrayList<Entrada> entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    public double calcularRecaudacion() {
        double recaudacionTotal = 0.0;

        for (Entrada entrada : entradasVendidas) {
            recaudacionTotal += entrada.getPrecioTotal();
        }

        return recaudacionTotal;
    }


    public double calcularPrecioMedio() {
        if (entradasVendidas.isEmpty()) {
            return 0.0;
        }

        return calcularRecaudacion() / entradasVendidas.size();
    }

    public boolean entradasDisponibles() {
        return entradasVendidas.size() < aforoMaximo;
    }

    @Override
    public String toString() {
        return "Concierto de " + artista + " en " + ciudad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concierto concierto = (Concierto) o;
        return Double.compare(precioBase, concierto.precioBase) == 0 &&
                aforoMaximo == concierto.aforoMaximo &&
                activo == concierto.activo &&
                Objects.equals(artista, concierto.artista) &&
                Objects.equals(ciudad, concierto.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artista, ciudad, precioBase, aforoMaximo, activo);
    }
}
