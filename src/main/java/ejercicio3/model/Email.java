package ejercicio3.model;

public class Email {
    private final String email;

    public Email(String email) {
        if (!checkEmail(email)) {
            throw new RuntimeException("El email ingresado no es válido");
        }
        this.email = email;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String formatoSimple() {
        return this.email;
    }
}
