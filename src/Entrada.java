import java.util.Objects;

public class Entrada {
    // Atributos
    private Concierto concierto;
    private TipoEntrada tipo;

    // Constructor completo
    public Entrada(Concierto concierto, TipoEntrada tipo) {
        this.concierto = concierto;
        this.tipo = tipo;
    }

    // Constructor vacío
    public Entrada() {
    }

    // Getters y Setters
    public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        this.concierto = concierto;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrada tipo) {
        this.tipo = tipo;
    }


    public double getPrecioTotal() {
        double precioBase = concierto.getPrecioBase();

        switch (tipo) {
            case GRADA:
                return precioBase;
            case PISTA:
                return precioBase * 1.10; // 10% de recargo
            case VIP:
                return precioBase * 1.20; // 20% de recargo
            default:
                return precioBase;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Entrada de " + getPrecioTotal() + " €";
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(concierto, entrada.concierto) && tipo == entrada.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(concierto, tipo);
    }
}
