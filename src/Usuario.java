import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import exceptions.*;

public class Usuario {
    private String nombre;
    private int edad;
    private ArrayList<Entrada> entradasCompradas;
    private HashSet<Concierto> conciertosAsistidos;
    private HashMap<Concierto, Integer> valoraciones;

    public Usuario(String nombre, int edad, ArrayList<Entrada> entradasCompradas, HashSet<Concierto> conciertosAsistidos, HashMap<Concierto, Integer> valoraciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.entradasCompradas = entradasCompradas;
        this.conciertosAsistidos = conciertosAsistidos;
        this.valoraciones = valoraciones;
    }

    public Usuario() {
        this.entradasCompradas = new ArrayList<>();
        this.conciertosAsistidos = new HashSet<>();
        this.valoraciones = new HashMap<>();
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public ArrayList<Entrada> getEntradasCompradas() { return entradasCompradas; }
    public void setEntradasCompradas(ArrayList<Entrada> entradasCompradas) { this.entradasCompradas = entradasCompradas; }
    public HashSet<Concierto> getConciertosAsistidos() { return conciertosAsistidos; }
    public void setConciertosAsistidos(HashSet<Concierto> conciertosAsistidos) { this.conciertosAsistidos = conciertosAsistidos; }
    public HashMap<Concierto, Integer> getValoraciones() { return valoraciones; }
    public void setValoraciones(HashMap<Concierto, Integer> valoraciones) { this.valoraciones = valoraciones; }





    public void comprarEntrada(Concierto concierto, TipoEntrada tipo)
            throws ConciertoInactivoException, ConciertoYaAsistidoException, AforoCompletoException {


        if (concierto.isInactivo()) {
            throw new ConciertoInactivoException("Error: El concierto de " + concierto.getArtista() + " no está activo.");
        }


        if (conciertosAsistidos.contains(concierto)) {
            throw new ConciertoYaAsistidoException("Error: Ya has asistido al concierto de " + concierto.getArtista());
        }


        if (!concierto.entradasDisponibles()) {
            throw new AforoCompletoException("Error: No hay entradas disponibles para " + concierto.getArtista());
        }


        Entrada nuevaEntrada = new Entrada(concierto, tipo);
        concierto.getEntradasVendidas().add(nuevaEntrada);
        entradasCompradas.add(nuevaEntrada);
        conciertosAsistidos.add(concierto);

        System.out.println("Entrada comprada con éxito: " + nuevaEntrada);
    }

    public void valorar(Concierto concierto, int valoracion)
            throws ConciertoNoAsistidoException, ValoracionIncorrectaException {


        if (!conciertosAsistidos.contains(concierto)) {
            throw new ConciertoNoAsistidoException("Error: No has asistido al concierto de " + concierto.getArtista());
        }

        // 2. Verificamos rango de nota
        if (valoracion < 0 || valoracion > 10) {
            throw new ValoracionIncorrectaException("Error: La valoración (" + valoracion + ") debe estar entre 0 y 10.");
        }

        valoraciones.put(concierto, valoracion);
        System.out.println("Valoración registrada: " + valoracion + " para " + concierto.getArtista());
    }

    @Override
    public String toString() {
        return nombre + " (ha asistido a " + conciertosAsistidos.size() + " conciertos)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return edad == usuario.edad && Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }
}
