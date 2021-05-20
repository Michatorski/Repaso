package org.iesfm.repaso.bank.exceptions;

public class AccountAlreadyExistsExceptions extends Exception{

    private String iban;

    public AccountAlreadyExistsExceptions(String iban) {
        this.iban = iban;
    }

    public AccountAlreadyExistsExceptions(String message, String iban) {
        super(message);
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }
}
