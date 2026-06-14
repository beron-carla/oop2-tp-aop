package ejercicio3.services;

import ejercicio3.model.Concurso;
import ejercicio3.model.RegistroDeConcursos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class LectorTxtConcursos implements RegistroDeConcursos {
    private String path;

    public LectorTxtConcursos(String path) {
        this.path = path;
    }

    @Override
    public List<Concurso> concursos() {
        List<Concurso> concursos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] partes = linea.split(",\\s*");
                if (partes.length != 4) continue; // saltar líneas inválidas

                int idConcurso = Integer.parseInt(partes[0]);
                String nombreConcurso = partes[1];
                LocalDate fechaInicioInscripcion = LocalDate.parse(partes[2], formatter);
                LocalDate fechaFinInscripcion = LocalDate.parse(partes[3], formatter);

                Concurso concurso = new Concurso(idConcurso, nombreConcurso, fechaInicioInscripcion, fechaFinInscripcion);
                concursos.add(concurso);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }

        return concursos;
    }
}