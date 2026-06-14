package ejercicio3.model;


public class Inscripto {

    private final String apellido;
    private final String nombre;
    private final int idConcurso;
    private final Telefono telefono;
    private final Email email;

    public Inscripto(String nombre, String apellido, String telefono, String email, int idConcurso) {
        if (nombre.isEmpty()) {
            throw new RuntimeException("el nombre ingresado es inválido");
        }
        if (apellido.isEmpty()) {
            throw new RuntimeException("el apellido ingresado es inválido");
        }

        this.apellido = apellido;
        this.nombre = nombre;
        this.idConcurso = idConcurso;
        this.telefono = new Telefono(telefono);
        this.email = new Email(email);
    }

    public String apellido() {
        return this.apellido;
    }

    public String nombre() {
        return this.nombre;
    }

    public int idConcurso() {
        return this.idConcurso;
    }

    public String telefono() {
        return this.telefono.formatoSimple();
    }

    public String email() {
        return this.email.formatoSimple();
    }
}
