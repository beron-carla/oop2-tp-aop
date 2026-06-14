package ejercicio3.model;

public class Telefono {
    private final String telefono;

    public Telefono(String telefono) {
        if (!checkPhone(telefono)) {
            throw new RuntimeException("El teléfono ingresado no es válido.");
        }
        this.telefono = telefono;
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String formatoSimple() {
        return this.telefono;
    }
}
