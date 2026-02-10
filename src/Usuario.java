import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Entrada> getEntradasCompradas() {
        return entradasCompradas;
    }

    public void setEntradasCompradas(ArrayList<Entrada> entradasCompradas) {
        this.entradasCompradas = entradasCompradas;
    }

    public HashSet<Concierto> getConciertosAsistidos() {
        return conciertosAsistidos;
    }

    public void setConciertosAsistidos(HashSet<Concierto> conciertosAsistidos) {
        this.conciertosAsistidos = conciertosAsistidos;
    }

    public HashMap<Concierto, Integer> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(HashMap<Concierto, Integer> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public void comprarEntrada(Concierto concierto, TipoEntrada tipo) {
        if (!concierto.isActivo()) {
            System.out.println("Error: El concierto no está activo.");
            return;
        }

        if (conciertosAsistidos.contains(concierto)) {
            System.out.println("Error: Ya has asistido a este concierto.");
            return;
        }

        if (!concierto.entradasDisponibles()) {
            System.out.println("Error: No hay entradas disponibles.");
            return;
        }


        Entrada nuevaEntrada = new Entrada(concierto, tipo);

        concierto.getEntradasVendidas().add(nuevaEntrada);

        entradasCompradas.add(nuevaEntrada);

        conciertosAsistidos.add(concierto);

        System.out.println("Entrada comprada con éxito: " + nuevaEntrada);
    }


    public void valorar(Concierto concierto, int valoracion) {
        if (!conciertosAsistidos.contains(concierto)) {
            System.out.println("Error: No has asistido a este concierto.");
            return;
        }

        if (valoracion < 0 || valoracion > 10) {
            System.out.println("Error: La valoración debe estar entre 0 y 10.");
            return;
        }

        valoraciones.put(concierto, valoracion);
        System.out.println("Valoración registrada: " + valoracion + " para " + concierto);
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
