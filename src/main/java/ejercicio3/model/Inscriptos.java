package ejercicio3.model;


public class Inscriptos {
    private RegistroInscriptos registroDeInscriptos;

    public Inscriptos(RegistroInscriptos registroDeInscriptos) {
        this.registroDeInscriptos = registroDeInscriptos;
    }

    public void nuevoParticipante(String apellido, String nombre, String telefono, String email, int idConcurso) {
        var inscripto = new Inscripto(nombre, apellido, telefono, email, idConcurso);
        this.registroDeInscriptos.registrar(inscripto);
    }
}