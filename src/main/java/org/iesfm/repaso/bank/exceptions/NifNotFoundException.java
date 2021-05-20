package org.iesfm.repaso.bank.exceptions;

public class NifNotFoundException extends Exception {
    private String nif;

    public NifNotFoundException(String nif) {
        this.nif = nif;
    }

    public NifNotFoundException(String message, String nif) {
        super(message);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
