package br.com.luizalabs.designrest.veiculos.exceptions;

public class NotFoundException extends Exception {

    private String message;

    public NotFoundException(String msg) {
        super(msg);
    }
}
