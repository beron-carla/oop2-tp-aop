package ejercicio3.model;

import java.time.LocalDate;

public class Concurso {
    private final int idConcurso;
    private final String nombre;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;


    public Concurso(int idConcurso, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        this.idConcurso = idConcurso;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public String nombre() {
        return this.nombre;
    }

    public int id() {
        return this.idConcurso;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}

