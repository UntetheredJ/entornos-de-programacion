package uis.edu.entornos.ejemplo0002.model;

public class Curso {
    // Class attributes
    private String nombre;
    private int duracion;
    private String horario;

    // Empty constructor
    public Curso() {
    }

    // Constructor
    public Curso(String nombre, int duracion, String horario) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.horario = horario;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
