package BilgenKaanRemzi.SpringBoot2.exceptions;

public class NotFoundException extends RuntimeException{
public NotFoundException(int id) {
    super("Elemento cod id " + id + " non trovato!");
}
}
