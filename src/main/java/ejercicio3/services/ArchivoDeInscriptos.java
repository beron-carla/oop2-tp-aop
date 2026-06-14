package ejercicio3.services;

import ejercicio3.model.Inscripto;
import ejercicio3.model.RegistroInscriptos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ArchivoDeInscriptos implements RegistroInscriptos {
    final String FECHAINSCRIPCION_VACIA = "La fecha de inscripción no puede ser null";
    private String path;

    public ArchivoDeInscriptos(String filePath) {
        this.path = filePath;
    }

    @Override
    public void registrar(Inscripto inscripto) {

        String linea = inscripto.apellido() + ", " + inscripto.nombre() + ", " + inscripto.telefono() + ", " + inscripto.email() + ", " + inscripto.idConcurso();

        final Path path = Paths.get(this.path);
        try {
            Files.write(path, Arrays.asList(linea), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*---*/


